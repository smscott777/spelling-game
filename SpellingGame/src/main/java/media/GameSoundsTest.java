/*************************************************************************************************************
  Name: Simone Scott
  
  Driver class to test GameSounds. Extends Application to run the JavaFX media.
**************************************************************************************************************/
package media;

import business.FileProcessor;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Tests the methods of the {@code GameSounds} class.
 * @author Simone Scott
 *
 */
public class GameSoundsTest extends Application {

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	/**
	 * Main entry point for all JavaFX applications.
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		
		GameSounds sounds = new GameSounds();
		
		FileProcessor.newWord();
		//sounds.playWordSound("friend");
		//sounds.playSuccess();
		//sounds.playFailure();
		sounds.playMusic();
		//sounds.playPopSound();	
	}
}
