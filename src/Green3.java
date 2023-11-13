// Ori Levy 318501897
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Green 3.
 * creates the third level
 */
public class Green3 implements LevelInformation {
    private static final int BLOCK_WIDTH = 60;
    private static final int FIRST_BLOCK = 2;
    private static final int SECOND_BLOCK = 3;
    private static final int THIRD_BLOCK = 4;
    private static final int FORTH_BLOCK = 5;
    private static final int FIFTH_BLOCK = 6;
    private static final int SIXTH_BLOCK = 7;
    private static final int ONE = 1;
    private static final int SCREEN_WIDTH = 800;
    private static final int BLOCK_HEIGHT = 25;
    private static final int ROWS = 7;
    private static final int COLS = 12;
    private static final int X_START = 780;
    private static final int Y_START = 50;
    private static final int BOUNDARY_WIDTH = 20;

    @Override
    public int numberOfBalls() {
        return FIRST_BLOCK;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<Velocity>();
        list.add(new Velocity(0, -FORTH_BLOCK));
        list.add(new Velocity(ONE, -FORTH_BLOCK));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return FORTH_BLOCK;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {

        return new Building();
    }

    @Override
    public List<Block> blocks() {
        List<Rectangle> rectangles = new ArrayList<>();
        int x = X_START;
        int y = Y_START;
        int rows = ROWS;
        int cols = COLS;
        //create blocks
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rectangles.add(new Rectangle(new Point(x + BLOCK_WIDTH,
                        y + BLOCK_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT));
                x += BLOCK_WIDTH;
            }
            // reset the x-coordinate for the next row
            x = SCREEN_WIDTH - (BLOCK_WIDTH * cols) - BOUNDARY_WIDTH;
            y += BLOCK_HEIGHT;
            cols--;
        }
        //setting colors
        List<Block> objects = new ArrayList<>();
        for (Rectangle r : rectangles) {
            if (r.getUpperLeft().getY() == Y_START + BLOCK_HEIGHT * FIRST_BLOCK) {
                objects.add(new Block(r, Color.gray));
            }
            if (r.getUpperLeft().getY() == Y_START + BLOCK_HEIGHT * SECOND_BLOCK) {
                objects.add(new Block(r, Color.red));
            }
            if (r.getUpperLeft().getY() == Y_START + BLOCK_HEIGHT * THIRD_BLOCK) {
                objects.add(new Block(r, Color.yellow));
            }
            if (r.getUpperLeft().getY() == Y_START + BLOCK_HEIGHT * FORTH_BLOCK) {
                objects.add(new Block(r, Color.blue));
            }
            if (r.getUpperLeft().getY() == Y_START + BLOCK_HEIGHT * FIFTH_BLOCK) {
                objects.add(new Block(r, Color.pink));
            }
            if (r.getUpperLeft().getY() == Y_START + BLOCK_HEIGHT * SIXTH_BLOCK) {
                objects.add(new Block(r, Color.green));
            }

        }
        return objects;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
