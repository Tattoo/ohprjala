package fi.hy.laskin.main;

import fi.hy.laskin.main.calculator.Calculator_Imple;
import fi.hy.laskin.main.control.Controller_Implementation;
import fi.hy.laskin.main.outputdevice.TextfileWriter;
import fi.hy.laskin.main.sounds.NoSounds;
import fi.hy.laskin.main.sounds.SoundTheme;
import fi.hy.laskin.main.view.View_Implementation_v2;

import java.io.File;

/**
 * Main method for a Calculator
 * 
 * @author ohprjala, Ohjelmistoprosessit ja laatu -kurssin harjoitustyöryhmä
 */
public class Main {

	private static final String	SOUND_DIRECTORY	= "sounds";

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				View view = new View_Implementation_v2();
				Controller controller = new Controller_Implementation();
				Calculator calculator = new Calculator_Imple();

				view.assignController(controller);
				controller.assignView(view);
				controller.assignModel(calculator);

				controller.assignResultOutputDevice(Const.EXPORT_TO_TEXTFILE, new TextfileWriter());

				controller.assignSoundEfectsPlayer(Const.SOUND_EFFECT_THEME__NO_SOUNDS, new NoSounds());

				try {
					SoundTheme clickTheme = new SoundTheme(soundFile("clicks_key.wav"), soundFile("clicks_error.wav"));

					File[] beeps = new File[3];
					beeps[0] = soundFile("beeps_key_1.wav");
					beeps[1] = soundFile("beeps_key_2.wav");
					beeps[2] = soundFile("beeps_key_3.wav");

					SoundTheme beepTheme = new SoundTheme(beeps, new File[] { soundFile("beeps_error.wav") });

					controller.assignSoundEfectsPlayer(Const.SOUND_EFFECT_THEME__CLICKS, clickTheme);
					controller.assignSoundEfectsPlayer(Const.SOUND_EFFECT_THEME__BEEPS, beepTheme);

				} catch (Exception e) {
					e.printStackTrace();
				}

				view.setVisible();
			}

			private File soundFile(String filename) {
				return new File(SOUND_DIRECTORY, filename);
			}

		});
	}

}
