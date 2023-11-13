// Ori Levy 318501897


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private static final int FIRST_BLOCK = 2;
    private static final int SECOND_BLOCK = 3;
    private static final int THIRD_BLOCK = 4;
    private static final int FORTH_BLOCK = 5;
    private static final int ZONES_NUM = 5;
    private static final int FIRST_ANGLE = 30;
    private static final int SECOND_ANGLE = 60;
    private static final int RIGHT_BOUNDARY = 780;
    private static final int LEFT_BOUNDARY = 20;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private int speed;

    /**
     * Instantiates a new Paddle.
     *
     * @param rect  the paddle rect // Ori Levy 318501897
     * @param speed the speed
     */
    public Paddle(Rectangle rect, int speed) {
        this.rect = rect;
        this.speed = speed;
    }

    /**
     * Sets keyboard.
     *
     * @param keyboard the keyboard to take input from
     */
    public void setKeyboard(biuoop.KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * Move left.
     * makes the paddle move left when user input is left
     */
    public void moveLeft() {
        //if the paddle over the limit
        if (rect.getUpperLeft().getX() <= LEFT_BOUNDARY) {
            return;
        }
        //making it move
        Point newUpperLeft = new Point(rect.getUpperLeft().getX() - this.speed,
                rect.getUpperLeft().getY());
        this.rect = new Rectangle(newUpperLeft, rect.getWidth(), rect.getHeight());
    }

    /**
     * Move right.
     * makes the paddle move right when user input is right
     */
    public void moveRight() {
        //if the paddle over the limit
        if (rect.getUpperLeft().getX() + rect.getWidth() >= RIGHT_BOUNDARY) {
            return;
        }
        //making it move
        Point newUpperLeft = new Point(rect.getUpperLeft().getX() + this.speed,
                rect.getUpperLeft().getY());
        this.rect = new Rectangle(newUpperLeft, rect.getWidth(), rect.getHeight());
    }

    @Override
    public void timePassed() {
        //checking for user input
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow.darker());
        d.fillRectangle((int) rect.getUpperLeft().getX(),
                (int) ((int) rect.getUpperLeft().getY() - rect.getHeight()),
                (int) rect.getWidth(), (int) rect.getHeight());
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double y = collisionPoint.getY();
        double x = collisionPoint.getX();
        double split = (rect.getWidth() / ZONES_NUM);
        double start = rect.getUpperLeft().getX();
        double speed = Math.sqrt((dx * dx) + (dy * dy));
        //if ball is stuck inside the paddle
        if (dy < 0 && x < (start + (split * ZONES_NUM)) && x > (start)) {
            return currentVelocity;
        }
        //changing speed according to the hit location
        if (x >= (start + (FIRST_BLOCK * split)) && x < (start + (SECOND_BLOCK * split))) {
            dy = -dy;
        } else if (x >= (start) && x < (start + (split)) || y == rect.getUpperLeft().getY()) {
            return Velocity.fromAngleAndSpeed(-SECOND_ANGLE, speed);
        } else if (x >= (start + split) && x < (start + (split * FIRST_BLOCK))) {
            return Velocity.fromAngleAndSpeed(-FIRST_ANGLE, speed);
        } else if (x >= (start + split * SECOND_BLOCK) && x < (start + (split * THIRD_BLOCK))) {
            return Velocity.fromAngleAndSpeed(FIRST_ANGLE, speed);
        } else if (x >= (start + split * THIRD_BLOCK) && x <= (start + (split * FORTH_BLOCK))
                || y == rect.getUpperLeft().getY()) {
            return Velocity.fromAngleAndSpeed(SECOND_ANGLE, speed);
        }
        return new Velocity(dx, dy);
    }

    /**
     * Add to game.
     *
     * @param g the game to add to
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}