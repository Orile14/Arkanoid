// Ori Levy 318501897

/**
 * The type Point.
 * a class that defines points in x and y values and have varies function that
 * returns information on the point, and information on the point in relation to
 * other point
 */
public class Point {
    private double x;
    private double y;
    private static final double EPSILON = 0.000001;

    /**
     * Instantiates a new Point.
     *
     * @param x point's x value
     * @param y point's y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Change x.
     *
     * @param x the x
     */
    public void changeX(double x) {
        this.x = x;
    }

    /**
     * Change y.
     *
     * @param y the y
     */
    public void changeY(double y) {
        this.y = y;
    }

    /**
     * Distance double.
     * calculate the distance between two points using the square root differences formula
     *
     * @param other the other point
     * @return the double distance between the points
     */
    public double distance(Point other) {
        double x = (this.getX() - other.getX()) * (this.getX() - other.getX());
        double y = (this.getY() - other.getY()) * (this.getY() - other.getY());
        return Math.sqrt(x + y);

    }

    /**
     * Equals boolean.
     * checks if both points are equal
     *
     * @param other the other point
     * @return the boolean if they're equal
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return Math.abs(this.x - other.x) < EPSILON && Math.abs(this.y - other.y) < EPSILON;
    }

    /**
     * Gets x.
     *
     * @return the x value of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y value of the point
     */
    public double getY() {
        return this.y;
    }
}