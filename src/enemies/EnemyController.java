package enemies;

import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by huynq on 4/15/17.
 */
public class EnemyController {
     private GameRect gameRect;
     private ImageRenderer imageRenderer;
     private MoveBehavior moveBehavior;

     public EnemyController(int x, int y, Image image) {
         gameRect = new GameRect(x, y,
                 image.getWidth(null),
                 image.getHeight(null));
         imageRenderer = new ImageRenderer(image);
     }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void update() {
         if(moveBehavior != null) {
             moveBehavior.doMove(this.gameRect);
         }
     }

     public void draw(Graphics graphics) {
         imageRenderer.render(graphics, gameRect);
     }
}
