// Ori Levy 318501897

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private static final double EPSILON = 0.00000001;
    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Block.
     *
     * @param rect  the rect
     * @param color the color
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
    }

    /**
     * Sets color.
     *
     * @param color the c
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * Add to game.
     *
     * @param gameLevel the game to be added to
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double collisionY = collisionPoint.getY();
        double collisionX = collisionPoint.getX();
        //hit from the top
        if (Math.abs(rect.getUpperLeft().getY() - collisionY) < EPSILON) {
            dy = -dy;
        }
        //hit from the bottom
        if (Math.abs(Math.abs(rect.getUpperLeft().getY() - rect.getHeight())
                - collisionY) < EPSILON) {
            dy = -dy;
        }
        //hit from the left
        if (Math.abs(rect.getUpperLeft().getX() - collisionX) < EPSILON) {
            dx = -dx;
        }
        //hit from th rigth
        if (Math.abs(Math.abs(rect.getUpperLeft().getX() + rect.getWidth())
                - collisionX) < EPSILON) {
            dx = -dx;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) ((int)
                        rect.getUpperLeft().getY() - rect.getHeight()), (int) rect.getWidth(),
                (int) rect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) ((int)
                        rect.getUpperLeft().getY() - rect.getHeight()),
                (int) rect.getWidth(), (int) rect.getHeight());
    }

    /**
     * Remove from game.
     * remove the block from the game
     *
     * @param gameLevel the game to remove from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Notify hit.
     * Notify all listeners about a hit event:
     *
     * @param hitter the hitter ball
     */
    public void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
