package uk.co.ohpollux.destroyed.earth.general;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class SmallBar {
    private Texture bar;
    private Vector2 position;

    public SmallBar(String path) {
	bar = new Texture(path);
	this.position = new Vector2();
    }

    public Texture getBar() {
	return bar;
    }

    public Vector2 getPosition() {
	return position;
    }

    public void setPosition(Vector2 position) {
	this.position = position;
    }
}
