package com.latecheckin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.List;
import twitter4j.TwitterException;

public class LateCheckin extends ApplicationAdapter {
    private Stage stage;
    private Label outputLabel;
    private Button locationButtons[] = new Button[Const.MAX_LOCATIONS];

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
        int i = 0;
        for(Location location : locations){
            if(i > Const.MAX_LOCATIONS - 1){
                break;
            }
            System.out.printf("i = %d, country = %s, fullName = %s%n", i+1, location.getCountry(), location.getFullName());
            final String title = String.format("%s, %s", location.getCountry(), i+1);
            final Button locationButton = new TextButton(title,skin,"small");
            locationButton.setSize(ViewDefine.LocationButton.getWidth(),ViewDefine.LocationButton.getHeight());
            locationButton.setPosition(ViewDefine.LocationButton.getX(), ViewDefine.LocationButton.getY(i));
            locationButton.addListener(new InputListener(){
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    System.out.println(title + " Clicked!");
                    createCheckinButton(skin);
                    for(int j = 0; j < locationButtons.length; j++){
                        locationButtons[j].remove();
                    }
                    return true;
                }
            });
            stage.addActor(locationButton);
            locationButtons[i] = locationButton;
            i++;
        }
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
