// Ori Levy 318501897
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Direct hit.
 * one block hit screen
 */
public class DirectHit implements LevelInformation {
    private static final int NUMBER_OF_BALLS = 1;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 100;
    private static final int FORTY = 40;
    private static final int LOCATION = 300;
    private static final int LOCATION1 = 380;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<Velocity>();
        list.add(new Velocity(0, -PADDLE_SPEED));

        return list;
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new HeadShot();
    }

    @Override
    public List<Block> blocks() {
        List<Block> objects = new ArrayList<>();

        // Creating the rectangle representing the block's position and size
        Rectangle rect = new Rectangle(new Point(LOCATION1, LOCATION), FORTY, FORTY);

        // Creating the block with the specified rectangle and color
        Block block = new Block(rect, Color.red);

        // Adding the block to the list of objects
        objects.add(block);

        return objects;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
