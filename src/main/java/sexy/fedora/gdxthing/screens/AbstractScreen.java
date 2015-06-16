package sexy.fedora.gdxthing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import sexy.fedora.gdxthing.conf.Constants;
import sexy.fedora.gdxthing.core.GdxGame;
import sexy.fedora.gdxthing.levels.Level;

public class AbstractScreen implements Screen {

    private GdxGame game;
    private OrthogonalTiledMapRenderer renderer;
    protected OrthographicCamera camera;
    private Batch spriteBatch;
    protected AssetManager manager;
    protected World world;
    private Level level;

    public AbstractScreen(GdxGame game, String levelName) {
        this.game = game;
        world = new World(new Vector2(0, Constants.GRAVITY), true);
        level = new Level(levelName, world);
        manager = game.getManager();
        renderer = new OrthogonalTiledMapRenderer(level.getTiledMap(), Constants.UNIT_SCALE);

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
        // Separate overridable update and draw methods
        update(dt);

        camera.update();
        renderer.setView(camera);
        renderer.render();

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
