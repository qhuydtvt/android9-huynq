package game.controllers;

import game.enemies.EnemyController;
import game.models.GameRect;
import game.views.ImageRenderer;

import java.awt.*;

/**
 * Created by huynq on 4/12/17.
 */
public class BulletController extends Controller implements Collider {

    private int damage = 1;

    public BulletController(int x, int y, Image image) {
        int rectX = x - image.getWidth(null) / 2;
        int rectY = y - image.getHeight(null);

        int rectWidth = image.getWidth(null);
        int rectHeight = image.getHeight(null);

        this.gameRect = new GameRect(rectX, rectY, rectWidth, rectHeight);
        this.imageRenderer = new ImageRenderer(image);

        CollisionManager.instance.add(this);
    }

    public void update() {
        gameRect.move(0, -15);
    }

    @Override
    public void onCollide(Collider other) {
        if(other instanceof EnemyController) {
            ((EnemyController)other).getHit(damage);
        }
    }
}
