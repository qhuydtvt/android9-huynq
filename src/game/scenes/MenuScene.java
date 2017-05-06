package game.scenes;

import game.GameWindow;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 5/3/17.
 */
public class MenuScene implements GameScene {

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            GameWindow.instance.setCurrentScene(new Level1Scene());
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update() {

    }
}
