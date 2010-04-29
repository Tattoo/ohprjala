package fi.hy.laskin.main.sounds;

import fi.hy.laskin.main.SoundEffectsPlayer;

public class NoSounds implements SoundEffectsPlayer {

	@Override
	public void keyPressed() {
	// System.out.println("nosound key press");
	}

	@Override
	public void error() {
	// System.out.println("nosound error");
	}

}
