package com.christofferklang.rainbowball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.World;

import static com.christofferklang.rainbowball.ScreenManager.GameScreen.PLAY;

public class RainbowBallApplication extends ApplicationAdapter {

    // Physics world
    private World world;
    private ScreenManager screenManager;

    private int width;
    private int height;

    @Override
    public void create() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        screenManager = new ScreenManager(this);
        screenManager.gotoScreen(PLAY);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        screenManager.update(Gdx.graphics.getDeltaTime());
        screenManager.render();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
