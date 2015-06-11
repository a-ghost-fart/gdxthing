package sexy.fedora.gdxthing.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import sexy.fedora.gdxthing.core.Constants;

public class Player extends Entity {

    public static final float MAX_VELOCITY = 10f;
    public static final float JUMP_VELOCITY = 40f;
    public static final float DAMPING = 0.87f;

    private State state;
    private boolean facingRight;
    private boolean grounded;
    private float stateTime;
    private Vector2 position;
    private Vector2 velocity;
    private float width;
    private float height;
    private Texture sprite;

    @Override
    public void draw(Batch spriteBatch, float dt) {
        spriteBatch.draw(sprite, position.x, position.y, width, height);
    }

    @Override
    public void update(float dt) {

        // Handle left/right
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocity.x = -MAX_VELOCITY;
            if (grounded) {
                state = State.WALKING;
            }
            facingRight = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocity.x = MAX_VELOCITY;
            if (grounded) {
                state = State.WALKING;
            }
            facingRight = true;
        }

        // Clamp x velocity
        if (Math.abs(velocity.x) > MAX_VELOCITY) {
			velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
		}
        if (Math.abs(velocity.x) < 1) {
			velocity.x = 0;
			if (grounded) {
                state = State.STANDING;
			}
		}

        velocity.scl(dt);
        position.add(velocity);
        velocity.scl(1 / dt);
        velocity.x *= DAMPING;
    }

    public enum State {
        STANDING,
        WALKING,
        JUMPING
    }

    public Player(Texture texture) {
        position = new Vector2();
        velocity = new Vector2();
        state = State.STANDING;
        facingRight = true;
        stateTime = 0;
        grounded = false;
        sprite = texture;
        width = Constants.UNIT_SCALE * 32f;
        height = Constants.UNIT_SCALE * 32f;
    }

    // Getters 'n' Setters

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Texture getSprite() {
        return sprite;
    }

    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }

}
