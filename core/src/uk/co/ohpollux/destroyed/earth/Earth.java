package uk.co.ohpollux.destroyed.earth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import uk.co.ohpollux.destroyed.earth.general.Damageable;
import uk.co.ohpollux.destroyed.earth.general.LargeBar;

public final class Earth extends Damageable {
    private static Earth instance = null;
    private static Vector2 location;

    private static final Vector2 barLocation = new Vector2(50, Gdx.graphics.getHeight() - 50);
    private static final Texture normal = new Texture("earth/earthLight.png");
    private static final Texture destroyed = new Texture("earth/earthDark.png");

    private static final float offset = 30;

    private Earth() {
	super();
	location = new Vector2(getX(), getY());
    }

    private float getX() {
	return Gdx.graphics.getWidth() - (normal.getWidth() / 2.5f);
    }

    private float getY() {
	return (Gdx.graphics.getHeight() / 2) - (normal.getHeight() / 2);
    }

    public boolean isColliding(Circle bulletCircle) {
	boolean collides = false;
	Circle earthCircle = new Circle(
		new Vector2(location.x + (normal.getHeight() / 2) + offset, getY() + getEarthTexture().getHeight() / 2),
		normal.getWidth() / 2);

	if (earthCircle.overlaps(bulletCircle)) {
	    collides = true;
	}

	return collides;
    }

    public Texture getEarthTexture() {
	if (getHp() > 0)
	    return normal;
	else
	    return destroyed;
    }

    public static Earth getInstance() {
	if (instance == null) {
	    instance = new Earth();
	}

	return instance;
    }

    public Vector2 getPosition() {
	return location;
    }

    public Vector2 getBarLocation() {
	return barLocation;
    }

    @Override
    protected Texture getRedHpBar() {
	return new LargeBar("earth/healthBarRed.png", barLocation);
    }

    @Override
    protected Texture getOrangeHpBar() {
	return new LargeBar("earth/healthBarOrange.png", barLocation);
    }

    @Override
    protected Texture getGreenHpBar() {
	return new LargeBar("earth/healthBarGreen.png", barLocation);
    }

}
