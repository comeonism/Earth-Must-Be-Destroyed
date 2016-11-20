package uk.co.ohpollux.destroyed.earth;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import uk.co.ohpollux.destroyed.earth.weapons.Bullet;

public class Bullets {
    public static final ArrayList<Bullet> allBullets = new ArrayList<Bullet>();

    public static void addBullet(Bullet bullet) {
	allBullets.add(bullet);
    }

    public static void removeBullet(Bullet bullet) {
	allBullets.remove(bullet);
    }

    public static void updateBullets(Earth earth) {
	Iterator<Bullet> iter = allBullets.iterator();

	while (iter.hasNext()) {
	    Bullet bullet = iter.next();
	    bullet.updatePosition(earth);

	    if (!bullet.exists()) {
		iter.remove();
	    }
	}
    }

    public static void draw(SpriteBatch batch) {
	Iterator<Bullet> iter = allBullets.iterator();

	while (iter.hasNext()) {
	    Bullet bullet = iter.next();
	    batch.draw(bullet.getTexture(), bullet.getPosition().x, bullet.getPosition().y);

	    // TODO: remove
	    // ShapeRenderer srDebugCircle = new ShapeRenderer();
	    // srDebugCircle.begin(ShapeType.Filled);
	    // srDebugCircle.setColor(Color.BLACK);
	    // srDebugCircle.circle(bullet.getBulletCircle().x,
	    // bullet.getBulletCircle().y,
	    // bullet.getBulletCircle().radius);
	    // srDebugCircle.end();
	}
    }
}
