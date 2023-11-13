// Ori Levy 318501897

/**
 * The interface Hit notifier.
 */
public interface HitNotifier {
    /**
     * Add hit listener.
     * Add hl as a listener to hit events.
     * @param hl the hl to add
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener.
     * Remove hl from the list of listeners to hit events.
     * @param hl the hl
     */
    void removeHitListener(HitListener hl);

}
