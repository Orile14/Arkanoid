// Ori Levy 318501897

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 * the block that shows the score
 */
public class ScoreIndicator implements Sprite {
    private static final int SCREEN_HEIGHT = 800;
    private static final int BOUNDARY = 20;
    private static final int MIDDLE = 350;
    private static final int LOC = 15;
    private ScoreTrackingListener cnt;
    private Color color = Color.WHITE;
    private Rectangle rect = new Rectangle(new Point(0, BOUNDARY), SCREEN_HEIGHT, BOUNDARY);
    private String lvlName;
    private static final int LOCATION = 550;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) ((int)
                        rect.getUpperLeft().getY() - rect.getHeight()), (int) rect.getWidth(),
                (int) rect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) ((int)
                        rect.getUpperLeft().getY() - rect.getHeight()),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.setColor(Color.BLACK);
        //draw score
        String text = "Score: " + String.valueOf(cnt.getValue());
        d.drawText(MIDDLE, LOC, text, LOC);
        String textName = "Level Name: " + lvlName;
        d.drawText(LOCATION, LOC, textName, LOC);
    }

    /**
     * Sets cnt.
     * set new score cnt
     *
     * @param s the score to update
     */
    public void setCnt(ScoreTrackingListener s) {
        cnt = s;
    }

    /**
     * Sets lvl name.
     *
     * @param lvlName the lvl name
     */
    public void setLvlName(String lvlName) {
        this.lvlName = lvlName;
    }

    @Override
    public void timePassed() {

    }
}
