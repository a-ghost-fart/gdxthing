package sexy.fedora.gdxthing.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
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

        player = new Player(manager.get("testBlock.png", Texture.class));
        player.setPosition(new Vector2(10f, 2f));
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
        for (Entity entity : entityList) {
            entity.update(dt);
        }
    }

}
