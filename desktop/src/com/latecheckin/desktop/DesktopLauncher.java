package com.latecheckin.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.latecheckin.Const;
import com.latecheckin.LateCheckin;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "LateCheckin";
		config.width = (int)Const.Viewport.width;
		config.height = (int)Const.Viewport.height;
		new LwjglApplication(new LateCheckin(), config);
	}
}
