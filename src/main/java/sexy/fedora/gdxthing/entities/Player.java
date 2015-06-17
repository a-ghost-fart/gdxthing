package sexy.fedora.gdxthing.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import sexy.fedora.gdxthing.conf.Options;
import sexy.fedora.gdxthing.util.PhysicsUtil;

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
    private Texture texture;

    private Sprite sprite;
    private Body body;

    public Player(World world) {
        texture = new Texture("testBlock.png");
        sprite = new Sprite(texture);
        position = new Vector2(0f, 100f);
        velocity = new Vector2();
        state = State.STANDING;
        facingRight = true;
        stateTime = 0;
        grounded = false;
        initPhysics(world);
    }

    private void initPhysics(World world) {
        body = PhysicsUtil.createDynamicBody(
                world,
                sprite.getWidth(),
                sprite.getHeight(),
                position.x,
                position.y
        );
    }


    @Override
    public void draw(Batch spriteBatch, float dt) {
        spriteBatch.draw(
                texture,
                sprite.getX(),
                sprite.getY(),
                sprite.getWidth(),
                sprite.getHeight()
        );
    }

    @Override
    public void update(float dt) {
        handleInput(dt);
        move(dt);

        sprite.setPosition(body.getPosition().x, body.getPosition().y);
    }

    public void handleInput(float dt) {

        if (Gdx.input.isKeyPressed(Options.LEFT)) {
            velocity.x = -MAX_VELOCITY;
            if (grounded) {
                state = State.WALKING;
            }
            facingRight = false;
        }

        if (Gdx.input.isKeyPressed(Options.RIGHT)) {
            velocity.x = MAX_VELOCITY;
            if (grounded) {
                state = State.WALKING;
            }
            facingRight = true;
        }

        if (Gdx.input.isKeyPressed(Options.JUMP)) {
            if (grounded) {
                state = State.JUMPING;
            }
        }

        if (Gdx.input.isKeyPressed(Options.INTERACT)) {

        }

    }

    @Override
    public void move(float dt) {
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
        JUMPING,
        BUSY
    }

    // Getters 'n' Setters


    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }


}
