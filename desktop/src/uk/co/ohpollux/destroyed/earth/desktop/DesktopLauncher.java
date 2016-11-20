package uk.co.ohpollux.destroyed.earth.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import uk.co.ohpollux.destroyed.earth.EarthDestroyed;

public class DesktopLauncher {
    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	config.width = 1200;
	config.height = 860;
	config.title = "Earth Must Be Destroyed";
	new LwjglApplication(new EarthDestroyed(), config);
    }
}
