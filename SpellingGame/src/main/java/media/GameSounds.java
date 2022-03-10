/*************************************************************************************************************
  Name: Simone Scott
  
  Operation class to run GameSounds. Has methods to search for audio files within the project
  sounds folder and online. Plays the audio as AudioClips. The audio played includes a success, failure, and 
  pop sounds as well as the audio of a spoken word and game music.
**************************************************************************************************************/
package media;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import business.FileProcessor;

/**
 * Plays audio clips from file sources inside the project
 * and online sources.
 * @author Simone Scott
 *
 */
public class GameSounds {
	
	private String word;
	private Clip popClip;
	private Clip successClip;
	private Clip failClip;
	private String popResource = "/sounds/pop.wav";
	private String successResource = "/sounds/success.wav";
	private String failResource = "/sounds/incorrect.wav";
	
	/**
	 *  The constructor pre-loads the frequently repeated sound clips.
	 */
	public GameSounds() {
		loadPopClip();	
		loadSuccessClip();	
		loadFailClip();	
	}

	
	/**
	 * Plays the audio clip of a randomly generated word.
	 */
	public void playWordSound() {
		word = FileProcessor.getWord();
		
		try {
			InputStream in = getClass().getResourceAsStream("/sounds/" + word + "_us_1.wav");
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
			
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
           e.printStackTrace();
        }
	}
	
	/**
	 * Plays the audio clip of a specified word.
	 * @param word The word whose sound is played.
	 */
	public void playWordSound(String word) {
		System.out.println("Playing sound: " + word);
		
		try {
			InputStream in = getClass().getResourceAsStream("/sounds/" + word + "_us_1.wav");
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
			
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
           e.printStackTrace();
        }
		
	}
	
	
	/**
	 * Plays the game music audio clip. Loops 5 times.
	 */
	public void playMusic() {
		try {
			InputStream in = getClass().getResourceAsStream("/sounds/game-music.wav");
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
	    	
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioIn);
	        
	        // Lower volume 18x.
	        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(-18);
	        
	        clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
	}
	
	/**
	 * Plays a short popping audio clip.
	 */
	public void playPopSound() {
		popClip.setFramePosition(0);	// set clip to the beginning
		popClip.start();	// play the clip
	}
	
	/**
	 * Plays the success audio clip.
	 */
	public void playSuccess() {
		successClip.setFramePosition(0);
		successClip.start();  
	}
		
	/**
	 * Plays the failure audio clip.
	 */
	public void playFailure() {
        failClip.setFramePosition(0);
        failClip.start();
	}
	
	
	/**
	 * Pre-loads the pop clip to improve performance for
	 * highly repeated sound clip usage.
	 */
	private void loadPopClip() {
		try {
			InputStream in = getClass().getResourceAsStream(popResource);
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
			
			popClip = AudioSystem.getClip();
			popClip.open(audioIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre-loads the success clip to improve performance for
	 * highly repeated sound clip usage.
	 */
	private void loadSuccessClip() {
		try {
			InputStream in = getClass().getResourceAsStream(successResource);
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
			
			successClip = AudioSystem.getClip();
			successClip.open(audioIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre-loads the fail clip to improve performance for
	 * highly repeated sound clip usage.
	 */
	private void loadFailClip() {
		try {
			InputStream in = getClass().getResourceAsStream(failResource);
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn);
			
			failClip = AudioSystem.getClip();
			failClip.open(audioIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}