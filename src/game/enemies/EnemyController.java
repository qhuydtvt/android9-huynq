package game.enemies;

import game.controllers.*;
import game.models.GameRect;
import game.utils.Utils;
import game.views.Animation;
import game.views.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 4/15/17.
 */
public class EnemyController extends Controller implements Collider {
    private MoveBehavior moveBehavior;

    private Animation animation;

    public EnemyController(int x, int y, Image image) {
        super(new GameRect(x, y, image.getWidth(null), image.getHeight(null)),
                new ImageRenderer(image));

        CollisionManager.instance.add(this);

        ArrayList<Image> images = new ArrayList<Image>();
        images.add(Utils.loadImage("res/enemy_plane_white_1.png"));
        images.add(Utils.loadImage("res/enemy_plane_white_2.png"));
        images.add(Utils.loadImage("res/enemy_plane_white_3.png"));

        animation = new Animation(images);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void update() {
        if (moveBehavior != null) {
            moveBehavior.move(gameRect);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        animation.draw(graphics, gameRect);
    }

    public void getHit(int damage) {
        gameRect.setDead(true);

        GameRect explosionGameRect = new GameRect(gameRect.getX(), gameRect.getY(), 0, 0);

        ExplosionController explosionController = new ExplosionController(explosionGameRect);
        ControllerManager.instance.add(explosionController);
    }

    @Override
    public void onCollide(Collider other) {

    }
}
