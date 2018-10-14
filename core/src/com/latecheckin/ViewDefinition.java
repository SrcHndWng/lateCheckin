package com.latecheckin;

public class ViewDefinition {
    private ViewDefinition(){
    }

    public static class Welcome{
        public static String message = "Welcome to LateCheckin!!!";
        public static float getX(){
            return Const.Viewport.width / 2 - 100;
        }
        public static float getY(){
            return Const.Viewport.height / 2;
        }
    }

    public static class Tap{
        public static String message = "Tap anywhere to checkin!";
        public static float getX(){
            return Const.Viewport.width / 2 - 100;
        }
        public  static float getY(){
            return Const.Viewport.height / 2 - 50;
        }
    }
}
