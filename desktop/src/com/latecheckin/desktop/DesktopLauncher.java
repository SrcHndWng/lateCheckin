package com.latecheckin.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.latecheckin.Coordinate;
import com.latecheckin.LateCheckin;
import com.latecheckin.Definition;
import com.latecheckin.TwitterAccount;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopGeoLocation geo = new DesktopGeoLocation();

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "LateCheckin";
		config.width = (int)Definition.Viewport.width;
		config.height = (int)Definition.Viewport.height;
		TwitterAccount twitterAccount = new TwitterAccount(
				System.getenv("TWITTER_ACCESS_TOKEN"),
				System.getenv("TWITTER_ACCESS_TOKEN_SECRET"),
				System.getenv("TWITTER_CONSUMER_KEY"),
				System.getenv("TWITTER_CONSUMER_SECRET"));
		new LwjglApplication(new LateCheckin(twitterAccount, geo), config);
	}
}
