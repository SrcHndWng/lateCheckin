package com.latecheckin;

import com.badlogic.gdx.Gdx;

public class Definition {
    public final static int maxLocations = 10;
    public final static int rowHeight = Gdx.graphics.getWidth() / 12;
    public final static int colWidth = Gdx.graphics.getWidth() / 12;

    private Definition(){
    }

    public static class Viewport{
        public static final float width = 640.0f;
        public static final float height = 1136.0f;
    }

    public static class Title {
        public static String text = "Late Checkin";
        public static float getWidth(){
            return Gdx.graphics.getWidth();
        }
        public static float getHeight(){
            return rowHeight*2;
        }
        public static float getX(){
            return 0;
        }
        public static float getY(){
            return Gdx.graphics.getHeight()-rowHeight*2;
        }
    }

    public static class CheckinButton{
        public static String text = "Checkin!";
        public static String message = "Pressed Checkin Button.";
        public static float getWidth(){
            return colWidth*4;
        }
        public static float getHeight(){
            return rowHeight;
        }
        public static float getX(){
            return colWidth*4;
        }
        public static float getY(){
            return rowHeight*8;
        }
    }

    public static class LocationButton{
        public static String getText(String country, int i){
            return String.format("%s, %s", country, i+1);
        }
        public static String getMessage(String text){
            return text + " Clicked!";
        }
        public static float getWidth(){
            return colWidth*4;
        }
        public static float getHeight(){
            return rowHeight;
        }
        public static float getX(){
            return colWidth*4;
        }
        public static float getY(int i){
            return (rowHeight * 3) + rowHeight*(10-i);
        }
    }
}
