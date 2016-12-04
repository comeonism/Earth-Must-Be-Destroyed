package uk.co.ohpollux.destroyed.earth.general;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class LargeBar extends Texture {
    private Vector2 position;

    public LargeBar(String path, Vector2 position) {
	super(path);
	this.position = position;
    }

    public Texture getBar() {
	return this;
    }

    public Vector2 getPosition() {
	return position;
    }
}
