import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GameOver {

    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);


        //BÖRJAN AV G

        for (int i = 4; i < 10; i++) {         //Översta raden av G

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 4; i < 10; i++) {      //Nedre raden av G
            terminal.setCursorPosition(i, 15);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 15; i++) { //Den vänstra lodrätta linjen av G
            terminal.setCursorPosition(4, i);
            terminal.putCharacter('X');
        }
        for (int i = 12; i < 15; i++) { // Den högra lodrätta linjen av G
            terminal.setCursorPosition(9, i);
            terminal.putCharacter('X');
        }
        for (int i = 7; i < 9; i++) {         //kortaste vågrätta linjen av G

            terminal.setCursorPosition(i, 12);
            terminal.putCharacter('X');
        }


        //SLUTET AV BOKSTAV G

        for (int i = 12; i < 17; i++) {         //Översta vågrätta raden av A

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 12; i < 17; i++) {         //Nedre vågrätta raden av A

            terminal.setCursorPosition(i, 13);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //Vänstra lodrätta på A
            terminal.setCursorPosition(12, i);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //Högra lodrätt på A
            terminal.setCursorPosition(16, i);
            terminal.putCharacter('X');
        }
        //SLUTET AV BOKSTAV A

        for (int i = 19; i < 26; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 12; i < 17; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 13);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(19, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(22, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(25, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        //SLUTET PÅ M

        for (int i = 28; i < 33; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 12);
            terminal.putCharacter('X');
        }
        for (int i = 28; i < 33; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 28; i < 33; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 15);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 15; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(28, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        //SLUTET AV E

        for (int i = 46; i < 51; i++) {         // Övre linjen av O vågrätt

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 46; i < 51; i++) {         //nedre linjen av O vågrätt

            terminal.setCursorPosition(i, 15);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 15; i++) { //lodrätt åt vänster på först "o"
            terminal.setCursorPosition(46, i); //
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 15; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(50, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        //SLUTET AV O

        for (int i = 56; i < 57; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 15);
            terminal.putCharacter('X');
        }
        for (int i = 10; i < 15; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(54, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        for (int i = 10; i < 15; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(58, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }

        //Slutet på V

        for (int i = 61; i < 66; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 12);
            terminal.putCharacter('X');
        }
        for (int i = 61; i < 66; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 61; i < 66; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 15);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 15; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(61, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }

        //Slutet på E av "Over"

        for (int i = 69; i < 72; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 10);
            terminal.putCharacter('X');
        }
        for (int i = 68; i < 72; i++) {         //Vänster till höger

            terminal.setCursorPosition(i, 13);
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(68, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        for (int i = 11; i < 16; i++) { //längden på det som går lodrätt neråt
            if (i == 13 || i == 14) {
                continue;
            }
            terminal.setCursorPosition(72, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
        for (int i = 13; i <= 14; i++) { //längden på det som går lodrätt neråt
            terminal.setCursorPosition(71, i); //Vart det förflyttas åt höger
            terminal.putCharacter('X');
        }
//Slutet av R


    }
}
