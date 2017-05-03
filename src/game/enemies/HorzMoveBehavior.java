package game.enemies;

import game.models.GameRect;

/**
 * Created by huynq on 4/16/17.
 */
public class HorzMoveBehavior extends MoveBehavior {

    @Override
    public void move(GameRect gameRect) {
        gameRect.move(1, 1);
    }
}
