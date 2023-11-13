// Ori Levy 318501897

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;

/**
 * The type Game.
 * runs a specific level of the game
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private static final int HUNDRED = 100;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int FIVE = 5;
    private static final int PADDLE_HEIGHT = 15;
    private static final int X_START = 780;
    private static final int BOUNDARY_WIDTH = 20;
    private static final int BOUNDARY_HEIGHT = 580;
    private static final int BALLS_LOCATIONY = 560;
    private static final int BALLS_LOCATIONX = 400;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCnt = new Counter();
    private Counter ballCnt = new Counter();
    private ScoreTrackingListener score;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * Instantiates a new Game level.
     *
     * @param levelInformation the level information
     * @param ks               the ks
     * @param ar               the ar
     * @param score            the score
     */
    public GameLevel(LevelInformation levelInformation,
                     KeyboardSensor ks, AnimationRunner ar, ScoreTrackingListener score) {
        this.levelInformation = levelInformation;
        this.keyboard = ks;
        this.runner = ar;
        this.score = score;
    }

    /**
     * Gets ball cnt.
     *
     * @return the ball cnt
     */
    public Counter getBallCnt() {
        return ballCnt;
    }

    /**
     * Remove collidable.
     * remove the collidable from the game
     *
     * @param c the collidable to remove
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     * remove the sprite from the game
     *
     * @param s the sprtie to remove
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Add collidable.
     *
     * @param c the collidable to add
     */
    public void addCollidable(Collidable c) {

        environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize.
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        //special score indicator block
        ScoreIndicator sc = new ScoreIndicator();
        sc.setLvlName(this.levelInformation.levelName());
        sc.setCnt(score);
        sprites = new SpriteCollection();
        sprites.addSprite(levelInformation.getBackground());
        environment = new GameEnvironment();
        sprites.addSprite(sc);
        BlockRemover br = new BlockRemover(this, blockCnt);
        //add all blocks
        List<Block> objects = levelInformation.blocks();
        for (Block c : objects) {
            c.addHitListener(br);
            c.addHitListener(score);
            c.addToGame(this);
        }
        //update counter
        blockCnt.increase(this.levelInformation.blocks().size() + THREE);
        //boundries blocks
        Point p1 = new Point(0, BOUNDARY_WIDTH + BOUNDARY_WIDTH);
        Point p2 = new Point(0, SCREEN_HEIGHT);
        Point p3 = new Point(0, SCREEN_HEIGHT + BOUNDARY_WIDTH);
        Point p4 = new Point(X_START, SCREEN_HEIGHT);
        Rectangle r1 = new Rectangle(p1, SCREEN_WIDTH, BOUNDARY_WIDTH);
        Rectangle r2 = new Rectangle(p2, BOUNDARY_WIDTH, SCREEN_HEIGHT);
        Rectangle r3 = new Rectangle(p3, SCREEN_WIDTH, BOUNDARY_WIDTH);
        Rectangle r4 = new Rectangle(p4, BOUNDARY_WIDTH, SCREEN_WIDTH);
        Block block1 = new Block(r1, Color.gray);
        Block block2 = new Block(r2, Color.gray);
        Block block3 = new Block(r3, Color.gray);
        Block block4 = new Block(r4, Color.gray);
        BallRemover ballRemover = new BallRemover(this, ballCnt);
        block3.addHitListener(ballRemover);
        block1.addToGame(this);
        block2.addToGame(this);
        block3.addToGame(this);
        block4.addToGame(this);
        Point paddlePoint = new Point((SCREEN_WIDTH - this.levelInformation.paddleWidth()) / TWO, BOUNDARY_HEIGHT);
        Rectangle rPaddle = new Rectangle(paddlePoint, this.levelInformation.paddleWidth(), PADDLE_HEIGHT);
        Paddle paddle = new Paddle(rPaddle, this.levelInformation.paddleSpeed());
        paddle.setKeyboard(keyboard);
        paddle.addToGame(this);
        //creating ball
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(BALLS_LOCATIONX, BALLS_LOCATIONY, FIVE, Color.WHITE);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
        }
        ballCnt.increase(this.levelInformation.numberOfBalls());


    }

    /**
     * Run.
     * // Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(TWO, THREE, this.sprites, this));
        this.running = true;
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            //stop game
            this.runner.run(new KeyPressStoppableAnimation(keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(keyboard)));
        }
        //finish all blocks
        if (environment.getCollidables().size() == FIVE) {
            score.increase(HUNDRED);
            this.running = false;
        }
        //lost all balls
        if (ballCnt.getValue() == 0) {
            this.running = false;
        }

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}