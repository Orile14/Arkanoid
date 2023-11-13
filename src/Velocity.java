// Ori Levy 318501897

/**
 * The type Velocity.
 * class that define the speed of the ball in x and y-axis returns
 * information on the speed and makes the ball center move
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx value
     * @param dy the dy value
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * From angle and speed velocity.
     * Instantiates a new Velocity by converting the speed and angle to dx and dy
     * values using sin and cos function(physics)
     *
     * @param angle the angle that the object should move at
     * @param speed the speed that the object shpuld move at
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * Get dx double.
     *
     * @return the double dx value
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy vluse
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Apply to point point.
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     *
     * @param p the point that should be modified
     * @return the point with new position
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }
}