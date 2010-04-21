package fi.hy.laskin.main;

import fi.hy.laskin.main.calculator.Calculator_Imple;
import fi.hy.laskin.main.control.Controller_Implementation;
import fi.hy.laskin.main.outputdevice.TextfileWriter;
import fi.hy.laskin.main.sounds.Beeps;
import fi.hy.laskin.main.sounds.Clicks;
import fi.hy.laskin.main.sounds.NoSounds;
import fi.hy.laskin.main.view.View_Implementation;

/**
 * Main method for a Calculator
 * @author ohprjala, Ohjelmistoprosessit ja laatu -kurssin harjoitustyöryhmä 
 */
public class Main {
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
            	View view = new View_Implementation();
            	Controller controller = new Controller_Implementation();
            	Calculator calculator = new Calculator_Imple();
            	
            	view.assignController(controller);
            	
            	controller.assignView(view);
            	controller.assignModel(calculator);
            	controller.assignResultOutputDevice(Const.EXPORT_TO_TEXTFILE, new TextfileWriter());
            	controller.assignSoundEfectsPlayer(Const.SOUND_EFFECT_THEME__NO_SOUNDS, new NoSounds());
            	controller.assignSoundEfectsPlayer(Const.SOUND_EFFECT_THEME__CLICKS, new Clicks());
            	controller.assignSoundEfectsPlayer(Const.SOUND_EFFECT_THEME__BEEPS, new Beeps());
            	view.setVisible();
            	
            }
        });
    }
    
}
