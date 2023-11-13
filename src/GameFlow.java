// Ori Levy 318501897
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * The type Game flow.
 * runs the levels
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private ScoreTrackingListener score = new ScoreTrackingListener(new Counter());

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;

    }

    /**
     * Run levels.
     *run different levels in the game according to input
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            //create the level
            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner, this.score);
            level.initialize();
            while (true) {
                level.run();
                if (level.shouldStop()) {
                    //if player lost
                    if (level.getBallCnt().getValue() == 0) {
                        while (true) {
                            //end game score
                            KeyPressStoppableAnimation end = new KeyPressStoppableAnimation(keyboardSensor,
                                    KeyboardSensor.SPACE_KEY, new EndScreen(score.getValue(),
                                    keyboardSensor));
                            animationRunner.run(end);
                            if (end.shouldStop()) {
                                animationRunner.getGUI().close();
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!level.shouldStop()) {
                break;
            }

        }
        while (true) {
            //end game score
            KeyPressStoppableAnimation end = new KeyPressStoppableAnimation(keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new EndScreen(score.getValue(),
                    keyboardSensor));
            animationRunner.run(end);
            if (end.shouldStop()) {
                animationRunner.getGUI().close();
                break;
            }

        }
    }

}