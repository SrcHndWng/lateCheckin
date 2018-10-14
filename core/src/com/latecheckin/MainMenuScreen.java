package com.latecheckin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {
    private final LateCheckin game;
    private OrthographicCamera camera;

    public MainMenuScreen(final LateCheckin game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Const.Viewport.width, Const.Viewport.height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, ViewDefinition.Welcome.message, ViewDefinition.Welcome.getX(), ViewDefinition.Welcome.getY());
        game.font.draw(game.batch, ViewDefinition.Tap.message, ViewDefinition.Tap.getX(), ViewDefinition.Tap.getY());
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new CheckinScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
