package game.models;

import java.awt.*;

/**
 * Created by huynq on 4/15/17.
 */
public class GameRect {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean invisible;
    private boolean isDead;

    public GameRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean intersects(GameRect other) {
        Rectangle rect1 = new Rectangle(x, y, width, height);
        Rectangle rect2 = new Rectangle(other.x, other.y, other.width, other.height);
        return rect1.intersects(rect2);
    }
}
