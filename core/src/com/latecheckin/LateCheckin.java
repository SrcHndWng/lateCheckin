package com.latecheckin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LateCheckin extends ApplicationAdapter {
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;

    private Stage stage;
    private Label outputLabel;

    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        final int row_height = Gdx.graphics.getWidth() / 12;
        final int col_width = Gdx.graphics.getWidth() / 12;

        final Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Label title = new Label("Late Checkin",mySkin,"big-black");
        title.setSize(Gdx.graphics.getWidth(),row_height*2);
        title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
        title.setAlignment(Align.center);
        stage.addActor(title);

        // Text Button
        createCheckinButton(row_height, col_width, mySkin);

        // Text Button
        final Button button3 = new TextButton("Button3!",mySkin,"small");
        button3.setSize(col_width*4,row_height);
        button3.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*6);
        button3.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Pressed Text Button3!!");
                createCheckinButton(row_height, col_width, mySkin);
                return true;
            }
        });
        stage.addActor(button3);

        outputLabel = new Label("Press a Button",mySkin,"black");
        outputLabel.setSize(Gdx.graphics.getWidth(),row_height);
        outputLabel.setPosition(0,row_height);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);
    }

    private void createCheckinButton(int row_height, int col_width, Skin mySkin){
        final Button checkinBtn = new TextButton("Checkin!",mySkin,"small");
        checkinBtn.setSize(col_width*4,row_height);
        checkinBtn.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        checkinBtn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press to Checkin");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Pressed Checkin Button!!");
                outputLabel.setText("Pressed Checkin Button");
                checkinBtn.remove(); // delete this button!!
                return true;
            }
        });
        stage.addActor(checkinBtn);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        System.out.println("dispose!");
        stage.dispose();
    }
}
