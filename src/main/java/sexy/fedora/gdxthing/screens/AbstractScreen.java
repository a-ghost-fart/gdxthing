package sexy.fedora.gdxthing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import sexy.fedora.gdxthing.core.Constants;
import sexy.fedora.gdxthing.core.GdxGame;
import sexy.fedora.gdxthing.levels.Level;

public class AbstractScreen implements Screen {

    private GdxGame game;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Level level;
    private Batch spriteBatch;
    protected AssetManager manager;

    public AbstractScreen(GdxGame game, String levelName) {
        this.game = game;
        level = new Level(levelName);
        renderer = new OrthogonalTiledMapRenderer(level.getTiledMap(), Constants.UNIT_SCALE);
        manager = game.getManager();

        spriteBatch = renderer.getBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 20);
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        // Boilerplate clear and render
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        // Separate overridable update and draw methods
        update(dt);

        spriteBatch.begin();
        draw(spriteBatch, dt);
        spriteBatch.end();
    }

    public void draw(Batch spriteBatch, float dt) {

    }

    public void update(float dt) {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
