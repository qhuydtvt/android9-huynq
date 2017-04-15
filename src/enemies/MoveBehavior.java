package enemies;

import models.GameRect;

/**
 * Created by huynq on 4/15/17.
 */
public class MoveBehavior {
    public void doMove(GameRect gameRect) {
        gameRect.move(0, 5);
    }
}
