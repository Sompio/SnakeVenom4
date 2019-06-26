package GUI;

public class Position {
    private int x;
    private int y;
    private Boolean isMovable;

    public Position() {
        isMovable = false;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        isMovable = false;
    }

    public Boolean getMovable() {
        return isMovable;
    }

    public void setMovable(Boolean movable) {
        isMovable = movable;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position getPosition() {
        return this;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
