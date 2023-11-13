// Ori Levy 318501897
import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * Do one frame.
     * draw what needed and checks for user input
     * if there is such
     *
     * @param d the surface to draw on
     */
    void doOneFrame(DrawSurface d);

    /**
     * Should stop boolean.
     * checks if the animation need to be stopped
     *
     * @return the boolean value if should be stop or not
     */
    boolean shouldStop();
}