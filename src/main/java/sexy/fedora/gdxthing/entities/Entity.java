package sexy.fedora.gdxthing.entities;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Entity {

    public abstract void draw(Batch spriteBatch, float dt);

    public abstract void update(float dt);

    public abstract void move(float dt);

}
