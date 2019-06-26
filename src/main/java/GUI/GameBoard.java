package GUI;

import Components.Player;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class GameBoard {
    private DefaultTerminalFactory dtf;
    private Terminal terminal;
    private char block = '\u2588';
    private Position position;
    private ArrayList<Position> immovablePositionList;
    private Position nextPos;
    private Player player1;

    private KeyStroke keyStroke;


    public GameBoard(Position position) throws Exception{
        immovablePositionList = new ArrayList<Position>();
        Position startingPos = new Position(5, 5);

        player1 = new Player('X', startingPos);

        try {
            dtf = new DefaultTerminalFactory();
            terminal = dtf.createTerminal();
            drawBoard(terminal, immovablePositionList);
            terminal.setCursorPosition(player1.getCurrentPos().getX(), player1.getCurrentPos().getY());
            terminal.setCursorVisible(false);
            terminal.putCharacter(player1.getName());
            terminal.flush();
            keyStroke = terminal.readInput();
            while(keyStroke.getKeyType() != KeyType.Escape) {
                keyStroke = terminal.readInput();
                Thread.sleep(5);
                movePlayer(keyStroke, player1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void drawBoard(Terminal terminal, ArrayList<Position> immovablePositionList) {
        try {
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
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    void movePlayer(KeyStroke keyStroke, Player player) {

        try {
        switch (keyStroke.getKeyType()) {
            case ArrowDown:
                for (Position p: immovablePositionList) {

                    if(p.getPosition().getX() == player.getCurrentPos().getX() && p.getY() == player.getCurrentPos().getY()+1) {
                        System.out.println("immovable " + p.toString());
                    } else {
                        nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY() + 1));
                        terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                        terminal.putCharacter(player.getName());
                        terminal.flush();
                    }
                }
                immovablePositionList.add(nextPos);
                player.setCurrentPos(nextPos);
                break;
            case ArrowUp:
                for (Position p: immovablePositionList) {

                    if(p.getPosition().getX() == player.getCurrentPos().getX() && p.getY() == player.getCurrentPos().getY()-1) {
                        System.out.println("immovable " + p.toString());
                    } else {
                        nextPos = new Position(player.getCurrentPos().getX(), (player.getCurrentPos().getY()-1));
                        terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                        terminal.putCharacter(player.getName());
                        terminal.flush();
                    }
                }
                immovablePositionList.add(nextPos);
                player.setCurrentPos(nextPos);
                break;
            case ArrowLeft:
                for (Position p: immovablePositionList) {

                    if(p.getPosition().getX() == player.getCurrentPos().getX()-1 && p.getY() == player.getCurrentPos().getY()) {
                        System.out.println("immovable " + p.toString());
                    } else {
                        nextPos = new Position(player.getCurrentPos().getX()-1, (player.getCurrentPos().getY()));
                        terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                        terminal.putCharacter(player.getName());
                        terminal.flush();
                    }
                }
                immovablePositionList.add(nextPos);
                player.setCurrentPos(nextPos);
                break;
            case ArrowRight:
                for (Position p: immovablePositionList) {

                    if(p.getPosition().getX() == player.getCurrentPos().getX()+1 && p.getY() == player.getCurrentPos().getY()) {
                        System.out.println("immovable " + p.toString());
                    } else {
                        nextPos = new Position(player.getCurrentPos().getX()+1, (player.getCurrentPos().getY()));
                        terminal.setCursorPosition(nextPos.getX(), nextPos.getY());
                        terminal.putCharacter(player.getName());
                        terminal.flush();
                    }
                }
                immovablePositionList.add(nextPos);
                player.setCurrentPos(nextPos);

        }
    }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
