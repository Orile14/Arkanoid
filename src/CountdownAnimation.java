// Ori Levy 318501897
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Countdown animation.
 * A countdown animation screen
 */
public class CountdownAnimation implements Animation {
    private static final int TEXT_SIZE = 60;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int currentCount;
    private long startTime;
    private GameLevel gameLevel;
    private static final int FACTOR = 1000;
    private static final int ONE = 1;
    private static final int TWO = 2;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     * @param g            the g
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
                              SpriteCollection gameScreen, GameLevel g) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.currentCount = countFrom + ONE;
        this.gameLevel = g;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // Draw the game screen
        this.gameScreen.drawAllOn(d);

        // Calculate the countdown time for each number
        double countdownTime = this.numOfSeconds / (this.countFrom + ONE);
        double elapsedTime = ((System.currentTimeMillis() - this.startTime) / countdownTime) / FACTOR;

        // Draw the current countdown number
        d.setColor(Color.white);
        String s = Integer.toString(this.currentCount);
        if (s.equals("0")) {
            s = "GO";
        }
        d.drawText(d.getWidth() / TWO, d.getHeight() / TWO, s, TEXT_SIZE);

        // Check if it's time to switch to the next countdown number
        if (elapsedTime >= ONE) {
            this.currentCount--;
            this.startTime = System.currentTimeMillis();
        }

        // Check if the countdown is finished
        if (this.currentCount < 0) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
