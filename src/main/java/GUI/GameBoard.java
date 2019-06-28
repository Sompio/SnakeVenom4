package GUI;

import Components.Candy;
import Components.KeyListener;
import Components.Player;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    private DefaultTerminalFactory dtf;
    private Terminal terminal;
    private char block = '\u2588';
    private Position position;
    private ArrayList<Position> immovablePositionList;
    private ArrayList<Candy> candyList;
    private Position nextPos;
    private Player player1;
    private Scanner input;
    private TextGraphics textGraphics;

    public GameBoard(Position position) throws Exception {
        immovablePositionList = new ArrayList<Position>();
        candyList = new ArrayList<Candy>();
        Position startingPos = new Position(5, 5);
        player1 = new Player('X', startingPos);

        try {
            dtf = new DefaultTerminalFactory();
            terminal = dtf.createTerminal();
            //drawBoard(terminal, immovablePositionList);
            textGraphics = terminal.newTextGraphics();
            /*terminal.setCursorPosition(player1.getCurrentPos().getX(), player1.getCurrentPos().getY());
            terminal.setCursorVisible(false);
            terminal.putCharacter(player1.getName());*/
            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void drawBoard(Terminal terminal, ArrayList<Position> immovablePositionList) {
        try {
            terminal.setCursorPosition(player1.getCurrentPos().getX(), player1.getCurrentPos().getY());
            terminal.setCursorVisible(false);
            terminal.putCharacter(player1.getName());

            for (int i = 4; i < 77; i++) {
                terminal.setCursorPosition(i, 4);
                terminal.putCharacter(block);
                position = new Position(i, 4);
                position.setMovable(false);
                immovablePositionList.add(new Position(i, 4));
            }

            for (int i = 4; i < 78; i++) {
                terminal.setCursorPosition(i, 20);
                terminal.putCharacter(block);
                position = new Position(i, 20);
                position.setMovable(false);
                immovablePositionList.add(new Position(i, 20));
            }

            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(3, i);
                terminal.putCharacter(block);
                position = new Position(3, i);
                position.setMovable(false);
                immovablePositionList.add(new Position(3, i));
            }
            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(77, i);
                terminal.putCharacter(block);
                position = new Position(77, i);
                position.setMovable(false);
                immovablePositionList.add(new Position(77, i));
            }
            System.out.println(immovablePositionList.get(1).getX() + " hea" + immovablePositionList.get(10).getX());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameLoop(KeyListener keyListener, KeyListener currentKeyListener, boolean isDead) {


        try {
            while (!isDead) {

                int index = 0;
                int movementTaken = 0;
                //keyListener.setKeyStroke() = null;
                do {
                    index++;
                    movementTaken++;
                    additionalMenues();
                    if (movementTaken == 1000) {
                        spawnCandy(immovablePositionList, candyList);
                        movementTaken = 0;
                    }
                    if (index % 100 == 0) {
                        if (currentKeyListener.getKeyStroke() != null) {
                            setPlayerDirection(currentKeyListener.getKeyStroke(), player1);
                        }
                    }
                    Thread.sleep(2);
                    keyListener.setKeyStroke(terminal.pollInput());
                    //System.out.println(keyListener.getKeyStroke());
                } while (keyListener.getKeyStroke() == null);
                currentKeyListener.setKeyStroke(keyListener.getKeyStroke());

            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setPlayerDirection(KeyStroke keyStroke, Player player) {
        switch (keyStroke.getKeyType()) {
            case ArrowDown:
                moveSouth(player);
                break;
            case ArrowUp:
                moveNorth(player);
                break;
            case ArrowLeft:
                moveWest(player);
                break;
            case ArrowRight:
                moveEast(player);
                break;
        }
    }

    public void moveSouth(Player player) {
        try {
            for (Position p : immovablePositionList) {
                if (p.getPosition().getX() == player.getCurrentPos().getX() && p.getY() == player.getCurrentPos().getY() + 1) {
                    System.out.println("immovable " + p.toString());
                    player.decrementLife();
                    System.out.println(player.getLife());
                    if (player.getLife() == 0) {
                        gameOver();
                    }
                } else {
                    nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() + 1));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }

            }
            for (Candy candy : candyList) {
                if (candy.getPosition().getX() == player.getCurrentPos().getX() && candy.getPosition().getY() == player.getCurrentPos().getY() + 1) {
                    System.out.println("candy " + candy.getPosition().getX() + candy.getPosition().getY());
                    player.incrementLife();
                    nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() + 1));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                } else {
                    nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() + 1));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }
            }
            immovablePositionList.add(nextPos);
            player.setCurrentPos(nextPos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveNorth(Player player) {
        try {
            for (Position p : immovablePositionList) {

                if (p.getPosition().getX() == player.getCurrentPos().getX() && p.getY() == player.getCurrentPos().getY() - 1) {
                    System.out.println("immovable " + p.toString());
                    player.decrementLife();
                    System.out.println(player.getLife());
                    if (player.getLife() == 0) {
                        System.out.println("Game over");
                        gameOver();
                    }
                } else {
                    nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() - 1));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }
            }
            for (Candy candy : candyList) {
                if (candy.getPosition().getX() == player.getCurrentPos().getX() && candy.getPosition().getY() == player.getCurrentPos().getY() - 1) {
                    System.out.println("candy " + candy.getPosition().getX() + candy.getPosition().getY());
                    player.incrementLife();
                    nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() - 1));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                } else {
                    nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() - 1));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }
            }

            immovablePositionList.add(nextPos);
            player.setCurrentPos(nextPos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveEast(Player player) {
        try {
            for (Position p : immovablePositionList) {

                if (p.getPosition().getX() == player.getCurrentPos().getX() + 1 && p.getY() == player.getCurrentPos().getY()) {
                    System.out.println("immovable " + p.toString());
                    player.decrementLife();
                    System.out.println(player.getLife());
                    if (player.getLife() == 0) {
                        System.out.println("Game over");
                        gameOver();
                    }
                } else {
                    nextPos = new Position(player.getCurrentPos().getX() + 1, (player.getCurrentPos().getY()));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }
            }
            for (Candy candy : candyList) {
                if (candy.getPosition().getX() == player.getCurrentPos().getX()+1 && candy.getPosition().getY() == player.getCurrentPos().getY()) {
                    System.out.println("candy " + candy.getPosition().getX() + candy.getPosition().getY());
                    player.incrementLife();
                    nextPos = new Position(player.getCurrentPos().getX()+1, (player.getCurrentPos().getY()));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                } else {
                    nextPos = new Position(player.getCurrentPos().getX()+1, (player.getCurrentPos().getY()));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }
            }

            immovablePositionList.add(nextPos);
            player.setCurrentPos(nextPos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveWest(Player player) {
        try {
            for (Position p : immovablePositionList) {

                if (p.getPosition().getX() == player.getCurrentPos().getX() - 1 && p.getY() == player.getCurrentPos().getY()) {
                    System.out.println("immovable " + p.toString());
                    player.decrementLife();
                    System.out.println(player.getLife());
                    if (player.getLife() == 0) {
                        gameOver();
                        System.out.println("Game over");
                    }
                } else {
                    nextPos = new Position(player.getCurrentPos().getX() - 1, (player.getCurrentPos().getY()));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }

            }
            for (Candy candy : candyList) {
                if (candy.getPosition().getX() == player.getCurrentPos().getX() -1 && candy.getPosition().getY() == player.getCurrentPos().getY()) {
                    System.out.println("candy " + candy.getPosition().getX() + candy.getPosition().getY());
                    player.incrementLife();
                    nextPos = new Position(player.getCurrentPos().getX() -1, (player.getCurrentPos().getY()));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                } else {
                    nextPos = new Position(player.getCurrentPos().getX() -1, (player.getCurrentPos().getY()));
                    terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                    terminal.putCharacter(player.getName());
                    terminal.flush();
                }
            }

            immovablePositionList.add(nextPos);
            player.setCurrentPos(nextPos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer() {
        return this.player1;
    }

    public Terminal getTerminal() {
        return this.terminal;
    }

    public void spawnCandy(ArrayList<Position> immovablePositionList, ArrayList<Candy> candyList) {
        Random randomGenerator = new Random();
        int randomPosX = randomGenerator.nextInt(73) + 4;
        int randomPosY = randomGenerator.nextInt(16) + 4;
        boolean isCandyPlaced = false;
        Position candyPos = new Position(randomPosX, randomPosY);

        try {
            while (!isCandyPlaced) {
                for (Position pos : immovablePositionList) {
                    if (candyPos.getX() != pos.getX() && candyPos.getY() != pos.getY()) {
                        candyPos.setMovable(true);
                        Candy candy = new Candy(candyPos);
                        candyList.add(candy);
                        System.out.println(candy.getPosition().getX() + " " + candy.getPosition().getY());
                        terminal.setCursorPosition(candy.getPosition().getX(), candy.getPosition().getY());
                        terminal.putCharacter('O');
                        isCandyPlaced = true;
                        terminal.flush();
                    } else {
                        isCandyPlaced = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameOver() {
        try {
            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void gameMenu() {
        String menu;
        KeyListener keyListener = new KeyListener();
        KeyListener currentKeyListener = new KeyListener();
        keyListener.setKeyStroke(null);
        currentKeyListener.setKeyStroke(null);
        boolean gameloop = true;

        try {
            gameRules();
            Thread.sleep(10);
            terminal.clearScreen();
            drawBoard(terminal, immovablePositionList);

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        try {
            do {
                System.out.println("Start new Game y/n");
                input = new Scanner(System.in);
                menu = input.next();
                if (menu.equals("y")) {
                    gameLoop(keyListener, currentKeyListener, player1.isDead());
                } else {
                    terminal.close();
                    gameloop = false;
                }
            } while (gameloop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameRules() {
        try {
            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
            textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
            terminal.setForegroundColor(TextColor.ANSI.BLUE);

            textGraphics.putString(3, 8, "*You get one life for each candy you eat. ", SGR.BOLD);
            textGraphics.putString(3, 10, "*You loose one life when you crash into another player or into yourself. ", SGR.BOLD);
            textGraphics.putString(3, 12, "*When you go into the upper wall you will come out from ", SGR.BOLD);
            textGraphics.putString(3, 14, "* the lower wall and vice versa. ", SGR.BOLD);
            textGraphics.putString(3, 16, "*You loose all your lives when you crash into either the left or right wall,", SGR.BOLD);
            textGraphics.putString(3, 18, " the other player(s) continue(s) to play. ", SGR.BOLD);

            textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
            terminal.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.putString(35, 21, " GOOD LUCK ", SGR.BOLD);

            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void additionalMenues() {
        textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
        textGraphics.setBackgroundColor(TextColor.ANSI.RED);
        textGraphics.putString(25, 2, "player one: " + player1.getName() + " Lives: " + player1.getLife(), SGR.BOLD);
    }
}
