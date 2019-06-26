import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("test");
        System.out.println("matte test");

//        try {
//            DefaultTerminalFactory dtf = new DefaultTerminalFactory();
//            Terminal terminal = dtf.createTerminal();
//
//        }catch (IOException e ) {
//            e.printStackTrace();
//        }

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        TextGraphics textGraphics = terminal.newTextGraphics();

        char block = '\u2588';

        for (int i=3;i<78;i++)
        {
            terminal.setCursorPosition(i,3);
            terminal.putCharacter(block);
        }

        for (int i=3;i<77;i++)
        {
            terminal.setCursorPosition(i,20);
            terminal.putCharacter(block);
        }

        for (int i=4;i<21;i++)
        {
            terminal.setCursorPosition(3,i);
            terminal.putCharacter(block);
        }
        for (int i=4;i<21;i++)
        {
            terminal.setCursorPosition(77,i);
            terminal.putCharacter(block);
        }











    }
}
