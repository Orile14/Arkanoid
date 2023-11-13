// Ori Levy 318501897
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 6 game.
 * runs the game
 */
public class Ass6Game {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        LevelInformation l2 = new WideEasy();
        LevelInformation l3 = new Green3();
        LevelInformation l1 = new DirectHit();
        List<LevelInformation> lvls = new ArrayList<>();
        //according to input
            for (String arg : args) {
                if (arg.equals("1")) {
                    lvls.add(l1);
                }
                if (arg.equals("2")) {
                    lvls.add(l2);
                }
                if (arg.equals("3")) {
                    lvls.add(l3);
                }
            }
            //there is no args
            if (lvls.size() == 0) {
                lvls.add(l1);
                lvls.add(l2);
                lvls.add(l3);
                AnimationRunner runner = new AnimationRunner();
                KeyboardSensor ks = runner.getGUI().getKeyboardSensor();
                GameFlow gf = new GameFlow(runner, ks);
                gf.runLevels(lvls);
            }
            AnimationRunner runner = new AnimationRunner();
            KeyboardSensor ks = runner.getGUI().getKeyboardSensor();
            GameFlow gf = new GameFlow(runner, ks);
            gf.runLevels(lvls);

        }
    }


