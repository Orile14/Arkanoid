// Ori Levy 318501897
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Building.
 * building backgroung
 */
public class Building implements Sprite {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int BUILDING_X = 50;
    private static final int BUILDING_Y = 400;
    private static final int BUILDING_WIDTH = 150;
    private static final int BUILDING_HEIGHT = 200;
    private static final int WINDOW_WIDTH = 20;
    private static final int WINDOW_HEIGHT = 35;
    private static final int WINDOW_ROW_COUNT = 4;
    private static final int WINDOW_COL_COUNT = 5;
    private static final int WINDOW_OFFSET_X = 55;
    private static final int WINDOW_OFFSET_Y = 410;
    private static final int ROOF_CENTER_X = 125;
    private static final int ROOF_CENTER_Y = 150;
    private static final int ROOF_OUTER_RADIUS = 15;
    private static final int ROOF_MIDDLE_RADIUS = 10;
    private static final int ROOF_INNER_RADIUS = 5;
    private static final int THIRTY = 30;
    private static final int SEVENTY = 70;
    private static final int SIXTY = 60;
    private static final int FORTY_FIVE = 45;
    private static final int TWO_FORTY = 240;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green.darker());
        d.fillRectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        d.setColor(Color.BLACK);
        d.fillRectangle(BUILDING_X, BUILDING_Y, BUILDING_WIDTH, BUILDING_HEIGHT);
        d.setColor(Color.gray);
        d.fillRectangle(BUILDING_X + SIXTY, BUILDING_Y - SEVENTY, THIRTY, SEVENTY);
        d.setColor(Color.gray.darker());
        d.fillRectangle(BUILDING_X + SEVENTY, BUILDING_Y - TWO_FORTY,
                ROOF_MIDDLE_RADIUS, BUILDING_WIDTH + WINDOW_WIDTH);
        d.setColor(Color.WHITE);
        for (int i = 0; i < WINDOW_ROW_COUNT; i++) {
            for (int j = 0; j < WINDOW_COL_COUNT; j++) {
                d.fillRectangle(WINDOW_OFFSET_X + j * THIRTY,
                        WINDOW_OFFSET_Y + i * FORTY_FIVE, WINDOW_WIDTH, WINDOW_HEIGHT);
            }
        }
        d.setColor(Color.pink);
        d.fillCircle(ROOF_CENTER_X, ROOF_CENTER_Y, ROOF_OUTER_RADIUS);
        d.setColor(Color.white);
        d.fillCircle(ROOF_CENTER_X, ROOF_CENTER_Y, ROOF_MIDDLE_RADIUS);
        d.setColor(Color.red);
        d.fillCircle(ROOF_CENTER_X, ROOF_CENTER_Y, ROOF_INNER_RADIUS);
    }

    @Override
    public void timePassed() {

    }
}
