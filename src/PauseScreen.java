// Ori Levy 318501897

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 * the screen that shown when user press "p"
 */
public class PauseScreen implements Animation {
    private static final int LOCATION = 180;
    private static final int SIZE = 32;
    private static final int TWO = 2;


    private KeyboardSensor keyboard;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k the keyboard sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(LOCATION, d.getHeight() / TWO, "paused -- press space to continue", SIZE);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
