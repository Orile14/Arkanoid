// Ori Levy 318501897

/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * Hit event.
     * This method is called whenever the beingHit object is hit.
     * it does the listener job when there was hit(delete the block
     * for example).
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    void hitEvent(Block beingHit, Ball hitter);

}
