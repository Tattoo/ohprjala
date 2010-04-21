package fi.hy.laskin.main.sounds;

import fi.hy.laskin.main.SoundEffectsPlayer;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundTheme implements SoundEffectsPlayer {

	private final Clip keyPress;
	private final Clip error;
	
	public SoundTheme(File keyPressSound, File errorSound) throws Exception {
		keyPress = AudioSystem.getClip();
		keyPress.open(AudioSystem.getAudioInputStream(keyPressSound));
		error = AudioSystem.getClip();
		error.open(AudioSystem.getAudioInputStream(errorSound));
	}
	
	@Override
	public void keyPressed() {
		play(keyPress);
	}

	private void play(Clip clip) {
		if (clip.isRunning()) return;
		clip.setFramePosition(0);
		clip.start();
	}
	
	@Override
	public void error() {
		play(error);
	}
	
}
