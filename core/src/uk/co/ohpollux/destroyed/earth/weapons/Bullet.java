package uk.co.ohpollux.destroyed.earth.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import uk.co.ohpollux.destroyed.earth.Earth;

public class Bullet {
    private Vector2 position;
    private Texture image = new Texture("pewpew.png");
    private float speed = 7;
    private float damage = 0;
    private boolean exists = true;

    public Bullet(Vector2 position, float damage) {
	this.position = position;
	this.damage = damage;
    }

    public Vector2 getPosition() {
	return position;
    }

    public void updatePosition(Earth earth) {
	position.x += speed;

	if (earth.isColliding(getBulletCircle())) {
	    earth.decreaseHp(getDamage());
	    exists = false;
	}
    }

    public Texture getTexture() {
	return image;
    }

    private float getDamage() {
	return damage;
    }

    public boolean exists() {
	return exists;
    }

    public Circle getBulletCircle() {
	Rectangle bulletRect = new Rectangle(position.x, position.y, image.getWidth(), image.getHeight());
	return new Circle(new Vector2(calculateBulletX(bulletRect), calculateBulletY(bulletRect)),
		calculateBulletRadius(bulletRect));
    }

    private float calculateBulletRadius(Rectangle rect) {
	return rect.getWidth() / 2;
    }

    private float calculateBulletY(Rectangle rect) {
	return rect.getY() + (rect.getHeight() / 2);
    }

    private float calculateBulletX(Rectangle rect) {
	return rect.getX() + calculateBulletRadius(rect);
    }
}
