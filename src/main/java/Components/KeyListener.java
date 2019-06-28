package Components;

import com.googlecode.lanterna.input.KeyStroke;

public class KeyListener {
    KeyStroke keyStroke;
    boolean isPressed;
    public KeyListener () {

    }

    public KeyStroke getKeyStroke() {
        return keyStroke;
    }

    public void setKeyStroke(KeyStroke keyStroke) {
        this.keyStroke = keyStroke;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}
