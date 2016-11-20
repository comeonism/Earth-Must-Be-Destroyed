package uk.co.ohpollux.destroyed.earth;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import uk.co.ohpollux.destroyed.earth.aliens.Alien;
import uk.co.ohpollux.destroyed.earth.aliens.Cucumberian;
import uk.co.ohpollux.destroyed.earth.aliens.Murderdevastator;
import uk.co.ohpollux.destroyed.earth.weapons.Bullet;

public class EarthDestroyed extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Earth earth;
    private Alien alien;

    private boolean aPressed = false;
    private boolean spacePressed = false;

    @Override
    public void create() {
	batch = new SpriteBatch();
	background = new Texture("background.png");
	earth = Earth.getInstance();
	alien = new Cucumberian();
    }

    @Override
    public void render() {
	update();

	Gdx.gl.glClearColor(1, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	batch.begin();
	batch.draw(background, 0, 0);
	batch.draw(earth.getEarthTexture(), earth.getPosition().x, earth.getPosition().y);
	batch.draw(alien.getTexture(), alien.getPosition().x, alien.getPosition().y);

	Bullets.draw(batch);
	batch.end();

    }

    private void update() {
	listenToKeys();
	Bullets.updateBullets(earth);
    }

    private void listenToKeys() {
	processMovementKeys();
	processAlienChangingKeys();
	processFireKeys();
	processExitKeys();
    }

    private void processExitKeys() {
	if (Gdx.input.isKeyPressed(Keys.ESCAPE))
	    Gdx.app.exit();
    }

    private void processFireKeys() {
	if (Gdx.input.isKeyPressed(Keys.SPACE)) {
	    spacePressed = true;
	}

	if (spacePressed && !Gdx.input.isKeyPressed(Keys.SPACE)) {
	    spacePressed = false;
	    Bullets.addBullet(new Bullet(new Vector2(calculateBulletX(), calculateBulletY()), alien.getDamage()));
	}
    }

    private void processAlienChangingKeys() {
	if (Gdx.input.isKeyPressed(Keys.A)) {
	    aPressed = true;
	}

	if (aPressed && !Gdx.input.isKeyPressed(Keys.A)) {
	    aPressed = false;

	    if (alien.getName().equals("Murderdevastator"))
		alien = new Cucumberian(alien.getPosition());
	    else
		alien = new Murderdevastator(alien.getPosition());
	}
    }

    private void processMovementKeys() {
	if (Gdx.input.isKeyPressed(Keys.LEFT) && alien.getPosition().x > 0)
	    alien.moveX(-alien.getSpeed());
	if (Gdx.input.isKeyPressed(Keys.RIGHT)
		&& alien.getPosition().x < earth.getPosition().x - alien.getTexture().getWidth())
	    alien.moveX(alien.getSpeed());
	if (Gdx.input.isKeyPressed(Keys.UP)
		&& alien.getPosition().y < Gdx.graphics.getHeight() - alien.getTexture().getHeight())
	    alien.moveY(alien.getSpeed());
	if (Gdx.input.isKeyPressed(Keys.DOWN) && alien.getPosition().y > 0)
	    alien.moveY(-alien.getSpeed());
    }

    private float calculateBulletY() {
	return alien.getPosition().y;
    }

    private float calculateBulletX() {
	return alien.getPosition().x + alien.getTexture().getWidth();
    }

    @Override
    public void dispose() {
	batch.dispose();
	background.dispose();
    }
}
