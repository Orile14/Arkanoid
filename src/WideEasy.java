// Ori Levy 318501897
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wide easy.
 * the second level blocks
 */
public class WideEasy implements LevelInformation {
    private static final int NUMBER_OF_BALLS = 10;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 500;
    private static final String LEVEL_NAME = "Wide Easy";
    private static final int BLOCK_WIDTH = 55;
    private static final int BLOCK_HEIGHT = 20;
    private static final int BLOCKS_PER_ROW = 16;
    private static final int BLOCK_START_X = 730;
    private static final int BLOCK_START_Y = 250;
    private static final int BLOCKS_OFFSET = 55;
    private static final int GREEN_BLOCK_X = 670;
    private static final int RED_BLOCK_X = 560;
    private static final int YELLOW_BLOCK_X = 450;
    private static final int BLUE_BLOCK_X = 340;
    private static final int PINK_BLOCK_X = 230;
    private static final int ORANGE_BLOCK_X = 110;
    private static final int MAGENTA_BLOCK_X = 0;
    private static final int BALL_SPEED_X = 1;
    private static final int BALL_SPEED_Y = -5;
    private static final int SECOND_BALL_SPEED_X = 2;
    private static final int SECOND_BALL_SPEED_Y = -4;
    private static final int THIRD_BALL_SPEED_X = -1;
    private static final int THIRD_BALL_SPEED_Y = -5;
    private static final int FOURTH_BALL_SPEED_X = 0;
    private static final int FOURTH_BALL_SPEED_Y = -5;
    private static final int FIFTH_BALL_SPEED_X = 1;
    private static final int FIFTH_BALL_SPEED_Y = -5;
    private static final int SIXTH_BALL_SPEED_X = -2;
    private static final int SIXTH_BALL_SPEED_Y = -5;
    private static final int SEVENTH_BALL_SPEED_X = 4;
    private static final int SEVENTH_BALL_SPEED_Y = -5;
    private static final int EIGHTH_BALL_SPEED_X = 3;
    private static final int EIGHTH_BALL_SPEED_Y = -5;
    private static final int NINTH_BALL_SPEED_X = -3;
    private static final int NINTH_BALL_SPEED_Y = -3;
    private static final int TENTH_BALL_SPEED_X = 0;
    private static final int TENTH_BALL_SPEED_Y = -4;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(BALL_SPEED_X, BALL_SPEED_Y));
        velocities.add(new Velocity(SECOND_BALL_SPEED_X, SECOND_BALL_SPEED_Y));
        velocities.add(new Velocity(THIRD_BALL_SPEED_X, THIRD_BALL_SPEED_Y));
        velocities.add(new Velocity(FOURTH_BALL_SPEED_X, FOURTH_BALL_SPEED_Y));
        velocities.add(new Velocity(FIFTH_BALL_SPEED_X, FIFTH_BALL_SPEED_Y));
        velocities.add(new Velocity(SIXTH_BALL_SPEED_X, SIXTH_BALL_SPEED_Y));
        velocities.add(new Velocity(SEVENTH_BALL_SPEED_X, SEVENTH_BALL_SPEED_Y));
        velocities.add(new Velocity(EIGHTH_BALL_SPEED_X, EIGHTH_BALL_SPEED_Y));
        velocities.add(new Velocity(NINTH_BALL_SPEED_X, NINTH_BALL_SPEED_Y));
        velocities.add(new Velocity(TENTH_BALL_SPEED_X, TENTH_BALL_SPEED_Y));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return LEVEL_NAME;
    }

    @Override
    public Sprite getBackground() {
        return new SunnySideUp();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        //create blocks
        for (int i = 0; i < BLOCKS_PER_ROW; i++) {
            int blockX = BLOCK_START_X - i * BLOCKS_OFFSET;
            Rectangle rect = new Rectangle(new Point(blockX, BLOCK_START_Y), BLOCK_WIDTH, BLOCK_HEIGHT);
            //set colors
            if (blockX >= GREEN_BLOCK_X) {
                blocks.add(new Block(rect, Color.green));
            } else if (blockX >= RED_BLOCK_X) {
                blocks.add(new Block(rect, Color.red));
            } else if (blockX >= YELLOW_BLOCK_X) {
                blocks.add(new Block(rect, Color.yellow));
            } else if (blockX >= BLUE_BLOCK_X) {
                blocks.add(new Block(rect, Color.blue));
            } else if (blockX >= PINK_BLOCK_X) {
                blocks.add(new Block(rect, Color.pink));
            } else if (blockX >= ORANGE_BLOCK_X) {
                blocks.add(new Block(rect, Color.ORANGE));
            } else if (blockX >= MAGENTA_BLOCK_X) {
                blocks.add(new Block(rect, Color.magenta));
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
