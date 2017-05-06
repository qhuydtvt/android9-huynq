package game.scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 5/3/17.
 */
public interface GameScene {
    void keyPressed(KeyEvent e);

    void keyReleased(KeyEvent e);

    void draw(Graphics g);

    void update();
}
