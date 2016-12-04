package uk.co.ohpollux.destroyed.earth.general;

import com.badlogic.gdx.graphics.Texture;

public abstract class Damageable {
    private int hp;
    private final int maxHp = 100;
    private final Texture red;
    private final Texture green;
    private final Texture orange;

    public Damageable() {
	hp = maxHp;
	red = getRedHpBar();
	green = getGreenHpBar();
	orange = getOrangeHpBar();
    }

    protected void resetHp() {
	hp = maxHp;
    }

    protected int getHp() {
	return hp;
    }

    public void decreaseHp(float value) {
	hp -= value;
    }

    protected boolean isDead() {
	return hp <= 0;
    }

    protected Texture getBar() {
	if (hp >= 60)
	    return green;
	else if (hp > 40 && hp < 60)
	    return orange;
	else
	    return red;
    }

    abstract protected Texture getRedHpBar();

    abstract protected Texture getOrangeHpBar();

    abstract protected Texture getGreenHpBar();
}
