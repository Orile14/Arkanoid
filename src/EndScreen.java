// Ori Levy 318501897
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private int score;
    private KeyboardSensor keyboard;
    private static final int LOCATION = 180;
    private static final int WIN = 630;
    private static final int SIZE = 32;
    private static final int TWO = 2;


    /**
     * Instantiates a new End screen.
     *
     * @param score    the score
     * @param keyboard the keyboard
     */
    public EndScreen(int score, KeyboardSensor keyboard) {
        this.score = score;
        this.keyboard = keyboard;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        //player won
        if (score == WIN) {
            d.drawText(LOCATION, d.getHeight() / TWO, "You win! Your Score is 630!", SIZE);
            //player lost
        } else {
            d.drawText(LOCATION, d.getHeight() / TWO, "Game Over. Your Score is " + score, SIZE);
        }
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
