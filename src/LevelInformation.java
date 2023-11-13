// Ori Levy 318501897
import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int balls number
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *
     * @return the list of The initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the int paddle speed
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the int paddle width
     */
    int paddleWidth();

    /**
     * Level name string.
     *
     * @return the string level name
     */
    String levelName();

    /**
     * Gets background.
     *
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * Blocks list.
     *
     * @return the list of the Blocks that make up this level, each block contains
     * its size, color and location.
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     *
     * @return the int Number of blocks that should be removed
     * before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}