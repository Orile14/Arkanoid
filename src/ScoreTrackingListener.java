// Ori Levy 318501897

/**
 * The type Score tracking listener.
 * the class that keeps up the score
 */
public class ScoreTrackingListener implements HitListener {
    private static final int INCREASE = 5;
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(INCREASE);
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return currentScore.getValue();
    }

    /**
     * Increase.
     *
     * @param number the number to increase in
     */
    void increase(int number) {
        currentScore.increase(number);
    }

    /**
     * Decrease.
     * subtract number from current count.
     * @param number the number to subtract
     */
    void decrease(int number) {
        currentScore.decrease(number);
    }
}