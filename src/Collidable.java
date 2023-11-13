// Ori Levy 318501897


/**
 * The interface Collidable.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit velocity.
     * Notify the object that we collided with it at collisionPoint
     * with a given velocity. The return is the new velocity expected
     * after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter the ball that hit the block
     * @return the new velocity after the hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

