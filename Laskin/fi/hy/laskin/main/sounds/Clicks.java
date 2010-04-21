package fi.hy.laskin.main.sounds;

import fi.hy.laskin.main.SoundEffectsPlayer;

public class Clicks implements SoundEffectsPlayer {

	@Override
	public void keyPressed() {
		System.out.println("click key");
	}

	@Override
	public void error() {
		System.out.println("click error");
	}
	
}
