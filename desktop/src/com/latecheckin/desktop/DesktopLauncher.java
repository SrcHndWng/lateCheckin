package com.latecheckin.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.latecheckin.LateCheckin;
import com.latecheckin.Definition;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "LateCheckin";
		config.width = (int)Definition.Viewport.width;
		config.height = (int)Definition.Viewport.height;
		new LwjglApplication(new LateCheckin(), config);
	}
}
