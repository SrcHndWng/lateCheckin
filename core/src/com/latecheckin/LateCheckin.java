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

import java.util.Collections;
import java.util.List;
import twitter4j.TwitterException;

public class LateCheckin extends ApplicationAdapter {
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;

    private Stage stage;
    private Label outputLabel;

    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        final Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Label title = new Label(ViewDefine.Title.message,skin,"big-black");
        title.setSize(ViewDefine.Title.getWidth(),ViewDefine.Title.getHeight());
        title.setPosition(ViewDefine.Title.getX(),ViewDefine.Title.getY());
        title.setAlignment(Align.center);
        stage.addActor(title);

        // Text Button
        createCheckinButton(skin);

        // TODO: remove
        // Text Button
//        createButton3(skin);

        outputLabel = new Label("Press a Button",skin,"black");
        outputLabel.setSize(Gdx.graphics.getWidth(),ViewDefine.rowHeight);
        outputLabel.setPosition(0, ViewDefine.rowHeight);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);
    }

    private void createCheckinButton(final Skin skin){
        final Button checkinBtn = new TextButton(ViewDefine.CheckinButton.message,skin,"small");
        checkinBtn.setSize(ViewDefine.CheckinButton.getWidth(),ViewDefine.CheckinButton.getHeight());
        checkinBtn.setPosition(ViewDefine.CheckinButton.getX(),ViewDefine.CheckinButton.getY());
        checkinBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Pressed Checkin Button");
                try {
                    Coordinate current = Coordinate.create(35.690921,139.700258);
                    List<Location> locations = new Checkin().getPlaces(current);
                    createLocationButtons(locations, skin);
                } catch (TwitterException e) {
                    // TODO: error handling
                    e.printStackTrace();
                }
                outputLabel.setText("Pressed Checkin Button");
                checkinBtn.remove(); // delete this button!!
                return true;
            }
        });
        stage.addActor(checkinBtn);
    }

    private void createLocationButtons(List<Location> locations, final Skin skin){
        int i = 1;
        for(Location location : locations){
            if(i > Const.MAX_LOCATIONS){
                break;
            }
            System.out.printf("i = %d, country = %s, fullName = %s%n", i, location.getCountry(), location.getFullName());
            final String title = String.format("%s, %s", location.getCountry(), i);
            final Button button = new TextButton(title,skin,"small");
            button.setSize(ViewDefine.LocationButton.getWidth(),ViewDefine.LocationButton.getHeight());
            button.setPosition(ViewDefine.LocationButton.getX(), ViewDefine.LocationButton.getY(i));
            button.addListener(new InputListener(){
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println(title + " Clicked!");
                    createCheckinButton(skin);
                    return true;
                }
            });
            stage.addActor(button);

            i++;
        }
    }

    private void createButton3(final Skin skin){
        final Button button3 = new TextButton("Button3!",skin,"small");
        button3.setSize(ViewDefine.colWidth*4,ViewDefine.rowHeight);
        button3.setPosition(ViewDefine.CheckinButton.getX(),ViewDefine.rowHeight*4);
        button3.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Pressed Text Button3!!");
                createCheckinButton(skin);
                return true;
            }
        });
        stage.addActor(button3);
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
