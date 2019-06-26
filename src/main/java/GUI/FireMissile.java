package GUI;

public class FireMissile {


    private final int MISSILE_SPEED = 2;
    Boolean visible=true;
    int x=0;

    public void move() {

        x += MISSILE_SPEED;

        if (x > 78)
            visible = false;
    }






}
