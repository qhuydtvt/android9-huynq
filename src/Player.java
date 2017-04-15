import models.GameRect;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 4/12/17.
 */
public class Player {

    private GameRect gameRect;

    private Image image;

    private boolean shootDisabled;

    private ArrayList<Bullet> playerBullets;
    int cooldownTime;

    public Player(int x, int y, Image image) {
        this.image = image;

        gameRect = new GameRect(x, y, 70, 50);
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public Image getImage() {
        return image;
    }

    public void setPlayerBullets(ArrayList<Bullet> playerBullets) {
        this.playerBullets = playerBullets;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, gameRect.getX(), gameRect.getY(), null);
    }

    int dx;
    int dy;

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
            Bullet bullet = new Bullet(gameRect.getX() + 35, gameRect.getY(), Utils.loadImage("res/bullet.png"));
            playerBullets.add(bullet);
        }
    }



    public void update() {

        gameRect.move(dx, dy);

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
