/*************************************************************************************************************
  Name: Simone Scott
  
  Operation class to run the JavaFX GUI of the SpellingApplication learning game. Defines the GUI
  scene layout, controls, and all visuals. Has a start method to set the stage with these elements. Contains 
  EventHandler inner classes to handle all ActionEvents and KeyEvents. See SpellingApplication for function of
  the spelling game.
**************************************************************************************************************/
package gui;

//Imports all required libraries.
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import business.FileProcessor;
import business.SpellingChecker;
import media.GameSounds;
import media.ImageProcessor;

/**
 * Defines the GUI scene layout, controls, and all visuals. 
 * Has a start method to set the stage with these elements. 
 * Contains EventHandler inner classes to handle all action and key events. 
 * See SpellingApplication for function of spelling game.
 * @author Simone Scott
 *
 */
public class SpellingGUI extends Application {

	private Stage stage;
	private Scene playScene;
	private Scene homeScene;
	private StackPane playPane;
	private StackPane homePane;
	private VBox homeVBox;
	private FlowPane letterPane;
	private FlowPane homeButtons;
	private VBox playVBox;
	private HBox extraButtons;
	private Text scoreText;
	private Text welcome;
	private Text welcomeP;
	private Text headingText;
	private Text highScores;
	private Text congrats;
	private Text spellText;
	private TextInputControl name;
	private Label nameLabel;
	private String spellString;
	private final String TITLE = "\"Hear it? Spell it!\" Learning Application";
	private ImageView soundImageView;
	private Button aButton,
				bButton,
				cButton,
				dButton,
				eButton,
				fButton,
				gButton,
				hButton,
				iButton,
				jButton,
				kButton,
				lButton,
				mButton,
				nButton,	 
				oButton,
				pButton,
				qButton,
				rButton,
				sButton,
				tButton,
				uButton,
				vButton,
				wButton,
				xButton,
				yButton,
				zButton,
				spaceButton,
				soundButton,
				nextButton,
				exitButton,
				enterButton,
				playButton,
				scoreButton,
				quitButton;
	private int posScoreCounter = 0;
	private int negScoreCounter = 0;
	
	private HashMap<Button, Character> buttonList = new HashMap<Button, Character>();
	private StringBuilder spellSb = new StringBuilder();
	private SpellingChecker spellChecker = new SpellingChecker();
	private GameSounds audio = new GameSounds();
	private ImageProcessor photos = new ImageProcessor();
	
	public static void main(String[] args) {
        launch();
    }
		
	/**
	 * Start method to execute the javafx GUI application.
	 * Initializes all controls, layouts, and images of 
	 * the scenes. Plays the game music upon launch.
	 * @param stage
	 */
	@Override
	public void start(Stage stage) throws Exception {	
		this.stage = stage;
		
		audio.playMusic();
		FileProcessor.calcHighScores();
		
		/**
		 * Text, TextAreas and labels.
		 */
		scoreText = new Text("Score: Correct " + posScoreCounter + " Wrong " + negScoreCounter);
		headingText = new Text("Listen for the word. Then spell it!");
		welcome = new Text("Welcome to \"HEAR IT? SPELL IT!\"");
		welcomeP = new Text("HEAR IT? SPELL IT!");
		highScores = new Text("High Scores:\n"
							+ FileProcessor.getHighScores());
		highScores.setVisible(false);
		congrats = new Text();
		spellText = new Text();
		nameLabel = new Label("Enter name:");
		name = new TextArea();
		name.setMaxSize(125, 1);
		name.setOpacity(0.8);
			
		/**
		 * Letter ImageViews and images.
		 */
		ImageView imageViewA = new ImageView(new Image(photos.getImage("a")));
		ImageView imageViewB = new ImageView(new Image(photos.getImage("b")));
		ImageView imageViewC = new ImageView(new Image(photos.getImage("c")));
		ImageView imageViewD = new ImageView(new Image(photos.getImage("d")));
		ImageView imageViewE = new ImageView(new Image(photos.getImage("e")));
		ImageView imageViewF = new ImageView(new Image(photos.getImage("f")));
		ImageView imageViewG = new ImageView(new Image(photos.getImage("g")));
		ImageView imageViewH = new ImageView(new Image(photos.getImage("h")));
		ImageView imageViewI = new ImageView(new Image(photos.getImage("i")));
		ImageView imageViewJ = new ImageView(new Image(photos.getImage("j")));
		ImageView imageViewK = new ImageView(new Image(photos.getImage("k")));
		ImageView imageViewL = new ImageView(new Image(photos.getImage("l")));
		ImageView imageViewM = new ImageView(new Image(photos.getImage("m")));
		ImageView imageViewN = new ImageView(new Image(photos.getImage("n")));
		ImageView imageViewO = new ImageView(new Image(photos.getImage("o")));
		ImageView imageViewP = new ImageView(new Image(photos.getImage("p")));
		ImageView imageViewQ = new ImageView(new Image(photos.getImage("q")));
		ImageView imageViewR = new ImageView(new Image(photos.getImage("r")));
		ImageView imageViewS = new ImageView(new Image(photos.getImage("s")));
		ImageView imageViewT = new ImageView(new Image(photos.getImage("t")));
		ImageView imageViewU = new ImageView(new Image(photos.getImage("u")));
		ImageView imageViewV = new ImageView(new Image(photos.getImage("v")));
		ImageView imageViewW = new ImageView(new Image(photos.getImage("w")));
		ImageView imageViewX = new ImageView(new Image(photos.getImage("x")));
		ImageView imageViewY = new ImageView(new Image(photos.getImage("y")));
		ImageView imageViewZ = new ImageView(new Image(photos.getImage("z")));
		soundImageView = new ImageView(new Image(photos.getImage("replay")));
		
		ImageView[] letterImageViews = {
			imageViewA,
			imageViewB,
			imageViewC,
			imageViewD,
			imageViewE,
			imageViewF,
			imageViewG,
			imageViewH,
			imageViewI,
			imageViewJ,
			imageViewK,
			imageViewL,
			imageViewM,
			imageViewN,
			imageViewO,
			imageViewP,
			imageViewQ,
			imageViewR,
			imageViewS,
			imageViewT,
			imageViewU,
			imageViewV,
			imageViewW,
			imageViewX,
			imageViewY,
			imageViewZ,
		};
		
		/**
		 * Sizes ImageViews.
		 */
		for(ImageView img : letterImageViews) {
			img.setFitHeight(70);
			img.setFitWidth(70);
		}
		soundImageView.setFitHeight(20);
		soundImageView.setFitWidth(20);
		
		/**
		 * Instantiates non-letter buttons and set event handlers.
		 */
		soundButton = new Button(null, soundImageView);
		enterButton = new Button("Enter");
		quitButton = new Button("Quit");
		nextButton = new Button("Next Word");
		playButton = new Button("Play");
		scoreButton = new Button("View High Scores");
		exitButton = new Button("Exit");
		
		soundButton.setOnAction(new SoundButtonHandler());
		enterButton.setOnAction(new EnterButtonHandler());
		quitButton.setOnAction(new QuitButtonHandler());
		nextButton.setOnAction(new NextButtonHandler());
		playButton.setOnAction(new PlayButtonHandler());		
		scoreButton.setOnAction(new ScoreButtonHandler());
		exitButton.setOnAction(new ExitButtonHandler());
		
		/**
		 * Puts the letter image on the corresponding button.
		 */
		aButton = new Button(null, imageViewA);
		bButton = new Button(null, imageViewB);
		cButton = new Button(null, imageViewC);
		dButton = new Button(null, imageViewD);
		eButton = new Button(null, imageViewE);
		fButton = new Button(null, imageViewF);
		gButton = new Button(null, imageViewG);
		hButton = new Button(null, imageViewH);
		iButton = new Button(null, imageViewI);
		jButton = new Button(null, imageViewJ);
		kButton = new Button(null, imageViewK);
		lButton = new Button(null, imageViewL);
		mButton = new Button(null, imageViewM);
		nButton = new Button(null, imageViewN);
		oButton = new Button(null, imageViewO);
		pButton = new Button(null, imageViewP);
		qButton = new Button(null, imageViewQ);
		rButton = new Button(null, imageViewR);
		sButton = new Button(null, imageViewS);
		tButton = new Button(null, imageViewT);
		uButton = new Button(null, imageViewU);
		vButton = new Button(null, imageViewV);
		wButton = new Button(null, imageViewW);
		xButton = new Button(null, imageViewX);
		yButton = new Button(null, imageViewY);
		zButton = new Button(null, imageViewZ);
		
		/**
		 * Invisible button to refocus onto after each
		 * button click. Prevents the previous letter being
		 * typed when enter key is clicked.
		 */
		spaceButton = new Button();
		spaceButton.setOpacity(0);

		buttonList.put(aButton, 'A');
		buttonList.put(bButton, 'B');
		buttonList.put(cButton, 'C');
		buttonList.put(dButton, 'D');
		buttonList.put(eButton, 'E');
		buttonList.put(fButton, 'F');
		buttonList.put(gButton, 'G');
		buttonList.put(hButton, 'H');
		buttonList.put(iButton, 'I');
		buttonList.put(jButton, 'J');
		buttonList.put(kButton, 'K');
		buttonList.put(lButton, 'L');
		buttonList.put(mButton, 'M');
		buttonList.put(nButton, 'N');
		buttonList.put(oButton, 'O');
		buttonList.put(pButton, 'P');
		buttonList.put(qButton, 'Q');
		buttonList.put(rButton, 'R');
		buttonList.put(sButton, 'S');
		buttonList.put(tButton, 'T');
		buttonList.put(uButton, 'U');
		buttonList.put(vButton, 'V');
		buttonList.put(wButton, 'W');
		buttonList.put(xButton, 'X');
		buttonList.put(yButton, 'Y');
		buttonList.put(zButton, 'Z');
		buttonList.put(spaceButton, ' ');
		
		/**
		 * Creates Event handlers for letter and space buttons.
		 */
		for(Map.Entry<Button, Character> entry : buttonList.entrySet()) {
			Button button = entry.getKey();
			button.setOnAction(new LetterButtonHandler());
			button.setOnKeyPressed(new KeyHandler());
		}

		
		letterPane = new FlowPane(
			aButton,
			bButton,
			cButton,
			dButton,
			eButton,
			fButton,
			gButton,
			hButton,
			iButton,
			jButton,
			kButton,
			lButton,
			mButton,
			nButton,	 
			oButton,
			pButton,
			qButton,
			rButton,
			sButton,
			tButton,
			uButton,
			vButton,
			wButton,
			xButton,
			yButton,
			zButton,
			spaceButton
		);
		
		extraButtons = new HBox(soundButton, enterButton, nextButton, quitButton);
		playVBox = new VBox(10, welcomeP, scoreText, spellText, extraButtons, letterPane, headingText);

		
		Image backgroundImage = new Image(photos.getGif("squares-background"));
		ImageView homeBackground = new ImageView(backgroundImage);
		ImageView playBackground = new ImageView(backgroundImage);
		
			
		playPane = new StackPane(playBackground, playVBox);
		playScene = new Scene(playPane, 1000, 750);
		
		homeBackground.setFitHeight(playScene.getHeight());
		homeBackground.setFitWidth(playScene.getWidth());
		playBackground.setFitHeight(playScene.getHeight());
		playBackground.setFitWidth(playScene.getWidth());
	
						
		homeButtons = new FlowPane(playButton, exitButton, scoreButton);
		homeVBox = new VBox(welcome, congrats, highScores, homeButtons, nameLabel, name);
		homePane = new StackPane(homeBackground, homeVBox);
		homeScene = new Scene(homePane, 1000, 750);
		
		/**
		 * Applies the CSS style.
		 */
		generateCSS();

		/**
		 * Sets all specified alignments.
		 */
		extraButtons.setAlignment(Pos.CENTER);
		letterPane.setAlignment(Pos.BOTTOM_CENTER);
		playVBox.setAlignment(Pos.CENTER);
		homeButtons.setAlignment(Pos.CENTER);
		homeVBox.setAlignment(Pos.CENTER);
		
		/**
		 * Initially sets the stage with the home scene.	
		 */
		stage.setScene(homeScene);
		stage.setTitle(TITLE);
		stage.show();
	}
	
	/**
	 * Applies the CSS style.
	 */
	private void generateCSS() {
		playScene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());
		homeScene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());
		
		playButton.getStyleClass().add("extraButton");
		exitButton.getStyleClass().add("extraButton");
		scoreButton.getStyleClass().add("extraButton");
		enterButton.getStyleClass().add("extraButton");
		nextButton.getStyleClass().add("extraButton");
		quitButton.getStyleClass().add("extraButton");	
		extraButtons.getStyleClass().add("extraButtonsHbox");	
		spellText.getStyleClass().add("spellText");
		welcome.getStyleClass().add("welcome");
		welcomeP.getStyleClass().add("welcome");
		scoreText.getStyleClass().add("score");
	}

	/**
	 * This inner class handles the soundButton action event.
	 * @author Simone Scott
	 *
	 */
	class SoundButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Repeats audio of the current word.
		 */
		@Override
		public void handle(ActionEvent event) {
			audio.playWordSound();
			spaceButton.requestFocus();
		}	
	}
	
	/**
	 * This inner class handles the playButton action event.
	 * @author Simone Scott
	 *
	 */
	class PlayButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Sets the scene to the playScene from the homeScene,
		 * generates a random word and plays audio for the word.
		 * If no name is entered or it contains spaces nothing happens.
		 * @param event
		 */
		@Override
		public void handle(ActionEvent event) {
			audio.playPopSound();
			
			if (name.getText().isEmpty() || name.getText().contains(" ")) {
				// do nothing
			} else {
				nextButton.setDisable(true);
				spaceButton.requestFocus();
				stage.setScene(playScene);

				FileProcessor.newWord();
				audio.playWordSound();
			}
		}	
	}
	
	/**
	 * This inner class handles the scoreButton action event.
	 * @author Simone Scott
	 *
	 */
	class ScoreButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Makes the high scores visible.
		 */
		@Override
		public void handle(ActionEvent event) {
			audio.playPopSound();
			highScores.setVisible(true);
		}		
	}
	
	/**
	 * This inner class handles the quitButton action event.
	 * @author Simone Scott
	 *
	 */
	class QuitButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Quits the current round of gameplay and returns to the
		 * home scene. If the score earned is a new high score, 
		 * a congratulatory message is displayed and the high 
		 * score file is updated. The score counters are reset.
		 */
		@Override
		public void handle(ActionEvent event) {
			highScores.setVisible(false);
			
			// Prevent newline characters in name.
			String nameNoSpace = name.getText().replace("\n", "");
			FileProcessor.addScore(posScoreCounter, nameNoSpace);
			
			if (FileProcessor.isHighScore()) {
				congrats.setText("Congratulations! New High Score: " + posScoreCounter);
				congrats.setVisible(true);
			} else {
				congrats.setVisible(false);
			}
			
			audio.playPopSound();
			posScoreCounter = 0;
			negScoreCounter = 0;
			
			name.clear();
			spellText.setText("");
			enterButton.setDisable(false);			
			scoreText.setText("Score: Correct " + posScoreCounter + " Wrong " + negScoreCounter);
			highScores.setText("High Scores:\n" + FileProcessor.getHighScores());
			stage.setScene(homeScene);
		}	
	}
	
	/**
	 * This inner class handles the enterButton action event.
	 * @author Simone Scott
	 *
	 */
	class EnterButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Submits the current spelling attempt for checking. 
		 * If the spelling is correct, the correct score counter 
		 * increments by 1 and a success sound is played. If 
		 * incorrect, the incorrect counter increments by 1 and 
		 * a fail sound is played. If the text area is blank, nothing
		 * happens.
		 */
		@Override
		public void handle(ActionEvent event) {
			spellString = spellText.getText();
			
			if (spellChecker.isCorrectlySpelled(spellString)) {
				posScoreCounter++;
				scoreText.setText("Score: Correct " + posScoreCounter + " Wrong " + negScoreCounter);
				audio.playSuccess();

				nextButton.setDisable(false);
				enterButton.setDisable(true);
				spaceButton.requestFocus();
			} else if (spellString.isEmpty() || spellString.contains(" ")) {
				// Do nothing.
			} else {
				negScoreCounter++;
				scoreText.setText("Score: Correct " + posScoreCounter + " Wrong " + negScoreCounter);
				audio.playFailure();

				nextButton.setDisable(false);
				spaceButton.requestFocus();
			}
		}	
	}
	
	/**
	 * This inner class handles the nextButton action event.
	 * @author Simone Scott
	 *
	 */
	class NextButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Generates a new random word, and the audio of that word 
		 * is played. The nextButton is disabled while the spelling 
		 * text area is blank.
		 */
		@Override
		public void handle(ActionEvent event) {
			FileProcessor.newWord();
			audio.playWordSound();
			
			spellText.setText("");
			
			nextButton.setDisable(true);
			enterButton.setDisable(false);
			spaceButton.requestFocus();
		}		
	}
	
	/**
	 * This inner class handles the exitButton action event.
	 * @author Simone Scott
	 *
	 */
	class ExitButtonHandler implements EventHandler<ActionEvent> {

		/**
		 * Closes the application.
		 */
		@Override
		public void handle(ActionEvent event) {
			System.exit(0);
		}		
	}
	
	/**
	 * This inner class handles the key events for all letter
	 * keys, the enter key, and the backspace key.
	 * @author Simone Scott
	 *
	 */
	class KeyHandler implements EventHandler<KeyEvent> {	

		/**
		 * When letter keys a-z, enter, or backspace are 
		 * pressed, their corresponding buttons perform 
		 * a Button handler.
		 */
		@Override
		public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.ENTER) {
				// The enter Button is disabled only after earning a point.
				// Pressing the enter KEY at this time will fire the Next button.
				if (enterButton.isDisabled()) {
					nextButton.fire();
				} else { // Otherwise, the enter key will fire the enter button as normal.
					enterButton.fire();
				}
			} else if (event.getCode() == KeyCode.BACK_SPACE) {
				if (spellSb.length() == 0) {
					// do nothing
				} else {
					spellSb.deleteCharAt(spellSb.length() - 1);
					spellText.setText(spellSb.toString());
				}
			} else {
				// Iterates thru all buttons/letters. Pressing the key fires the button.
				for(Map.Entry<Button, Character> entry : buttonList.entrySet()) {
					Button button = entry.getKey();
					char ch = entry.getValue();
					String letter = String.valueOf(ch);
					
					if(event.getCode() == KeyCode.getKeyCode(letter)) {
						// Pressing the letter key fires that button
						button.fire();
					}
				}
			}
		}	
	}
	
	/**
	 * This inner class handles the playButton action event.
	 * @author Simone Scott
	 *
	 */
	class LetterButtonHandler implements EventHandler<ActionEvent> {		

		/**
		 * Types letters into the spelling text, concatenating to
		 * form a word
		 */
		@Override
		public void handle(ActionEvent event) {
			audio.playPopSound();
			
			// Iterates thru each Button/char pair until the button that was clicked is found
			for(Map.Entry<Button, Character> entry : buttonList.entrySet()) {
				Button button = (Button) event.getSource();
				
				if(button.equals(spaceButton)) {
					// The invisible space button can not be clicked, so does nothing
				} else if(button.equals(entry.getKey())) {	// If the current button was clicked
					addLetter(entry.getValue());	// add the letter char of this button to the text
				}
			}
			spaceButton.requestFocus();	// Sets focus on invisible button.
		}	// End of handle method.		

		private void addLetter(char letter) {
			spellSb.setLength(0);	// clear the stringbuilder	
			spellString = spellText.getText();
			spellSb.append(spellString);	// first add the spelltext so far to the stringbuilder
			spellSb.append(letter);	//then add the new letter		
			spellText.setText(spellSb.toString());	// set the spelltext to the newly concatenated string
		}
	}	// End of LetterButtontHandler inner class
}	// End of SpellingGui outer class