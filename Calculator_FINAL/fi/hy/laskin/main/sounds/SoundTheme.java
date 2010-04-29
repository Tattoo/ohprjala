package fi.hy.laskin.main.sounds;

import fi.hy.laskin.main.SoundEffectsPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundTheme implements SoundEffectsPlayer {

	private final List<Clip>	keyPresses;
	private final List<Clip>	errors;
	private int					key_index	= 0;
	private int					error_index	= 0;

	public SoundTheme(File keyPressSound, File errorSound) throws Exception {
		this(new File[] { keyPressSound }, new File[] { errorSound });
	}

	public SoundTheme(File[] keyPressSouns, File[] errorSounds) throws Exception {
		this.keyPresses = new ArrayList<Clip>();
		this.errors = new ArrayList<Clip>();
		for (File f : keyPressSouns) {
			Clip clip = openClip(f);
			keyPresses.add(clip);
		}
		for (File f : errorSounds) {
			Clip clip = openClip(f);
			errors.add(clip);
		}
	}

	private Clip openClip(File f) throws Exception {
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(f));
		return clip;
	}

	@Override
	public void keyPressed() {
		playOne(keyPresses);
	}

	private void playOne(List<Clip> clips) {
		Clip clip = getNextClip(clips);
		if (clip.isRunning()) return;
		clip.setFramePosition(0);
		clip.start();
	}

	private Clip getNextClip(List<Clip> clips) {
		// int i = new Random().nextInt(clips.size());
		int i = -1;
		if (clips == keyPresses) {
			key_index++;
			if (key_index >= keyPresses.size()) key_index = 0;
			i = key_index;
		} else {
			error_index++;
			if (error_index >= errors.size()) error_index = 0;
			i = error_index;
		}
		return clips.get(i);
	}

	@Override
	public void error() {
		playOne(errors);
	}

}
