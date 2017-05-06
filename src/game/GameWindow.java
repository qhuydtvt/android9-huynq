package game;

import game.controllers.CollisionManager;
import game.controllers.ControllerManager;
import game.scenes.GameScene;
import game.scenes.MenuScene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 4/8/17.
 */
public class GameWindow extends Frame {

    BufferedImage backBufferImage;
    Graphics backbufferGraphics;

    private GameScene currentScene;

    public static GameWindow instance;

    public void setCurrentScene(GameScene currentScene) {
        this.currentScene = currentScene;
    }

    public GameWindow() {

        instance = this;

        setVisible(true);

        setTitle("1945");

        setSize(400, 500);

        currentScene = new MenuScene();

        backBufferImage = new BufferedImage(400, 500, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBufferImage.getGraphics();

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                currentScene.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currentScene.keyReleased(e);
            }
        });

        //1 Load image
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    currentScene.update();

                    ControllerManager.instance.update();

                    CollisionManager.instance.update();

                    repaint();
                }
            }
        });

        thread.start();
    }

    @Override
    public void update(Graphics g) {

        currentScene.draw(backbufferGraphics);

        ControllerManager.instance.draw(backbufferGraphics);

        // Draw backbuffer on game window
        g.drawImage(backBufferImage, 0, 0, null);
    }
}
