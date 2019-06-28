import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.*;


public class Main {

    static ArrayList<String> tidigare = new ArrayList<String>();
    static ArrayList<String> tidigaretwo = new ArrayList<String>();
    static ArrayList<String> tidigareThree = new ArrayList<String>();
    static ArrayList<String> godis = new ArrayList<String>();  //Listor där samtliga spelares tidigare positioner sparas

    static Scanner scanner = new Scanner(System.in);

    static String a = "";
    static String b = "";
    static String d = "";
    static String e = "";
    static String nya = "";

    static String u = "";
    static String w = "";
    static String h = "";
    static String s = "";

    static String nyatwo = "";
    static String nyaThree = "";

    static int playerone = 0;
    static int playerstwo = 0;
    static int playersThree = 0;

    static int candyX;
    static int candyY;
    static int candyCounter;
    static int lifeone = 3;
    static int lifetwo = 3;
    static int lifeThree = 3;
    static String godisTester = "";
    static boolean playerOneIsAlive = true;
    static boolean playerTwoIsAlive = true;
    static boolean playerThreeIsAlive = true;


    //Spelregler och vilka tangenter spelarna ska använda
    public static void main(String[] args) throws Exception {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        TextGraphics textGraphics = terminal.newTextGraphics();

        textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
        terminal.setForegroundColor(TextColor.ANSI.BLUE);
        textGraphics.putString(3, 6, "GAME RULES: ", SGR.BOLD);

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


        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(3, 21, "Player 1 (green) move using ARROWS\t", SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
        textGraphics.putString(41, 21, " Player 2 (blue) moves using W A S D ", SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(24, 22, " Player 3 (white) moves using U H J K ", SGR.BOLD);
        terminal.flush();

        textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
        textGraphics.setBackgroundColor(TextColor.ANSI.RED);
        textGraphics.putString(17, 3, "How many players do you want to play? (1/2/3)", SGR.BOLD);
        terminal.flush();

        KeyStroke keyStroke = null;
        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);

        KeyType type = keyStroke.getKeyType();
        Character c = keyStroke.getCharacter();

        //Om man väljer 2 spelare
        if (c == Character.valueOf('2')) {
//            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
//            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
//            textGraphics.putString(17, 10, "                                                  ", SGR.BOLD);

            terminal.clearScreen();
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(3, 21, "Player 1 (green) move using ARROWS\t", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
            textGraphics.putString(41, 21, " Player 2 (blue) moves using W A S D ", SGR.BOLD);
//            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
//            textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
//            textGraphics.putString(24, 22, " Player 3 (white) moves using U H J K ", SGR.BOLD);
            terminal.flush();

            Random tand = new Random();
            int x = (tand.nextInt(73) + 4);
            int y = (tand.nextInt(16) + 4);
            final char player = '\u2b1b';

            int xTwo = (tand.nextInt(73) + 4);
            int yTwo = (tand.nextInt(16) + 4);
            final char playertwo = '\u2b1b';

            candyX = (tand.nextInt(73) + 4);
            candyY = (tand.nextInt(16) + 4);
            final char candyman = '\u2b1b';

            do {
                if ((x == xTwo) && (y == yTwo)) {
                    xTwo = (tand.nextInt(73) + 4);
                    yTwo = (tand.nextInt(16) + 4);
                } else if (((x == candyX) && (y == candyY)) || ((xTwo == candyX) && (yTwo == candyY))) {
                    candyX = (tand.nextInt(73) + 4);
                    candyY = (tand.nextInt(16) + 4);
                } else {
                    break;
                }
            } while (true);


            //utseende för godis och spelarna

            terminal.setForegroundColor(TextColor.ANSI.GREEN);
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);
            terminal.setForegroundColor(TextColor.ANSI.BLUE);
            terminal.setCursorPosition(xTwo, yTwo);
            terminal.putCharacter(playertwo);
            terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
            terminal.setCursorPosition(candyX, candyY);
            terminal.putCharacter(candyman);

            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(25, 2, "player one: " + playerone + " player two: " + playerstwo, SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(20, 1, "player one life: " + lifeone + " player two life: " + lifetwo, SGR.BOLD);

            terminal.setForegroundColor(TextColor.ANSI.RED);
            char block = '\u2588';

            for (int i = 3; i < 78; i++) {
                terminal.setCursorPosition(i, 3);
                terminal.putCharacter(block);
            }

            for (int i = 3; i < 77; i++) {
                terminal.setCursorPosition(i, 20);
                terminal.putCharacter(block);
            }

            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(3, i);
                terminal.putCharacter(block);
            }
            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(77, i);
                terminal.putCharacter(block);
            }
            terminal.flush();

            // Task 8, 9, 10
            boolean continueReadingInput = true;
            while (continueReadingInput) {

                keyStroke = null;
                do {
                    Thread.sleep(5); // might throw InterruptedException
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);


                type = keyStroke.getKeyType();
                c = keyStroke.getCharacter(); // used Character instead of char because it might be null

                // System.out.println("keyStroke.getKeyType(): " + type
                //       + " keyStroke.getCharacter(): " + c);

                if (c == Character.valueOf('q')) {
                    continueReadingInput = false;
                    terminal.close();
                    System.out.println("quit");
                }

                int oldX = x;
                int oldY = y;
                int oldcandyX = candyX;
                int oldcandyY = candyY;
                int oldK = xTwo;
                int oldM = yTwo;
                switch (keyStroke.getKeyType()) {
                    case ArrowDown:
                        if (playerOneIsAlive) {
                            y += 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                        } else {

                        }
                        break;
                    case Character:
                        switch (keyStroke.getCharacter()) {
                            case 's':
                                if (playerTwoIsAlive) {
                                    yTwo += 1;
                                    u = Integer.toString(oldK);
                                    w = Integer.toString(oldM);
                                    h = Integer.toString(xTwo);
                                    s = Integer.toString(yTwo);
                                    tidigaretwo.add(u + "  " + w);
                                    nyatwo = h + "  " + s;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'd':
                                if (playerTwoIsAlive) {
                                    xTwo += 1;
                                    u = Integer.toString(oldK);
                                    w = Integer.toString(oldM);
                                    h = Integer.toString(xTwo);
                                    s = Integer.toString(yTwo);
                                    tidigaretwo.add(u + "  " + w);
                                    nyatwo = h + "  " + s;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'w':
                                if (playerTwoIsAlive) {
                                    yTwo -= 1;
                                    u = Integer.toString(oldK);
                                    w = Integer.toString(oldM);
                                    h = Integer.toString(xTwo);
                                    s = Integer.toString(yTwo);
                                    tidigaretwo.add(u + "  " + w);
                                    nyatwo = h + "  " + s;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'a':
                                if (playerTwoIsAlive) {
                                    xTwo -= 1;
                                    u = Integer.toString(oldK);
                                    w = Integer.toString(oldM);
                                    h = Integer.toString(xTwo);
                                    s = Integer.toString(yTwo);
                                    tidigaretwo.add(u + "  " + w);
                                    nyatwo = h + "  " + s;
                                    playerstwo++;
                                } else {

                                }
                                break;
                        }
                        break;
                    case ArrowUp:

                        if (playerOneIsAlive) {
                            y -= 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                            break;
                        } else {

                        }
                    case ArrowRight:
                        if (playerOneIsAlive) {
                            x += 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                        } else {

                        }

                        break;
                    case ArrowLeft:
                        if (playerOneIsAlive) {
                            x -= 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                        } else {

                        }

                        break;
                }

                if (y == 3) {
                    y = 19;
                    nya = x + "  " + y;
                }
                if (y == 20) {
                    y = 4;
                    nya = x + "  " + y;
                }

                if (yTwo == 3) {
                    yTwo = 19;
                    nyatwo = xTwo + "  " + yTwo;
                }
                if (yTwo == 20) {
                    yTwo = 4;
                    nyatwo = xTwo + "  " + yTwo;
                }

                for (int i = 0; i < tidigare.size(); i++) {
                    if (tidigare.get(i).equals(nya)) {
                        System.out.println("test1");
                        tidigare.remove(i);
                        lifeone--;
                        if (lifeone == 0) {
                            playerOneIsAlive = false;
                        }
                        i = 1000000;
                        break;
                    } else if ((tidigare.size() < tidigaretwo.size())) {
                        for (int j = 0; j < tidigaretwo.size(); j++) {
                            if (tidigaretwo.get(j).equals(nya)) {
                                System.out.println("test2");
                                tidigaretwo.remove(j);
                                lifeone--;
                                if (lifeone == 0) {
                                    playerOneIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigare.size() > tidigaretwo.size())) {
                        for (int j = 0; j < tidigaretwo.size(); j++) {
                            if (tidigaretwo.get(j).equals(nya)) {
                                System.out.println("test3");
                                tidigaretwo.remove(j);

                                lifeone--;
                                if (lifeone == 0) {
                                    playerOneIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    }

                }

                for (int i = 0; i < tidigaretwo.size(); i++) {
                    if ((tidigaretwo.get(i).equals(nyatwo))) {
                        System.out.println("test4");
                        tidigaretwo.remove(i);
                        lifetwo--;
                        if (lifetwo == 0) {
                            playerTwoIsAlive = false;
                        }
                        i = 1000000;//hoppa ur båda looparna
                        break;
                    } else if ((tidigaretwo.size() < tidigare.size())) {
                        for (int j = 0; j < tidigare.size(); j++) {
                            if (tidigare.get(j).equals(nyatwo)) {
                                System.out.println("test5");
                                tidigare.remove(j);
                                lifetwo--;
                                if (lifetwo == 0) {
                                    playerTwoIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigaretwo.size() > tidigare.size())) {
                        for (int j = 0; j < tidigare.size(); j++) {
                            if (tidigare.get(j).equals(nyatwo)) {
                                System.out.println("test6");
                                tidigare.remove(j);
                                lifetwo--;
                                if (lifetwo == 0) {
                                    playerTwoIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    }
                }

                if (x == 3) {
                    lifeone = 0;
                    playerOneIsAlive = false;
                }
                if (x == 77) {
                    lifeone = 0;
                    playerOneIsAlive = false;
                }

                if (xTwo == 3) {
                    lifetwo = 0;
                    playerTwoIsAlive = false;
                }
                if (xTwo == 77) {
                    lifetwo = 0;
                    playerTwoIsAlive = false;
                }


                if (((playerone + playerstwo) + candyCounter) % 50 == 0) {
                    Random rand = new Random();
                    candyX = (rand.nextInt(73) + 4);
                    candyY = (rand.nextInt(16) + 4);
                    godisTester = candyX + "  " + candyY;
                    for (int i = 0; i < tidigare.size(); i++) {
                        if (godisTester.equals(tidigare.get(i))) {
                            System.out.println("Hoppsan, där fanns ormen");
                            godisTester = "" + 12300;
                            candyX = 1000;
                            candyY = 1000;
                            candyCounter--;
                        }
                    }
                    for (int i = 0; i < tidigaretwo.size(); i++) {
                        if (godisTester.equals(tidigaretwo.get(i))) {
                            System.out.println("Hoppsan, där fanns ormen");
                            candyX = 1000;
                            candyY = 1000;
                            godisTester = "" + 12300;
                            candyCounter--;
                        }
                    }
                    System.out.println("Nu byter vi plats");
                }

                if ((x == candyX) && (y == candyY)) {
                    System.out.println("mums");
                    candyX = 1000;
                    candyY = 1000;
                    godisTester = "" + 12300;
                    lifeone++;
                }

                if ((xTwo == candyX) && (yTwo == candyY)) {
                    System.out.println("mums2");
                    candyX = 1000;
                    candyY = 1000;
                    godisTester = "" + 12300;
                    lifetwo++;
                }

                terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
                terminal.setCursorPosition(oldcandyX, oldcandyY);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(candyX, candyY);
                terminal.putCharacter(candyman);

                terminal.setForegroundColor(TextColor.ANSI.GREEN);
                terminal.setCursorPosition(oldX, oldY);
                terminal.putCharacter('X');
                terminal.setCursorPosition(x, y);
                terminal.putCharacter(player);


                terminal.setForegroundColor(TextColor.ANSI.BLUE);
                terminal.setCursorPosition(oldK, oldM);
                terminal.putCharacter('O');
                terminal.setCursorPosition(xTwo, yTwo);
                terminal.putCharacter(playertwo);


                terminal.flush();

                textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                textGraphics.putString(25, 2, "player one: " + playerone + " player two: " + playerstwo, SGR.BOLD);

                textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                textGraphics.putString(20, 1, "player one life: " + lifeone + " player two life: " + lifetwo, SGR.BOLD);
                terminal.flush();


                if (!playerTwoIsAlive && !playerOneIsAlive) {
                    continueReadingInput = false;
                    textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                    textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                    textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                    terminal.flush();
                }
            }

        }

        //Om man väljer tre spelare
        if (c == Character.valueOf('3')) {
            terminal.clearScreen();
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(3, 21, "Player 1 (green) move using ARROWS\t", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
            textGraphics.putString(41, 21, " Player 2 (blue) moves using W A S D ", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            textGraphics.putString(24, 22, " Player 3 (white) moves using U H J K ", SGR.BOLD);
            terminal.flush();

            Random tand = new Random();
            int x = (tand.nextInt(73) + 4);
            int y = (tand.nextInt(16) + 4);
            final char player = '\u2b1b';

            int xTwo = (tand.nextInt(73) + 4);
            int yTwo = (tand.nextInt(16) + 4);
            final char playertwo = '\u2b1b';

            int xThree = (tand.nextInt(73) + 4);
            int yThree = (tand.nextInt(16) + 4);
            final char playerThree = '\u2b1b';

            candyX = (tand.nextInt(73) + 4);
            candyY = (tand.nextInt(16) + 4);
            final char candyman = '\u2b1b';

            do {
                if ((x == xTwo) && (y == yTwo)) {
                    xTwo = (tand.nextInt(73) + 4);
                    yTwo = (tand.nextInt(16) + 4);
                } else if (((x == candyX) && (y == candyY)) || ((xTwo == candyX) && (yTwo == candyY))) {
                    candyX = (tand.nextInt(73) + 4);
                    candyY = (tand.nextInt(16) + 4);
                } else {
                    break;
                }
            } while (true);

            terminal.setForegroundColor(TextColor.ANSI.GREEN);
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);
            terminal.setForegroundColor(TextColor.ANSI.BLUE);
            terminal.setCursorPosition(xTwo, yTwo);
            terminal.putCharacter(playertwo);
            terminal.setForegroundColor(TextColor.ANSI.WHITE);
            terminal.setCursorPosition(xThree, yThree);
            terminal.putCharacter(playerThree);
            terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
            terminal.setCursorPosition(candyX, candyY);
            terminal.putCharacter(candyman);

            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(25, 2, "player one: " + playerone + " player two: " + playerstwo + " player three: " + playerstwo, SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(20, 1, "player one life: " + lifeone + " player two life: " + lifetwo + " player three life: " + lifetwo, SGR.BOLD);


            terminal.setForegroundColor(TextColor.ANSI.RED);
            char block = '\u2588';

            for (int i = 3; i < 78; i++) {
                terminal.setCursorPosition(i, 3);
                terminal.putCharacter(block);
            }

            for (int i = 3; i < 77; i++) {
                terminal.setCursorPosition(i, 20);
                terminal.putCharacter(block);
            }

            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(3, i);
                terminal.putCharacter(block);
            }
            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(77, i);
                terminal.putCharacter(block);
            }
            terminal.flush();

            boolean continueReadingInput = true;
            while (continueReadingInput) {

                keyStroke = null;
                do {
                    Thread.sleep(5); // might throw InterruptedException
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);


                type = keyStroke.getKeyType();
                c = keyStroke.getCharacter(); // used Character instead of char because it might be null

                // System.out.println("keyStroke.getKeyType(): " + type
                //       + " keyStroke.getCharacter(): " + c);

                if (c == Character.valueOf('q')) {
                    continueReadingInput = false;
                    terminal.close();
                    System.out.println("quit");
                }

                int oldX = x;
                int oldY = y;
                int oldXThree = xThree;
                int oldYThree = yThree;
                int oldcandyX = candyX;
                int oldcandyY = candyY;
                int oldK = xTwo;
                int oldM = yTwo;
                switch (keyStroke.getKeyType()) {
                    case ArrowDown:
                        if (playerOneIsAlive) {
                            y += 1;
                            tidigare.add(oldX + "  " + oldY);
                            nya = x + "  " + y;
                            playerone++;
                        } else {

                        }
                        break;
                    case Character:
                        switch (keyStroke.getCharacter()) {
                            case 's':
                                if (playerTwoIsAlive) {
                                    yTwo += 1;
                                    tidigaretwo.add(oldK + "  " + oldM);
                                    nyatwo = xTwo + "  " + yTwo;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'd':
                                if (playerTwoIsAlive) {
                                    xTwo += 1;
                                    tidigaretwo.add(oldK + "  " + oldM);
                                    nyatwo = xTwo + "  " + yTwo;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'w':
                                if (playerTwoIsAlive) {
                                    yTwo -= 1;
                                    tidigaretwo.add(oldK + "  " + oldM);
                                    nyatwo = xTwo + "  " + yTwo;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'a':
                                if (playerTwoIsAlive) {
                                    xTwo -= 1;
                                    tidigaretwo.add(oldK + "  " + oldM);
                                    nyatwo = xTwo + "  " + yTwo;
                                    playerstwo++;
                                } else {

                                }
                                break;
                            case 'u':
                                if (playerThreeIsAlive) {
                                    yThree -= 1;
                                    tidigareThree.add(oldXThree + "  " + oldYThree);
                                    nyaThree = xThree + "  " + yThree;
                                    playersThree++;
                                } else {

                                }
                                break;
                            case 'h':
                                if (playerThreeIsAlive) {
                                    xThree -= 1;
                                    tidigareThree.add(oldXThree + "  " + oldYThree);
                                    nyaThree = xThree + "  " + yThree;
                                    playersThree++;
                                } else {

                                }
                                break;
                            case 'k':
                                if (playerThreeIsAlive) {
                                    xThree += 1;
                                    tidigareThree.add(oldXThree + "  " + oldYThree);
                                    nyaThree = xThree + "  " + yThree;
                                    playersThree++;
                                } else {

                                }
                                break;
                            case 'j':
                                if (playerThreeIsAlive) {
                                    yThree += 1;
                                    tidigareThree.add(oldXThree + "  " + oldYThree);
                                    nyaThree = xThree + "  " + yThree;
                                    playersThree++;
                                } else {
                                }
                                break;
                        }
                        break;
                    case ArrowUp:

                        if (playerOneIsAlive) {
                            y -= 1;
                            tidigare.add(oldX + "  " + oldY);
                            nya = x + "  " + y;
                            playerone++;
                            break;
                        } else {

                        }
                    case ArrowRight:
                        if (playerOneIsAlive) {
                            x += 1;
                            tidigare.add(oldX + "  " + oldY);
                            nya = x + "  " + y;
                            playerone++;
                        } else {

                        }

                        break;
                    case ArrowLeft:
                        if (playerOneIsAlive) {
                            x -= 1;
                            tidigare.add(oldX + "  " + oldY);
                            nya = x + "  " + y;
                            playerone++;
                        } else {

                        }

                        break;
                }

                if (y == 3) {
                    y = 19;
                    nya = x + "  " + y;
                }
                if (y == 20) {
                    y = 4;
                    nya = x + "  " + y;
                }

                if (yTwo == 3) {
                    yTwo = 19;
                    nyatwo = xTwo + "  " + yTwo;
                }
                if (yTwo == 20) {
                    yTwo = 4;
                    nyatwo = xTwo + "  " + yTwo;
                }
                if (yThree == 3) {
                    yThree = 19;
                    nyaThree = xThree + "  " + yThree;
                }
                if (yThree == 20) {
                    yThree = 4;
                    nyaThree = xThree + "  " + yThree;
                }

                for (int i = 0; i < tidigare.size(); i++) {
                    if (tidigare.get(i).equals(nya)) {
                        System.out.println("test1");
                        tidigare.remove(i);
                        lifeone--;
                        if (lifeone == 0) {
                            playerOneIsAlive = false;
                        }
                        i = 1000000;
                        break;
                    } else if ((tidigare.size() < tidigaretwo.size())) {
                        for (int j = 0; j < tidigaretwo.size(); j++) {
                            if (tidigaretwo.get(j).equals(nya)) {
                                System.out.println("test2");
                                tidigaretwo.remove(j);
                                lifeone--;
                                if (lifeone == 0) {
                                    playerOneIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigare.size() > tidigaretwo.size())) {
                        for (int j = 0; j < tidigaretwo.size(); j++) {
                            if (tidigaretwo.get(j).equals(nya)) {
                                System.out.println("test3");
                                tidigaretwo.remove(j);

                                lifeone--;
                                if (lifeone == 0) {
                                    playerOneIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigare.size() < tidigareThree.size())) {
                        for (int j = 0; j < tidigareThree.size(); j++) {
                            if (tidigareThree.get(j).equals(nya)) {
                                System.out.println("test2");
                                tidigareThree.remove(j);
                                lifeone--;
                                if (lifeone == 0) {
                                    playerOneIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigare.size() > tidigareThree.size())) {
                        for (int j = 0; j < tidigareThree.size(); j++) {
                            if (tidigareThree.get(j).equals(nya)) {
                                System.out.println("test3");
                                tidigareThree.remove(j);

                                lifeone--;
                                if (lifeone == 0) {
                                    playerOneIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    }

                }

                for (int i = 0; i < tidigaretwo.size(); i++) {
                    if ((tidigaretwo.get(i).equals(nyatwo))) {
                        System.out.println("test4");
                        tidigaretwo.remove(i);
                        lifetwo--;
                        if (lifetwo == 0) {
                            playerTwoIsAlive = false;
                        }
                        i = 1000000;//hoppa ur båda looparna
                        break;
                    } else if ((tidigaretwo.size() < tidigare.size())) {
                        for (int j = 0; j < tidigare.size(); j++) {
                            if (tidigare.get(j).equals(nyatwo)) {
                                System.out.println("test5");
                                tidigare.remove(j);
                                lifetwo--;
                                if (lifetwo == 0) {
                                    playerTwoIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigaretwo.size() > tidigare.size())) {
                        for (int j = 0; j < tidigare.size(); j++) {
                            if (tidigare.get(j).equals(nyatwo)) {
                                System.out.println("test6");
                                tidigare.remove(j);
                                lifetwo--;
                                if (lifetwo == 0) {
                                    playerTwoIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigaretwo.size() < tidigareThree.size())) {
                        for (int j = 0; j < tidigareThree.size(); j++) {
                            if (tidigareThree.get(j).equals(nyatwo)) {
                                System.out.println("test5");
                                tidigareThree.remove(j);
                                lifetwo--;
                                if (lifetwo == 0) {
                                    playerTwoIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigaretwo.size() > tidigareThree.size())) {
                        for (int j = 0; j < tidigareThree.size(); j++) {
                            if (tidigareThree.get(j).equals(nyatwo)) {
                                System.out.println("test6");
                                tidigareThree.remove(j);
                                lifetwo--;
                                if (lifetwo == 0) {
                                    playerTwoIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    }
                }


                for (int i = 0; i < tidigareThree.size(); i++) {
                    if (tidigareThree.get(i).equals(nyaThree)) {
                        System.out.println("test1");
                        tidigareThree.remove(i);
                        lifeThree--;
                        if (lifeThree == 0) {
                            playerThreeIsAlive = false;
                        }
                        i = 1000000;
                        break;
                    } else if ((tidigareThree.size() < tidigaretwo.size())) {
                        for (int j = 0; j < tidigaretwo.size(); j++) {
                            if (tidigaretwo.get(j).equals(nyaThree)) {
                                System.out.println("test2");
                                tidigaretwo.remove(j);
                                lifeThree--;
                                if (lifeThree == 0) {
                                    playerThreeIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigareThree.size() > tidigaretwo.size())) {
                        for (int j = 0; j < tidigaretwo.size(); j++) {
                            if (tidigaretwo.get(j).equals(nyaThree)) {
                                System.out.println("test3");
                                tidigaretwo.remove(j);

                                lifeThree--;
                                if (lifeThree == 0) {
                                    playerThreeIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigareThree.size() < tidigare.size())) {
                        for (int j = 0; j < tidigare.size(); j++) {
                            if (tidigare.get(j).equals(nyaThree)) {
                                System.out.println("test2");
                                tidigare.remove(j);
                                lifeThree--;
                                if (lifeThree == 0) {
                                    playerThreeIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    } else if ((tidigareThree.size() > tidigare.size())) {
                        for (int j = 0; j < tidigare.size(); j++) {
                            if (tidigareThree.get(j).equals(nyaThree)) {
                                System.out.println("test3");
                                tidigare.remove(j);

                                lifeThree--;
                                if (lifeThree == 0) {
                                    playerThreeIsAlive = false;
                                }
                                i = 1000000;//hoppa ur båda looparna
                                break;
                            }
                        }
                    }

                }


                if (x == 3 || xTwo == 3 || xThree == 3) {
                    System.out.println("test7");
                    System.out.println("Game over");
                    continueReadingInput = false;

                    textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                    textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                    textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                    terminal.flush();

                }
                if (x == 77 || xTwo == 77 || xThree == 77) {
                    System.out.println("test8");
                    System.out.println("Game over");
                    continueReadingInput = false;
                    textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                    textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                    textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                    terminal.flush();
                }


                if (((playerone + playerstwo + playerThree) + candyCounter) % 100 == 0) {
                    Random rand = new Random();
                    candyX = (rand.nextInt(73) + 4);
                    candyY = (rand.nextInt(16) + 4);
                    godisTester = candyX + "  " + candyY;
                    for (int i = 0; i < tidigare.size(); i++) {
                        if (godisTester.equals(tidigare.get(i))) {
                            System.out.println("Hoppsan, där fanns ormen");
                            godisTester = "" + 12300;
                            candyX = 1000;
                            candyY = 1000;
                            candyCounter--;
                        }
                    }
                    for (int i = 0; i < tidigareThree.size(); i++) {
                        if (godisTester.equals(tidigareThree.get(i))) {
                            System.out.println("Hoppsan, där fanns ormen");
                            godisTester = "" + 12300;
                            candyX = 1000;
                            candyY = 1000;
                            candyCounter--;
                        }
                    }
                    for (int i = 0; i < tidigaretwo.size(); i++) {
                        if (godisTester.equals(tidigaretwo.get(i))) {
                            System.out.println("Hoppsan, där fanns ormen");
                            candyX = 1000;
                            candyY = 1000;
                            godisTester = "" + 12300;
                            candyCounter--;
                        }
                    }
                    System.out.println("Nu byter vi plats");
                }

                // Ny slumpad plats om godiset eller någon av spelarna råkar få samma plats

                if ((x == candyX) && (y == candyY)) {
                    System.out.println("mums");
                    candyX = 1000;
                    candyY = 1000;
                    godisTester = "" + 12300;
                    lifeone++;
                }

                if ((xTwo == candyX) && (yTwo == candyY)) {
                    System.out.println("mums2");
                    candyX = 1000;
                    candyY = 1000;
                    godisTester = "" + 12300;
                    lifetwo++;
                }

                if ((xThree == candyX) && (yThree == candyY)) {
                    System.out.println("mums3");
                    candyX = 1000;
                    candyY = 1000;
                    godisTester = "" + 12300;
                    lifeThree++;
                }

                terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
                terminal.setCursorPosition(oldcandyX, oldcandyY);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(candyX, candyY);
                terminal.putCharacter(candyman);

                terminal.setForegroundColor(TextColor.ANSI.GREEN);
                terminal.setCursorPosition(oldX, oldY);
                terminal.putCharacter('X');
                terminal.setCursorPosition(x, y);
                terminal.putCharacter(player);

                terminal.setForegroundColor(TextColor.ANSI.WHITE);
                terminal.setCursorPosition(oldXThree, oldYThree);
                terminal.putCharacter('Z');
                terminal.setCursorPosition(xThree, yThree);
                terminal.putCharacter(playerThree);


                terminal.setForegroundColor(TextColor.ANSI.BLUE);
                terminal.setCursorPosition(oldK, oldM);
                terminal.putCharacter('O');
                terminal.setCursorPosition(xTwo, yTwo);
                terminal.putCharacter(playertwo);


                terminal.flush();

                textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                textGraphics.putString(25, 2, "player one: " + playerone + " player two: " + playerstwo + " player three: " + playersThree, SGR.BOLD);
                textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                textGraphics.putString(20, 1, "player one life: " + lifeone + " player two life: " + lifetwo + " player three life: " + lifeThree, SGR.BOLD);

                terminal.flush();


                if (!playerTwoIsAlive && !playerOneIsAlive && !playerThreeIsAlive) {
                    continueReadingInput = false;
                    textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                    textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                    textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                    terminal.flush();
                }

            }

            //När man väljer en spelare
        } else if (c == Character.valueOf('1')) {
            terminal.clearScreen();
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(3, 21, "Player 1 (green) move using ARROWS\t", SGR.BOLD);
            terminal.flush();


            Random tand = new Random();
            int x = (tand.nextInt(73) + 4);
            int y = (tand.nextInt(16) + 4);
            final char player = '\u2b1b';

            candyX = (tand.nextInt(73) + 4);
            candyY = (tand.nextInt(16) + 4);
            final char candyman = '\u2b1b';

            do {
                if (((x == candyX) && (y == candyY))) {
                    candyX = (tand.nextInt(73) + 4);
                    candyY = (tand.nextInt(16) + 4);
                } else {
                    break;
                }
            } while (true);


            //utseende för godis och spelaren

            terminal.setForegroundColor(TextColor.ANSI.GREEN);
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);
            terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
            terminal.setCursorPosition(candyX, candyY);
            terminal.putCharacter(candyman);

            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(25, 2, "player one: " + playerone, SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
            textGraphics.putString(20, 1, "player one life: " + lifeone, SGR.BOLD);


            terminal.setForegroundColor(TextColor.ANSI.RED);
            char block = '\u2588';

            for (int i = 3; i < 78; i++) {
                terminal.setCursorPosition(i, 3);
                terminal.putCharacter(block);
            }

            for (int i = 3; i < 77; i++) {
                terminal.setCursorPosition(i, 20);
                terminal.putCharacter(block);
            }

            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(3, i);
                terminal.putCharacter(block);
            }
            for (int i = 4; i < 21; i++) {
                terminal.setCursorPosition(77, i);
                terminal.putCharacter(block);
            }
            terminal.flush();

            // Task 8, 9, 10
            boolean continueReadingInput = true;
            while (continueReadingInput) {

                keyStroke = null;
                do {
                    Thread.sleep(5); // might throw InterruptedException
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);


                type = keyStroke.getKeyType();
                c = keyStroke.getCharacter(); // used Character instead of char because it might be null

                // System.out.println("keyStroke.getKeyType(): " + type
                //       + " keyStroke.getCharacter(): " + c);

                if (c == Character.valueOf('q')) {
                    continueReadingInput = false;
                    terminal.close();
                    System.out.println("quit");
                }

                int oldX = x;
                int oldY = y;
                int oldcandyX = candyX;
                int oldcandyY = candyY;
                switch (keyStroke.getKeyType()) {
                    case ArrowDown:
                        if (playerOneIsAlive) {
                            y += 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                        } else {

                        }
                        break;
                    case ArrowUp:

                        if (playerOneIsAlive) {
                            y -= 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                            break;
                        } else {

                        }
                    case ArrowRight:
                        if (playerOneIsAlive) {
                            x += 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                        } else {

                        }

                        break;
                    case ArrowLeft:
                        if (playerOneIsAlive) {
                            x -= 1;
                            a = Integer.toString(oldX);
                            b = Integer.toString(oldY);
                            d = Integer.toString(x);
                            e = Integer.toString(y);
                            tidigare.add(a + "  " + b);
                            nya = d + "  " + e;
                            playerone++;
                        } else {

                        }

                        break;
                }

                if (y == 3) {
                    y = 19;
                    nya = x + "  " + y;
                }
                if (y == 20) {
                    y = 4;
                    nya = x + "  " + y;
                }

                for (int i = 0; i < tidigare.size(); i++) {
                    if (tidigare.get(i).equals(nya)) {
                        System.out.println("test1");
                        tidigare.remove(i);
                        lifeone--;
                        if (lifeone == 0) {
                            playerOneIsAlive = false;


                            continueReadingInput = false;
                            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                            textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                            textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                            terminal.flush();
                        }
                        i = 1000000;
                        break;
                    }
                }

//Game over när man krockar mot vänstra väggen
                if (x == 3) {
                    System.out.println("test7");
                    System.out.println("Game over");
                    continueReadingInput = false;

                    textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                    textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                    textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                    terminal.flush();

                }

                //Game over när man krockar mot högra väggen
                if (x == 77) {
                    System.out.println("test8");
                    System.out.println("Game over");
                    continueReadingInput = false;
                    textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                    textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                    textGraphics.putString(17, 10, "-----------------GAME OVER-----------------", SGR.BOLD);
                    terminal.flush();
                }


                if ((playerone + candyCounter) % 50 == 0) {
                    Random rand = new Random();
                    candyX = (rand.nextInt(73) + 4);
                    candyY = (rand.nextInt(16) + 4);
                    godisTester = candyX + "  " + candyY;
                    for (int i = 0; i < tidigare.size(); i++) {
                        if (godisTester.equals(tidigare.get(i))) {
                            System.out.println("Hoppsan, där fanns ormen");
                            godisTester = "" + 12300;  // När en godis äts upp så placeras den i nedre högra hörnet
                            candyX = 1000;
                            candyY = 1000;
                            candyCounter--;
                        }
                    }
                    System.out.println("Nu byter vi plats");
                }

                if ((x == candyX) && (y == candyY)) {
                    System.out.println("mums");
                    candyX = 1000;
                    candyY = 1000;
                    godisTester = "" + 12300;
                    lifeone++;
                }

                //utseende för godis och spelaren
                terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
                terminal.setCursorPosition(oldcandyX, oldcandyY);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(candyX, candyY);
                terminal.putCharacter(candyman);

                terminal.setForegroundColor(TextColor.ANSI.GREEN);
                terminal.setCursorPosition(oldX, oldY);
                terminal.putCharacter('X');
                terminal.setCursorPosition(x, y);
                terminal.putCharacter(player);


                terminal.flush();

                // Scoreboard for one player
                textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                textGraphics.putString(25, 2, "player one: " + playerone, SGR.BOLD);
                textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
                textGraphics.setBackgroundColor(TextColor.ANSI.RED);
                textGraphics.putString(20, 1, "player one life: " + lifeone, SGR.BOLD);
                terminal.flush();

            }


        }


    }

}

