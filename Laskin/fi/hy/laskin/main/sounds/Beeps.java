package fi.hy.laskin.main.sounds;

import fi.hy.laskin.main.SoundEffectsPlayer;

public class Beeps implements SoundEffectsPlayer {

	@Override
	public void keyPressed() {
		System.out.println("beep key press");
	}

	@Override
	public void error() {
		System.out.println("beep error");
	}
	
}
