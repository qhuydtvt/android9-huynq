package models;

/**
 * Created by huynq on 4/15/17.
 */
public class GameRect {
    private int x;
    private int y;
    private int width;
    private int height;

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

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
