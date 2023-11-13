// Ori Levy 318501897

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Ball.
 * class that define ball with specific size and location(according to it
 * center point) and specific velocity and color, returns information about
 * the ball and making it move across the screen and draw it
 */
public class Ball implements Sprite {
    private int radius;
    private Point point;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Sets game environment.
     *
     * @param g the g
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param i      the center point x value
     * @param j      the center point y value
     * @param radius the ball's radius
     * @param color  the ball's color
     */
// constructor
    public Ball(int i, int j, int radius, java.awt.Color color) {
        this.radius = radius;
        this.point = new Point(i, j);
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param center the center point of the ball
     * @param radius the ball's radious
     * @param color  the ball's color
     */
    public Ball(Point center, int radius, java.awt.Color color) {
        this.radius = radius;
        this.point = center;
        this.color = color;
    }

    /**
     * Gets x.
     *
     * @return the x value of the ball center
     */
// accessors
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * Get y value of the ball's center point.
     *
     * @return the int y value
     */
    public int getY() {
        return (int) this.point.getY();
    }

    /**
     * Get the ball's size(radius).
     *
     * @return the int radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Get the ball's color.
     *
     * @return the java . awt . color ball's color
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * Draw on. the ball
     *
     * @param surface the surface that the ball should be drawn at
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.point.getX(), (int) this.point.getY(), radius);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Set velocity. to the ball
     *
     * @param v the velocity should be set
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;

    }

    /**
     * Set velocity. to the ball
     *
     * @param dx the dx velocity
     * @param dy the dy velocity
     */
    public void setVelocity(double dx, double dy) {

        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Get velocity of the ball.
     *
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Move one step.
     * the function make the ball move inside the surface and "bounce" between
     * the surface walls and blocks by checking after each step if the next step will
     * have a collision point with an object on the screen(block or paddle),
     * if it has a collision point changes it velocity to the other way(accordingly to
     * the point) what's make it look like it bouncing back and if it doesn't have a
     * collsion point it move it according to the ball velocity
     */
    public void moveOneStep() {
        if (this.velocity == null) {
            return;
        }
        //calculating trajectory
        double nextX = this.point.getX() + this.velocity.getDx();
        double nextY = this.point.getY() + this.velocity.getDy();
        Line trajectory = new Line(point.getX(), point.getY(), nextX, nextY);
        //if no collision points, move the ball according to velocity
        if (gameEnvironment.getClosestCollision(trajectory) == null) {
            point = velocity.applyToPoint(point);
            return;
        }
        double collisionX = gameEnvironment.
                getClosestCollision(trajectory).collisionPoint().getX();
        double collisionY = gameEnvironment.
                getClosestCollision(trajectory).collisionPoint().getY();
        //if it's the point were at now
        if (this.point.getX() == collisionX && this.point.getY() == collisionY) {
            //ignore the collision
            point = velocity.applyToPoint(point);
            return;
        }
        Point collisionPoint = new Point(collisionX, collisionY);
        //change velocity according to the object hitted
        Velocity newVelocity = gameEnvironment.getClosestCollision(trajectory).
                collisionObject().hit(this, collisionPoint, velocity);
        //if it's the same,move the ball
        if (newVelocity == velocity) {
            point = velocity.applyToPoint(point);
        }
        setVelocity(newVelocity);
    }

    /**
     * Add to game.
     * add the ball to the game class
     *
     * @param g the game to be added to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove from game.
     * remove the ball from the game
     *
     * @param g the game to remove from
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}
