// Ori Levy 318501897
import biuoop.DrawSurface;

/**
 * The interface Sprite.
 */
public interface Sprite {
    /**
     * Draw on.
     * draw the sprite to the screen
     * @param d the surface to draw on the sprite
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed.
     * notify the sprite that time has passed and it should do
     * whatever it been told to when time pass
     */
    void timePassed();
}
