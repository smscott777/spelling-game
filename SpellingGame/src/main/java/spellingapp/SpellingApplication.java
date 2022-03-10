/*************************************************************************************************************
  Name: Simone Scott
  
  Driver class to run the SpellingApplication GUI learning game. Calls the main method, which
  calls the launch method of the JavaFX Application class. Calls the start method to launch the GUI.
  
  Upon launching the game, the user must enter their name to play. Once the play button is pressed, the sound
  of a word will be played. This sound can be repeated by clicking the audio icon button. If a user spells the 
  word correctly, either by typing on their keyboard or clicking the GUI letter buttons, they will earn points. 
  The game round ends when the user clicks the Quit button. The score will be added to the high scores file if
  it is a top 5 high score, and a congratulatory message will be displayed. The application can be closed by clicking
  the Exit button on the home screen, or by closing the window.
**************************************************************************************************************/
package spellingapp;

import javafx.application.Application;
import javafx.stage.Stage;

import gui.SpellingGUI;


/**
 * JavaFX App
 */

public class SpellingApplication extends Application {
	
	SpellingGUI spellingApp = new SpellingGUI();

    @Override
    public void start(Stage stage) throws Exception { 	
    	spellingApp.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}