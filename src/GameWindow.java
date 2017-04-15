import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by huynq on 4/8/17.
 */
public class GameWindow extends Frame {

    Image backgroundImage;

    BufferedImage backBufferImage;
    Graphics backbufferGraphics;

    boolean isUpPressed;
    boolean isDownPressed;
    boolean isLeftPressed;
    boolean isRightPressed;
    boolean isSpacePressed;

    ArrayList<Bullet> playerBullets;
    Player player;

    //2 Draw
    public GameWindow() {
        setVisible(true);

        playerBullets = new ArrayList<>();

        player = new Player(200 - 17, 500 - 25, Utils.loadImage("res/plane3.png"));

        player.setPlayerBullets(playerBullets);

        setTitle("1945");

        setSize(400, 500);

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

            @Override
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
        });

        //1 Load image
        try {
            backgroundImage = ImageIO.read(new File("res/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    player.processInput(isUpPressed, isDownPressed, isLeftPressed, isRightPressed, isSpacePressed);

                    if(isSpacePressed) {

                    }

                    for (Bullet bullet : playerBullets) {
                        bullet.update();
                    }

                    player.update();

                    // Draw
                    repaint();
                }
            }
        });

        thread.start();
    }



    @Override
    public void update(Graphics g) {
        // Draw on backbuffer
        backbufferGraphics.drawImage(backgroundImage, 0, 0, 400, 500, null);

        player.draw(backbufferGraphics);

        for (Bullet bullet : playerBullets) {
            bullet.draw(backbufferGraphics);
        }

        // Draw backbuffer on game window
        g.drawImage(backBufferImage, 0, 0, null);
    }
}
