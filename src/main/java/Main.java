import Components.KeyListener;
import GUI.GameBoard;
import GUI.Position;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Position position;
        position = new Position(1, 1);

        try {
            GameBoard gameBoard = new GameBoard(position);
            gameBoard.gameMenu();
        }catch (java.lang.Exception e){
            e.printStackTrace();
        }

    }
}
