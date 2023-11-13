// Ori Levy 318501897

import java.util.List;

/**
 * The type Line.
 * class that define line by 2 points(not infinite) returns information on the
 * line and about it intersection points with other lines
 */
public class Line {
    private Point start;
    private Point end;
    private static final double EPSILON = 0.00001;

    /**
     * Instantiates a new Line.
     *
     * @param start the start point of the line
     * @param end   the end point of the line
     */
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x value of the start point
     * @param y1 the y value of the start point
     * @param x2 the x value of the end point
     * @param y2 the y value of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {

        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * Length double.
     * calculating the line's length using the delta square root formula
     *
     * @return the line's length
     */
// Return the length of the line
    public double length() {
        double deltaX = this.end.getX() - this.start.getX();
        double deltaY = this.end.getY() - this.start.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Middle point.
     * calculating the middle point of the line by summing the x,y values and
     * dividing in 2
     *
     * @return the line's middle point
     */
    public Point middle() {
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x = (x1 + x2) / 2;
        double y = (y1 + y2) / 2;
        return new Point(x, y);
    }

    /**
     * Start point.
     *
     * @return the line's start point
     */
// Returns the start point of the line
    public Point start() {
        return start;
    }

    /**
     * End point.
     *
     * @return the line's end point
     */
    public Point end() {
        return end;
    }

    /**
     * Closest intersection to start of line point.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @param rect the rect
     * @return the closest intersection point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        //if none
        if (intersectionPoints.size() == 0) {
            return null;
        }
        //if there is only one
        if (intersectionPoints.size() == 1) {
            return intersectionPoints.get(0);
        }
        //there can only be 2 points
        double distance1 = this.start.distance(intersectionPoints.get(0));
        double distance2 = this.start.distance(intersectionPoints.get(1));
        //checks who's closest
        if (distance1 <= distance2) {
            return intersectionPoints.get(0);
        }
        return intersectionPoints.get(1);
    }

    /**
     * Is intersecting boolean.
     * the function checks if both line intersect according to the assigment orders
     * it checks if lines intersect using slopes and line equations
     * and if they do it checks if it's in the lines segments
     * (because our line ain't infinite), it also checks if the lines overlap and if they're
     * it returns true as ordered at the assigment.
     *
     * @param other the other line were chekcing for intersection
     * @return the boolean if intersecting or not
     */
// Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        //no line at all
        if (other == null) {
            return false;
        }

        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();

        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();

        if (x1 == x2 && x3 != x4) {
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);

            // The two line segments do not overlap
            return !(minY1 > maxY2) && !(maxY1 < minY2);
            //they do overlap
        }
        if (x1 != x2 && x3 == x4) {
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);

            // The two line segments do not overlap
            return !(minY1 > maxY2) && !(maxY1 < minY2);
            //they do overlap
        }


        // Check if both lines are vertical
        if (x1 == x2 && x3 == x4) {
            //if theryre equal or not
            if (x1 != x3) {
                return false;
            }
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);

            // The two line segments do not overlap
            return !(minY1 > maxY2) && !(maxY1 < minY2);
            //they do overlap
        }


        //calculate slopes of the lines
        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y4 - y3) / (x4 - x3);
        //checking if theryre verticals
        if (slope1 == slope2) {
            // Check if the two line segments overlap
            double minX1 = Math.min(x1, x2);
            double maxX1 = Math.max(x1, x2);
            double minX2 = Math.min(x3, x4);
            double maxX2 = Math.max(x3, x4);
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);

            // The two line segments do not overlap
            return !(minX1 > maxX2) && !(maxX1 < minX2)
                    && !(minY1 > maxY2) && !(maxY1 < minY2);
            //they do overlap
        }

        //calculating interception points with y axis
        double yIntercept1 = y1 - slope1 * x1;
        double yIntercept2 = y3 - slope2 * x3;
        //same with x
        double xIntersect = (yIntercept2 - yIntercept1) / (slope1 - slope2);
        if (y1 == y2) {
            xIntersect = (y1 - yIntercept2) / slope2;

        }
        // Check if the intersection point is within both line segments
        return xIntersect >= Math.min(x1, x2) && xIntersect <= Math.max(x1, x2)
                && xIntersect >= Math.min(x3, x4) && xIntersect <= Math.max(x3, x4);
    }

    /**
     * Intersection with point.
     * the function checks if both line intersect according to the assigment orders and
     * reutrns the intersection point it checks if lines intersect using slopes and
     * line equations and if they do it checks if it's in the lines segments
     * (because our line ain't infinite), it also checks if the lines overlap and if they're
     * it returns null as ordered at the assigment.
     *
     * @param other the other line were checking for intersection with
     * @return the intersection point
     */
    public Point intersectionWith(Line other) {
        //no intersection point
        if (!isIntersecting(other)) {
            return null;
        }

        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();
        //sorting the points by values so it will be easier to know start and end
        if (x1 > x2) {
            double temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        if (x3 > x4) {
            double temp = x3;
            x3 = x4;
            x4 = temp;
            temp = y3;
            y3 = y4;
            y4 = temp;
        }
        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y4 - y3) / (x4 - x3);
        //same lines
        if (this.start.equals(other.start) && other.end.equals(this.end)) {
            return null;
        }
        //same lines but reversed
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return null;
        }
        //one start where the other ends
        if (this.start.equals(other.end) && this.start.getX() < other.end.getX()) {
            return this.start;
        }

        if (slope1 == slope2) {
            double minX1 = Math.min(x1, x2);
            double maxX1 = Math.max(x1, x2);
            double minX2 = Math.min(x3, x4);
            double maxX2 = Math.max(x3, x4);
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);
            //if they're not overlapping
            if (minX1 > maxX2 || maxX1 > minX2 || minY1 < maxY2 || maxY1 < minY2) {
                if (x2 == x3 && y2 == y3) {
                    return new Point(x2, y2);
                }
                if (x1 == x4 && y1 == y4) {
                    return new Point(x1, y1);
                }
                //if they do overlap
                return null;
            }
        }
        //only one overlap point
        if (this.start.equals(other.end)) {
            return this.start;
        }
        if (this.start.equals(other.start)) {
            return other.start;
        }
        if (this.end.equals(other.start)) {
            return other.start;
        }
        if (this.end.equals(other.end)) {
            return other.end;
        }

        //if slopes are equal
        if (slope1 == slope2) {
            return null;
        }
        if (x1 == x2) {
            // this is vertical line
            slope2 = (y4 - y3) / (x4 - x3);
            double y = slope2 * (x1 - x3) + y3;
            double minX1 = Math.min(x1, x2);
            double maxX1 = Math.max(x1, x2);
            double minX2 = Math.min(x3, x4);
            double maxX2 = Math.max(x3, x4);
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);
            if (minX1 > maxX2 || maxX1 < minX2 || minY1 > maxY2 || maxY1 < minY2) {
                // The lines do not intersect
                return null;
            } else {
                if (y <= maxY1 && y >= minY1) {
                    // The lines intersect
                    return new Point(x1, y);
                }
                return null;
            }

        } else if (x3 == x4) {
            // other is a vertical line
            slope1 = (y2 - y1) / (x2 - x1);
            double y = slope1 * (x3 - x1) + y1;
            double minX1 = Math.min(x1, x2);
            double maxX1 = Math.max(x1, x2);
            double minX2 = Math.min(x3, x4);
            double maxX2 = Math.max(x3, x4);
            double minY1 = Math.min(y1, y2);
            double maxY1 = Math.max(y1, y2);
            double minY2 = Math.min(y3, y4);
            double maxY2 = Math.max(y3, y4);
            if (minX1 > maxX2 || maxX1 < minX2 || minY1 > maxY2 || maxY1 < minY2) {
                // The lines do not intersect
                return null;
            } else {
                // The lines intersect
                return new Point(x3, y);
            }
        } else {
            if (Double.isInfinite(slope1)) {
                double y = slope2 * (x1 - x3) + y3;
                return new Point(x1, y);
            } else if (Double.isInfinite(slope2)) {
                double y = slope1 * (x3 - x1) + y1;
                return new Point(x3, y);
            }

//             both lines have defined slopes
            slope2 = (y4 - y3) / (x4 - x3);
            double yIntersect1 = y1 - slope1 * x1;
            double yIntersect2 = y3 - slope2 * x3;
            double x = (yIntersect2 - yIntersect1) / (slope1 - slope2);
            double y = slope1 * x + yIntersect1;
            return new Point(x, y);
        }


    }

    /**
     * Equals boolean.
     * check if the lines are equal
     *
     * @param other the other line were checking
     * @return the boolean if they're equal or not
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start)) && (this.end.equals(other.end));
    }
}
