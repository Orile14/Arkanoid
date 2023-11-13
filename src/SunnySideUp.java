//Ori Levy 318501897

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Sunny side up.
 * draws the sun level
 */
public class SunnySideUp implements Sprite {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int SUN_X = 100;
    private static final int SUN_Y = 100;
    private static final int SUN_RADIUS_1 = 50;
    private static final int SUN_RADIUS_2 = 40;
    private static final int SUN_RADIUS_3 = 30;
    private static final int LINE_START_X = 100;
    private static final int LINE_START_Y = 100;
    private static final int LINE_END_Y = 250;
    private static final int LINE_INCREMENT = 30;
    private static final int NUM_LINES = 35;

    @Override
    public void drawOn(DrawSurface d) {
        // Fill the background with light gray color
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // Draw the sun rays
        d.setColor(Color.YELLOW);
        for (int i = 0; i < NUM_LINES; i++) {
            d.drawLine(LINE_START_X, LINE_START_Y, i * LINE_INCREMENT, LINE_END_Y);
        }

        // Draw the sun circles with varying colors
        d.setColor(Color.YELLOW.darker().darker());
        d.fillCircle(SUN_X, SUN_Y, SUN_RADIUS_1);
        d.setColor(Color.YELLOW.darker());
        d.fillCircle(SUN_X, SUN_Y, SUN_RADIUS_2);
        d.setColor(Color.YELLOW);
        d.fillCircle(SUN_X, SUN_Y, SUN_RADIUS_3);
    }

    @Override
    public void timePassed() {
    }
}
