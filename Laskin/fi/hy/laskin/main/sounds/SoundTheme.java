package fi.hy.laskin.main.sounds;

import fi.hy.laskin.main.SoundEffectsPlayer;

import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundTheme implements SoundEffectsPlayer {

	private final Clip keyPress;
	private final Clip error;
	
	public SoundTheme(URL keyPressSoundUrl, URL errorSoundUrl) throws Exception {
		keyPress = AudioSystem.getClip();
		keyPress.open(AudioSystem.getAudioInputStream(keyPressSoundUrl));
		error = AudioSystem.getClip();
		error.open(AudioSystem.getAudioInputStream(errorSoundUrl));
	}
	
	@Override
	public void keyPressed() {
		keyPress.start();
	}

	@Override
	public void error() {
		error.start();
	}
	
}
