package uk.co.ohpollux.destroyed.earth.aliens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import uk.co.ohpollux.destroyed.earth.weapons.PowerfulWeapon;

public class Cucumberian extends Alien {
    public Cucumberian() {
	this(null);
    }

    public Cucumberian(Vector2 position) {
	setTexture(new Texture("cucumberians.png"));
	setWeapon(new PowerfulWeapon());
	setDamageMultiplier(1);
	setName("Cucumberian");

	if (position == null)
	    setPosition(new Vector2(45, (Gdx.graphics.getHeight() / 2) - (getTexture().getHeight() / 2)));
	else
	    setPosition(position);
    }
}
