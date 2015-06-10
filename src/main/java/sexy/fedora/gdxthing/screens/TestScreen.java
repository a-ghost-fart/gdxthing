package sexy.fedora.gdxthing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import sexy.fedora.gdxthing.core.GdxGame;

public class TestScreen extends AbstractScreen {

    public TestScreen(GdxGame game) {
        super(game);
    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render(dt);
    }

}
