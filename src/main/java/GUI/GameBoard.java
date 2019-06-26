package GUI;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class GameBoard {
    DefaultTerminalFactory dtf;
    Terminal terminal;
    private char block = '\u2588';
    Position position;
    ArrayList<Position> immovablePositionList;


    public GameBoard(Position position){
        immovablePositionList = new ArrayList<Position>();
        try {
            dtf = new DefaultTerminalFactory();
            terminal = dtf.createTerminal();
        } catch (IOException e) {
            e.printStackTrace();
        }

        drawBoard(terminal, immovablePositionList);
    }


    public void drawBoard(Terminal terminal, ArrayList<Position> immovablePositionList) {
        try {
            for (int i = 3; i < 78; i++) {
                terminal.setCursorPosition(i, 3);
                terminal.putCharacter(block);
                position = new Position(i, 3);
                position.setMovable(false);
                immovablePositionList.add(new Position(i, 3));
            }

            for (int i = 3; i < 77; i++) {
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
}
