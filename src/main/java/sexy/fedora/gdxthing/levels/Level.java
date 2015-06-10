package sexy.fedora.gdxthing.levels;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {

    private TiledMap tiledMap;

    public Level(String tiledMapName) {
        tiledMap = new TmxMapLoader().load(tiledMapName);
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

}
