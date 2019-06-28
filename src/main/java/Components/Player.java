package Components;

import GUI.Position;

public class Player {
    private char name;
    Position currentPos;
    boolean isDead = false;
    int life = 2;

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

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void decrementLife() {
        this.life--;
    }
    public void incrementLife() {
        this.life++;
    }
}
