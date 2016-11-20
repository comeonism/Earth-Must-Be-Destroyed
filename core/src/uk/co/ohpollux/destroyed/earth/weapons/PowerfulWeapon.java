package uk.co.ohpollux.destroyed.earth.weapons;

public class PowerfulWeapon extends Weapon implements WeaponInterface {
    public PowerfulWeapon() {
	setDamage(10);
	setName("Super Powerful Weapon");
    }

    @Override
    public float getWeaponDamage(float damageMultiplier) {
	return getDamage() * (damageMultiplier * 2);
    }
}
