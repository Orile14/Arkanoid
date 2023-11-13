// Ori Levy 318501897
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 * a decorator class the runs the keypressed screens
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean isKeyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.isKeyPressed = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);

        // If the key was already pressed before animation started, ignore the key press
        if (isAlreadyPressed) {
            isAlreadyPressed = false;
            return;
        }

        // If the key is pressed during the animation, mark it as pressed
        if (sensor.isPressed(key)) {
            isKeyPressed = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return isKeyPressed;
    }
}
