package fi.hy.laskin.test;

import fi.hy.laskin.main.SoundEffectsPlayer;
import fi.hy.laskin.main.sounds.NoSounds;

import junit.framework.TestCase;

public class SoundPlayerTests extends TestCase {
	
	SoundEffectsPlayer player;
	
	public void test_play_nosound_theme()  {
		player = new NoSounds();
		player.keyPressed();
		player.error();
	}
	
	public void test_play_clicks_theme() throws Exception  {
//		File f = new File("sounds", "clicks_key.wav");
//		player = new SoundTheme(new URL("file://"+f.getAbsolutePath()), new URL("file://"+f.getAbsolutePath()));
//		player.keyPressed();
//		player.error();
	}
	
//	public void test_play_beeps_theme() throws Exception  {
//		player = new SoundTheme(new URL("beep_key.wav"), new URL("beep_error.wav"));
//		player.keyPressed();
//		player.error();
//	}
	
}
