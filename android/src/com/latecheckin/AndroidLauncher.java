package com.latecheckin;

import android.bluetooth.BluetoothClass;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.latecheckin.LateCheckin;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO: Android Location Class.
		DeviceLocation deviceLocation = null;
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;
		TwitterAccount twitterAccount = new TwitterAccount("","","","");
		initialize(new LateCheckin(twitterAccount, deviceLocation), config);
	}
}
