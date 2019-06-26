package Components;

import GUI.Position;

public class Player {
    private char name;
    Position currentPos;

    public Player(char name, Position pos) {
        this.name = name;
        this.currentPos = pos;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return this.name;
    }

    public Position getCurrentPos() {
        return this.currentPos;
    }

    public void setCurrentPos(Position currentPos) {
        this.currentPos = currentPos;
    }
}
