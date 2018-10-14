package com.latecheckin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;

public class CheckinScreen implements Screen{
    private final LateCheckin game;
    private OrthographicCamera camera;


    public CheckinScreen(final LateCheckin game) {
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
        game.font.draw(game.batch, "Checkin Place 1.", ViewDefinition.Welcome.getX(), Const.Viewport.height - 500);
        game.font.draw(game.batch, "Checkin Place 2.", ViewDefinition.Welcome.getX(), Const.Viewport.height - 450);
        game.font.draw(game.batch, "Checkin Place 3.", ViewDefinition.Welcome.getX(), Const.Viewport.height - 400);
        game.batch.end();

        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            System.out.println("Checkin Touched! x = " + Gdx.input.getX() + ", y = " + Gdx.input.getY());
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
