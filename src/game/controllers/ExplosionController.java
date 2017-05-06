package game.controllers;

import game.models.GameRect;
import game.utils.Utils;
import game.views.Animation;
import game.views.ImageRenderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 5/6/17.
 */
public class ExplosionController extends Controller {
    private Animation animation;

    public ExplosionController(GameRect gameRect) {
        super(gameRect, null);

        ArrayList<Image> images = new ArrayList<>();
        images.add(Utils.loadImage("res/enemy_explosion_1.png"));
        images.add(Utils.loadImage("res/enemy_explosion_2.png"));
        images.add(Utils.loadImage("res/enemy_explosion_3.png"));
        images.add(Utils.loadImage("res/enemy_explosion_4.png"));
        images.add(Utils.loadImage("res/enemy_explosion_5.png"));
        images.add(Utils.loadImage("res/enemy_explosion_6.png"));

        this.animation = new Animation(images, 1, true);
    }

    @Override
    public void draw(Graphics graphics) {
        animation.draw(graphics, gameRect);

        if (animation.isEnded()) {
            gameRect.setDead(true);
        }
    }
}
