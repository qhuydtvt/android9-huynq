package game.enemies;

import game.models.GameRect;

/**
 * Created by huynq on 4/16/17.
 */
public class MoveBehavior {
    public void move(GameRect gameRect) {
        gameRect.move(0, 1);
    }
}
