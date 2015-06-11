package sexy.fedora.gdxthing.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import sexy.fedora.gdxthing.screens.TestScreen;

public class GdxGame extends Game {

    private TestScreen testScreen;

   private AssetManager manager;

    public void preloadAssets() {
        manager.load("testBlock.png", Texture.class);
        manager.finishLoading();
    }

    @Override
    public void create() {
        manager = new AssetManager();

        preloadAssets();

        testScreen = new TestScreen(this, "testLevel.tmx");
        setScreen(testScreen);
    }

    public AssetManager getManager() {
        return manager;
    }

}
