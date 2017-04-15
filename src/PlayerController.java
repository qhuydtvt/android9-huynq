import models.GameRect;
import utils.Utils;
import views.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 4/12/17.
 */
public class PlayerController {
    private GameRect gameRect;

    private ImageRenderer imageRenderer;

    private boolean shootDisabled;
    private int dx;
    private int dy;

    private ArrayList<Bullet> playerBullets;
    private int cooldownTime;

    public PlayerController(int x, int y, Image image) {
        imageRenderer = new ImageRenderer(image);
        gameRect = new GameRect(x, y, 70, 50);
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public void setPlayerBullets(ArrayList<Bullet> playerBullets) {
        this.playerBullets = playerBullets;
    }

    public void draw(Graphics graphics) {
        imageRenderer.render(graphics, gameRect);
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
            Bullet bullet = new Bullet(gameRect.getX() + 35, gameRect.getY(), Utils.loadImage("res/bullet.png"));
            playerBullets.add(bullet);
        }
    }


    public void update() {

        gameRect.move(dx, dy);

        if(shootDisabled) {
            // cooling down
            cooldownTime++;
            if (cooldownTime > 10) {
                shootDisabled = false;
                cooldownTime = 0;
            }
        }
    }
}
