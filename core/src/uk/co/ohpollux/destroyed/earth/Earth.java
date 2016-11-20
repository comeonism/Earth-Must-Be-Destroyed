package uk.co.ohpollux.destroyed.earth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public final class Earth {
    private static Earth instance = null;

    private int hp;
    private Texture normal = new Texture("earthLight.png");
    private Texture hit = new Texture("earthDark.png");
    private static Vector2 location;

    private float offset = 30;

    private Earth() {
	location = new Vector2(getX(), getY());
	hp = 100;
    }

    private float getX() {
	return Gdx.graphics.getWidth() - (normal.getWidth() / 2.5f);
    }

    private float getY() {
	return (Gdx.graphics.getHeight() / 2) - (normal.getHeight() / 2);
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

    public boolean isDead() {
	return hp <= 0;
    }

    public void decreaseHp(float damage) {
	hp -= damage;
    }

    public Texture getEarthTexture() {
	return normal;
    }

    public Texture getEarthHurtTexture() {
	return hit;
    }

}
