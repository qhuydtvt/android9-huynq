package game.scenes;

import game.GameWindow;
import game.utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 5/3/17.
 */
public class MenuScene implements GameScene {

    private Clip clip;
    public MenuScene() {
        clip = Utils.playSound("res/lactroi.wav", true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            clip.close();
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
