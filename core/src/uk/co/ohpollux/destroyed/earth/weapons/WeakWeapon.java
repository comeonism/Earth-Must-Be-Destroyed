package uk.co.ohpollux.destroyed.earth.weapons;

public class WeakWeapon extends Weapon implements WeaponInterface {
    public WeakWeapon() {
	setDamage(5);
	setName("Super Weak Weapon");
    }

    @Override
    public float getWeaponDamage(float damageMultiplier) {
	return getDamage() * damageMultiplier;
    }
}
