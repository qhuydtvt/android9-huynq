package game;

import game.models.GameRect;

/**
 * Created by huynq on 4/26/17.
 */
public interface Collider {
    GameRect getGameRect();
    void onCollide(Collider other);
}