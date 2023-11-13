// Ori Levy 318501897
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The type Animation runner.
 * runs the animation
 */
public class AnimationRunner {
    private GUI gui = new GUI("title", 800, 600);
    private Sleeper sleeper = new Sleeper();

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public GUI getGUI() {
        return this.gui;
    }

    /**
     * Run.
     * run the animation(gui etc.)
     * @param animation the animation
     */
    public void run(Animation animation) {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        //while we dont need to stop
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            //run animation
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}