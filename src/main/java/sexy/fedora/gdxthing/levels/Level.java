package sexy.fedora.gdxthing.levels;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.google.common.collect.Lists;
import sexy.fedora.gdxthing.conf.Constants;
import sexy.fedora.gdxthing.util.PhysicsUtil;

import java.util.List;

public class Level {

    private List<Body> bodies;
    private TiledMap tiledMap;

    public Level(final String tiledMapName, final World world) {
        tiledMap = new TmxMapLoader().load(tiledMapName);
        bodies = generateBodies(world);
    }

    private List<Body> generateBodies(final World world) {
        List<Body> list = Lists.newArrayList();
        MapObjects objects = tiledMap.getLayers().get("collisions").getObjects();

        for (MapObject obj : objects) {
            list.add(PhysicsUtil.createStaticRect(world, obj));
        }

        return list;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

}
