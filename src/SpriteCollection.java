// Ori Levy 318501897
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<>();

    /**
     * Add sprite.
     *
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprtie to remove
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * Notify all time passed.
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).timePassed();
        }
    }

    /**
     * Draw all on.
     * call drawOn(d) on all sprites.
     *
     * @param d the surface to draw on it
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}