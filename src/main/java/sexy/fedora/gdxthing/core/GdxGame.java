package sexy.fedora.gdxthing.core;

import com.badlogic.gdx.Game;
import sexy.fedora.gdxthing.screens.TestScreen;

public class GdxGame extends Game {

    private TestScreen testScreen;

    @Override
    public void create() {
        testScreen = new TestScreen(this);
        setScreen(testScreen);
    }
}
