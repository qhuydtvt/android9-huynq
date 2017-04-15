import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 4/12/17.
 */
public class Player {
    private int x;
    private int y;
    private Image image;

    private int dx;
    private int dy;

    private boolean shootDisabled;

    private ArrayList<Bullet> playerBullets;
    int cooldownTime;


    public Player(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.dx = 0;
        this.dy = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setPlayerBullets(ArrayList<Bullet> playerBullets) {
        this.playerBullets = playerBullets;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void processInput(boolean isUpPressed,
                             boolean isDownPressed,
                             boolean isLeftPressed,
                             boolean isRightPressed,
                             boolean isSpacePressed) {
        dx = 0;
        dy = 0;

        if (isUpPressed) {
            dy -= 10;
        }

        if (isDownPressed) {
            dy += 10;
        }

        if (isLeftPressed) {
            dx -= 10;
        }

        if (isRightPressed) {
            dx += 10;
        }

        if(isSpacePressed && !shootDisabled) {
            shootDisabled = true;
            Bullet bullet = new Bullet(x + 35, y, Utils.loadImage("res/bullet.png"));
            playerBullets.add(bullet);
        }
    }



    public void update() {
        this.x += dx;
        this.y += dy;

        if(shootDisabled) {
            // cooling down
            cooldownTime++;
            if (cooldownTime > 20) {
                shootDisabled = false;
                cooldownTime = 0;
            }
        }
    }
}
