// Ori Levy 318501897


/**
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
    private static final int ONE = 1;
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * HitEvent.
     * the function remove the block that been hit and update
     * the counter accordingly
     *
     * @param beingHit         the block being hit
     * @param hitter the ball that hit him
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        gameLevel.removeCollidable(beingHit);
        gameLevel.removeSprite(beingHit);
        remainingBlocks.decrease(ONE);
    }
}
