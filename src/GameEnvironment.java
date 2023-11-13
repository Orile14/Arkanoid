// Ori Levy 318501897

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 * in chrage for all the collidables
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<>();

    /**
     * Gets collidables.
     *
     * @return the collidables
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * Remove collidable.
     * remove the collidable from the game
     *
     * @param c the collidable to remove
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * Add collidable.
     *
     * @param c add the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Gets closest collision.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory of the ball
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //two list one to store the points and one to store who they hit
        List<Point> cPoints = new ArrayList<>();
        List<Collidable> cCollidable = new ArrayList<>();
        for (int i = 0; i < collidables.size(); i++) {
            Rectangle rec = collidables.get(i).getCollisionRectangle();
            //if thre is collision point
            if (rec.intersectionPoints(trajectory) != null) {
                if (trajectory.closestIntersectionToStartOfLine(rec) != null) {
                    cPoints.add(trajectory.closestIntersectionToStartOfLine(rec));
                    //add the object it shall hit
                    cCollidable.add(collidables.get(i));
                }
            }
        }
        //no collision
        if (cPoints.size() == 0) {
            return null;
        }
        //returns closest point
        CollisionInfo closestPoint = new CollisionInfo(cPoints.get(0), collidables.get(0));
        for (int i = 0; i < cPoints.size(); i++) {
            if (cPoints.get(i) == null) {
                continue;
            } else {
                closestPoint = new CollisionInfo(cPoints.get(i), cCollidable.get(i));
            }
        }
        return closestPoint;
    }

}