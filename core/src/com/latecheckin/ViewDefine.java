package com.latecheckin;

import com.badlogic.gdx.Gdx;

public class ViewDefine {
    public final static int rowHeight = Gdx.graphics.getWidth() / 12;
    public final static int colWidth = Gdx.graphics.getWidth() / 12;

    private ViewDefine(){
    }

    public static class Title {
        public static String message = "Late Checkin";
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
        public static String message = "Checkin!";
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
