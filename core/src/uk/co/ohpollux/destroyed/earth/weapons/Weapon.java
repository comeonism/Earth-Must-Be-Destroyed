package uk.co.ohpollux.destroyed.earth.weapons;

public class Weapon {
    protected float damage;
    protected String name;

    protected void setDamage(float damage) {
	this.damage = damage;
    }

    public float getDamage() {
	return damage;
    }

    protected void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
