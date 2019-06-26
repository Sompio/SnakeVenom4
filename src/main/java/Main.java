import GUI.GameBoard;
import GUI.Position;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Position position;
        System.out.println("test");
        System.out.println("PerreTest");
        position = new Position(1, 1);
        try {
        GameBoard gameBoard = new GameBoard(position);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }


    }
}
