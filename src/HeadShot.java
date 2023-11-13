// Ori Levy 318501897
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Headshot.
 * creates the first level target mark
 */
public class HeadShot implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int CENTER_X = WIDTH / 2;
    private static final int CENTER_Y = HEIGHT / 2 - 25;
    private static final int OUTER_RADIUS = 150;
    private static final int MIDDLE_RADIUS = 100;
    private static final int INNER_RADIUS = 50;
    private static final int LINE_START_X = CENTER_X - OUTER_RADIUS;
    private static final int LINE_END_X = CENTER_X + OUTER_RADIUS;
    private static final int LINE_Y = CENTER_Y;
    private static final int LINE_START_Y = CENTER_Y - OUTER_RADIUS;
    private static final int LINE_END_Y = CENTER_Y + OUTER_RADIUS;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        d.setColor(Color.BLUE);
        d.drawCircle(CENTER_X, CENTER_Y, INNER_RADIUS);
        d.drawCircle(CENTER_X, CENTER_Y, MIDDLE_RADIUS);
        d.drawCircle(CENTER_X, CENTER_Y, OUTER_RADIUS);
        d.drawLine(LINE_START_X, LINE_Y, LINE_END_X, LINE_Y);
        d.drawLine(CENTER_X, LINE_START_Y, CENTER_X, LINE_END_Y);
    }

    @Override
    public void timePassed() {

    }
}
