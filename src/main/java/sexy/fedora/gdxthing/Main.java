package sexy.fedora.gdxthing;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import sexy.fedora.gdxthing.conf.Constants;
import sexy.fedora.gdxthing.core.GdxGame;

public class Main {

    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = Constants.TITLE;
        new LwjglApplication(new GdxGame(), config);
    }

}
