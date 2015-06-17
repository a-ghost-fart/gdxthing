package sexy.fedora.gdxthing.util;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.sun.corba.se.impl.io.TypeMismatchException;
import sexy.fedora.gdxthing.conf.Constants;

public class PhysicsUtil {

    public static Body createDynamicBody(final World world, final float width, final float height, final float x, final float y) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x, y);
        Body body = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);
        FixtureDef fDef = new FixtureDef();
        fDef.shape = shape;
        fDef.density = 1f;
        body.createFixture(fDef);
        shape.dispose();
        return body;
    }

    public static Body createStaticRect(World world, MapObject obj) {
        if (!(obj instanceof RectangleMapObject)) {
            throw new IllegalArgumentException("Object is not of type RectangleMapObject");
        }
        Shape shape = getRectangle((RectangleMapObject) obj);
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(def);
        body.createFixture(shape, 1);
        return body;
    }

    private static PolygonShape getRectangle(RectangleMapObject rmo) {
        float ppt = 32f;
        Rectangle rect = rmo.getRectangle();
        PolygonShape shape = new PolygonShape();
        Vector2 size = new Vector2((rect.x + rect.width) / ppt,
                (rect.y + rect.height) / ppt);
        shape.setAsBox(rect.width / ppt, rect.height / ppt, size, 0f);
        return shape;
    }


}
