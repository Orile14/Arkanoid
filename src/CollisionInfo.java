// Ori Levy 318501897

/**
 * The type Collision info.
 */
public class CollisionInfo {
    private Point cPoint;
    private Collidable cCollidable;

    /**
     * Instantiates a new Collision info.
     *
     * @param cPoint      the collision point
     * @param cCollidable the collision collidable
     */
    public CollisionInfo(Point cPoint, Collidable cCollidable) {
        this.cPoint = cPoint;
        this.cCollidable = cCollidable;
    }

    /**
     * Collision point.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return cPoint;
    }

    /**
     * Collision object collidable.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return cCollidable;
    }
}