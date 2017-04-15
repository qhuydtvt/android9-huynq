import javax.imageio.ImageIO;
import java.awt.*;

/**
 * Created by huynq on 4/12/17.
 */
public class Bullet {
    private int x;
    private int y;
    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x - image.getWidth(null) / 2;
        this.y = y - image.getHeight(null);
        this.image = image;
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

    public void draw(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y,null);
    }

    public void update() {
        this.y -= 15;
    }
}
