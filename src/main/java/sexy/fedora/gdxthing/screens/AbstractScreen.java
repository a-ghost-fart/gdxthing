package sexy.fedora.gdxthing.screens;

import com.badlogic.gdx.Screen;
import sexy.fedora.gdxthing.core.GdxGame;
import sexy.fedora.gdxthing.core.WorldRenderer;

public class AbstractScreen implements Screen {

    private GdxGame game;
    protected WorldRenderer renderer;

    public AbstractScreen(GdxGame game) {
        this.game = game;
        renderer = new WorldRenderer();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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
