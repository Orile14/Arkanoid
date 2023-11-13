// Ori Levy 318501897


import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private static final int RIGHT_LINE = 1;
    private static final int TOP_LINE = 2;
    private static final int BOTTOM_LINE = 3;
    private static final int SIZE = 4;
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left point
     * @param width     the width
     * @param height    the height
     */
// Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Intersection points java . util . list.
     * Return a(possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line the line to look for intersection with
     * @return the java . util . list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //defining all the rect lines
        Line leftLine = new Line(upperLeft.getX(), upperLeft.getY(),
                upperLeft.getX(), (upperLeft.getY() - height));
        Line rightLine = new Line(upperLeft.getX() + width,
                upperLeft.getY(), upperLeft.getX() + width, Math.abs(upperLeft.getY() - height));
        Line topLine = new Line(upperLeft.getX(), upperLeft.getY(),
                Math.abs(upperLeft.getX()) + width, upperLeft.getY());
        Line bottomLine = new Line(upperLeft.getX(), Math.abs(upperLeft.getY() - height),
                Math.abs(upperLeft.getX() + width), Math.abs(upperLeft.getY() - height));
        Line[] lines = new Line[SIZE];
        lines[0] = leftLine;
        lines[RIGHT_LINE] = rightLine;
        lines[TOP_LINE] = topLine;
        lines[BOTTOM_LINE] = bottomLine;
        List<Point> intersectionPoints = new ArrayList<>();
        //looking for intersection points
        for (int i = 0; i < SIZE; i++) {
            if (lines[i].intersectionWith(line) != null) {
                intersectionPoints.add(lines[i].intersectionWith(line));
            }
        }
        for (int i = 0; i < intersectionPoints.size(); i++) {
            for (int j = 0; j < intersectionPoints.size(); j++) {
                if (i == j) {
                    continue;
                }
                //removing doubles
                if (intersectionPoints.get(i).equals(intersectionPoints.get(j))) {
                    intersectionPoints.remove(j);
                }
            }
        }
        return intersectionPoints;

    }

    /**
     * Gets width.
     * Return the width of the rectangle
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     * Return the  height of the rectangle
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
