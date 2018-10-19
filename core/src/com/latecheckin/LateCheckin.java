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
    private Button locationButtons[] = new Button[Definition.maxLocations];

    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        final Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Label title = new Label(Definition.Title.text,skin,"big-black");
        title.setSize(Definition.Title.getWidth(),Definition.Title.getHeight());
        title.setPosition(Definition.Title.getX(),Definition.Title.getY());
        title.setAlignment(Align.center);
        stage.addActor(title);

        // Text Button
        createCheckinButton(skin);

        outputLabel = new Label("",skin,"black");
        outputLabel.setSize(Gdx.graphics.getWidth(),Definition.rowHeight);
        outputLabel.setPosition(0, Definition.rowHeight);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);
    }

    private void createCheckinButton(final Skin skin){
        final Button checkinBtn = new TextButton(Definition.CheckinButton.text,skin,"small");
        checkinBtn.setSize(Definition.CheckinButton.getWidth(),Definition.CheckinButton.getHeight());
        checkinBtn.setPosition(Definition.CheckinButton.getX(),Definition.CheckinButton.getY());
        checkinBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println(Definition.CheckinButton.message);
                try {
                    Coordinate current = Coordinate.create(35.690921,139.700258);
                    List<Location> locations = new Checkin().getPlaces(current);
                    createLocationButtons(locations, skin);
                    outputLabel.setText(Definition.CheckinButton.message);
                    checkinBtn.remove();
                    return true;
                } catch (TwitterException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });
        stage.addActor(checkinBtn);
    }

    private void createLocationButtons(List<Location> locations, final Skin skin){
        int i = 0;
        for(final Location location : locations){
            if(i > Definition.maxLocations - 1){
                break;
            }
            final String country = Utils.transferToRomaji(location.getCountry());
            final String fullName = Utils.transferToRomaji(location.getFullName());
            System.out.printf("i = %d, country = %s, fullName = %s%n", i+1, country, fullName);
            final String title = Definition.LocationButton.getText(country, fullName);
            final Button locationButton = new TextButton(title,skin,"small");
            locationButton.setSize(Definition.LocationButton.getWidth(),Definition.LocationButton.getHeight());
            locationButton.setPosition(Definition.LocationButton.getX(), Definition.LocationButton.getY(i));
            locationButton.addListener(new InputListener(){
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    final String message = Definition.LocationButton.getMessage(title);
                    System.out.println(message);
                    outputLabel.setText(message);
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
