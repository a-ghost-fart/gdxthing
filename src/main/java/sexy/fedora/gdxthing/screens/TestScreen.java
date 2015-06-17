package sexy.fedora.gdxthing.screens;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.google.common.collect.Lists;
import sexy.fedora.gdxthing.entities.Entity;
import sexy.fedora.gdxthing.entities.Player;
import sexy.fedora.gdxthing.core.GdxGame;

import java.util.List;

public class TestScreen extends AbstractScreen {

    private Player player;
    private List<Entity> entityList;

    public TestScreen(GdxGame game, String levelName) {
        super(game, levelName);
        entityList = Lists.newArrayList();

        player = new Player(world);
        entityList.add(player);
    }

    @Override
    public void draw(Batch spriteBatch, float dt) {
        for (Entity entity : entityList) {
            entity.draw(spriteBatch, dt);
        }
    }

    @Override
    public void update(float dt) {
        world.step(dt, 6, 2);
        camera.position.set(player.getSprite().getX(), player.getSprite().getY(), 0);

        for (Entity entity : entityList) {
            entity.update(dt);
        }
    }

}
