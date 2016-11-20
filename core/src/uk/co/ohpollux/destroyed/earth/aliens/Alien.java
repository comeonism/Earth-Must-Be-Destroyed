package uk.co.ohpollux.destroyed.earth.aliens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import uk.co.ohpollux.destroyed.earth.weapons.WeaponInterface;

public class Alien {
    private String name = "";
    private Vector2 position;
    private Texture texture;
    private WeaponInterface weapon;
    private float damageMultiplier;
    private float speed = 5;

    protected void setPosition(Vector2 position) {
	this.position = position;
    }

    public Vector2 getPosition() {
	return position;
    }

    protected void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    protected void setTexture(Texture texture) {
	this.texture = texture;
    }

    public Texture getTexture() {
	return texture;
    }

    public void moveX(float value) {
	position.x += value;
    }

    public void moveY(float value) {
	position.y += value;
    }

    protected void setWeapon(WeaponInterface weapon) {
	this.weapon = weapon;
    }

    protected void setDamageMultiplier(float value) {
	damageMultiplier = value;
    }

    public float getDamage() {
	return weapon.getWeaponDamage(damageMultiplier);
    }

    public float getSpeed() {
	return speed;
    }
}
