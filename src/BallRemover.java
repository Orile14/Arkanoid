// Ori Levy 318501897

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private static final int ONE = 1;
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel         the game to remove from
     * @param removedBalls the removed balls counter
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(ONE);
    }
}
