package sexy.fedora.gdxthing.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import sexy.fedora.gdxthing.levels.Level;

public class WorldRenderer {

    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Level level;

    public WorldRenderer() {
        level = new Level("testLevel.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.getTiledMap(), Constants.UNIT_SCALE);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 20);
        camera.update();
    }

    public void render(float dt) {
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

}
