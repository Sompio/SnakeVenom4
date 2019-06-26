import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
        System.out.println("matte test");
        try {
            DefaultTerminalFactory dtf = new DefaultTerminalFactory();
            Terminal terminal = dtf.createTerminal();

        }catch (IOException e ) {
            e.printStackTrace();
        }

    }
}
