package enemies;

import models.GameRect;

/**
 * Created by huynq on 4/15/17.
 */
public class HorizontalMoveBehavior extends MoveBehavior {

    @Override
    public void doMove(GameRect gameRect) {
        gameRect.move(3, 4);
    }
}
