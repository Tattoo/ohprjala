package fi.hy.laskin.test;

import fi.hy.laskin.main.SoundEffectsPlayer;
import fi.hy.laskin.main.sounds.NoSounds;
import fi.hy.laskin.main.sounds.SoundTheme;

import java.io.File;

import junit.framework.TestCase;

public class SoundPlayerTests extends TestCase {

	private static final String	SOUND_DIRECTORY	= "sounds";

	SoundEffectsPlayer player;

	public void test_play_nosound_theme()  {
		player = new NoSounds();
		player.keyPressed();
		player.error();
	}

	public void test_play_clicks_theme() throws Exception  {
		player = new SoundTheme(soundFile("clicks_key.wav"), soundFile("clicks_error.wav"));
		player.keyPressed();
		player.error();
	}
	
	public void test_play_beeps_theme() throws Exception  {
		File[] beeps = new File[3];
		beeps[0] = soundFile("beeps_key_1.wav");
		beeps[1] = soundFile("beeps_key_2.wav");
		beeps[2] = soundFile("beeps_key_3.wav");

		player = new SoundTheme(beeps, new File[] {soundFile("beeps_error.wav")} );
		player.keyPressed();
		player.keyPressed();
		player.keyPressed();
		player.keyPressed();
		player.error();
		player.keyPressed();
		player.keyPressed();
	}
	
	private File soundFile(String filename) {
		return new File(SOUND_DIRECTORY, filename);
	}

}
