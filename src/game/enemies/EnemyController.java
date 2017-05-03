package game.enemies;

import game.Collider;
import game.controllers.CollisionManager;
import game.controllers.Controller;
import game.models.GameRect;
import game.views.ImageRenderer;

import java.awt.*;

/**
 * Created by huynq on 4/15/17.
 */
public class EnemyController extends Controller implements Collider {
    private MoveBehavior moveBehavior;

    public EnemyController(int x, int y, Image image) {
        super(new GameRect(x, y, image.getWidth(null), image.getHeight(null)),
                new ImageRenderer(image));

        CollisionManager.instance.add(this);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void update() {
        if (moveBehavior != null) {
            moveBehavior.move(gameRect);
        }
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
    }

    @Override
    public void onCollide(Collider other) {

    }
}
