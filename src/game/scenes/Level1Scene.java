package game.scenes;

import game.controllers.ControllerManager;
import game.controllers.PlayerController;
import game.enemies.EnemyController;
import game.enemies.HorzMoveBehavior;
import game.enemies.MoveBehavior;
import game.utils.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 5/3/17.
 */
public class Level1Scene implements GameScene {

    Image backgroundImage;

    boolean isUpPressed;
    boolean isDownPressed;
    boolean isLeftPressed;
    boolean isRightPressed;
    boolean isSpacePressed;

    PlayerController playerController;

    public Level1Scene() {
        playerController = new PlayerController(200 - 17, 500 - 25, Utils.loadImage("res/plane3.png"));



        for (int x = 0; x < 600; x += 100) {
            EnemyController enemyController = new EnemyController(x, 0, Utils.loadImage("res/enemy-green-3.png"));
            if(x < 300)
                enemyController.setMoveBehavior(new HorzMoveBehavior());
            else
                enemyController.setMoveBehavior(new MoveBehavior());
            ControllerManager.instance.add(enemyController);
        }

        try {
            backgroundImage = ImageIO.read(new File("res/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        playerController.processInput(isUpPressed, isDownPressed, isLeftPressed, isRightPressed, isSpacePressed);
        playerController.update();
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(backgroundImage, 0, 0, null);
        playerController.draw(graphics);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                isRightPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = true;
                break;
            case KeyEvent.VK_UP:
                isUpPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                isSpacePressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                isRightPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = false;
                break;
            case KeyEvent.VK_UP:
                isUpPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                isSpacePressed = false;
                break;
        }
    }
}
