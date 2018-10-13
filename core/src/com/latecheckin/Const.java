package com.latecheckin;

public class Const {
    private Const(){
    }

    public static class Viewport{
        public static final float width = 640.0f;
        public static final float height = 1136.0f;
    }

    public static class Bucket{
        public static final float width = 64.0f;
        public static final float height = 64.0f;
        public static final float aboveBottom = 20.0f;
        public static final float slideWidth = 200.0f;
    }

    public static class Raindrop{
        public static final float width = 64.0f;
        public static final float height = 64.0f;
        public static final float slideHeight = 200.0f;
    }

    public static class DispStrings {
        public static class Welcome{
            public static String message = "Welcome to LateCheckin!!!";
            public static float getX(){
                return Const.Viewport.width / 2 - 100;
            }
            public static float getY(){
                return Const.Viewport.height / 2 - 50;
            }
        }
        public static class Tap{
            public static String message = "Tap anywhere to begin!";
            public static float getX(){
                return Const.Viewport.width / 2 - 100;
            }
            public  static float getY(){
                return Const.Viewport.height / 2;
            }
        }
        public static class DropCount{
            public static float x = 0.0f;
            public static float y = 480.0f;
            public static String title = "Drops Collected: ";
        }
    }
}
