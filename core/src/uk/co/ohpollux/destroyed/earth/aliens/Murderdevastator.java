package uk.co.ohpollux.destroyed.earth.aliens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import uk.co.ohpollux.destroyed.earth.weapons.WeakWeapon;

public class Murderdevastator extends Alien {
    public Murderdevastator() {
	this(null);
    }

    public Murderdevastator(Vector2 position) {
	setTexture(new Texture("murderdevastators.png"));
	setWeapon(new WeakWeapon());
	setDamageMultiplier(1.5f);
	setName("Murderdevastator");

	if (position == null)
	    setPosition(new Vector2(45, (Gdx.graphics.getHeight() / 2) - (getTexture().getHeight() / 2)));
	else
	    setPosition(position);
    }
}
