/*************************************************************************************************************
  Name: Simone Scott
  
  Operation class to run FileProcessor. Has static methods to interact with the text files within 
  the read folder, like generating a new random word from the SpellingWords.txt file and calculate the highest
  score from the high-scores.txt file. Can add new scores to the file of scores. 
**************************************************************************************************************/
package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Uses the text files in the read folder within the project
 * to manipulate the high scores and spelling words. 
 * @author Simone Scott
 *
 */
public class FileProcessor {
	
	private static String word;
	private static int wordCount;	
	private static String fileString;
	private static String highScores;
	private static String[] names;
	private static int[] scores;
	private static boolean done;
	private static boolean isHighScore;

	private static LinkedList<HighScore> scoresList = new LinkedList<HighScore>();

	/**
	 * Gets the word.
	 * @return the randomly generated word
	 */
	public static String getWord() {
		return word;
	}

	/**
	 * Sets the word.
	 * @param word The "random" word.
	 */
	public static void setWord(String word) {
		FileProcessor.word = word;
	}
	
	/**
	 * Gets the high scores as a {@code String}.
	 * @return a {@code String} of high scores
	 */
	public static String getHighScores() {
		return highScores;
	}
	/**
	 * Sets the high score String
	 * @param highScores a String of high scores
	 */
	public static void setHighScore(String highScores) {
		FileProcessor.highScores = highScores;
	}
	
	/**
	 * Returns true if isHighScore is true.
	 * @return the boolean isHighScore
	 */
	public static boolean isHighScore() {
		return isHighScore;
	}

	/**
	 * Gets the number of words in the file of spelling words.
	 * @return the word count
	 * @throws IOException
	 */
	public static int getWordCount() throws IOException {
		calcWordCount();
		return wordCount;
	}
	
	/**
	 * Calculates the number of words in the file of spelling words.
	 * @throws IOException
	 */
	private static void calcWordCount() throws IOException {
		wordCount = 0;
		
		InputStream in = FileProcessor.class.getResourceAsStream("/read/SpellingWords.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line = br.readLine();
		
		while(line != null) {
			line = br.readLine();
			wordCount++;
		}
	}
	
	/**
	 * Generates a new random word. Randomly selects a word
	 * from the spelling text file. Prints the integer position 
	 * of the generated word.
	 */
	public static void newWord() {
		try {
			InputStream in = FileProcessor.class.getResourceAsStream("/read/SpellingWords.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// Sets the mark at the beginning of the buffer, assuming it is large enough to hold the entire file.
			br.mark(0); 
						
			Random random = new Random();
			
			int wordPosition = random.nextInt(getWordCount()) + 1;
			
			int count = 1;
			// Serves the same purpose as seek(0)
			br.reset();
			word = br.readLine();
			
			while(count < wordPosition) {
				word = br.readLine();
				count++;
			}
			System.out.println("Random word generated. #" + wordPosition); 
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Reads the file of high scores, adds the names and scores to
	 * a LinkedList of high scores, sorts that list from high to low,
	 * then stores the high scores as a formatted String. 
	 */
	public static void calcHighScores() {
		try {
			highScores = "";
			int count = 0;	// To iterate through array elements.
			
			fileString = System.getProperty("user.home") + "/high-scores.txt";
			File file = new File(fileString);  // Create a file outside of jar in user's home directory
			file.getParentFile().mkdirs();
			file.createNewFile(); // Will do nothing if it already exists.
			BufferedReader br = new BufferedReader((new FileReader(file)));	// To read the file

			String line = br.readLine();
			
			String[] lineValues;
			try {
				lineValues = line.split(",");	// String array that holds score at index 0 and name at index 1
				scores = new int[5];	// Array of scores that holds a max of 5 elements
				names = new String[5];	// Array of names that holds a max of 5 elements
			} catch(NullPointerException e) {
				System.out.println("No high scores.");
			}
			while(line != null) {	// Loops until end of the file is reached.
				// Skips the line if it is whitespace.
				if(line.equals("")) {
					line = br.readLine();
				}
				
				lineValues = line.split(",");	// Divides the line into score and name
				names[count] = lineValues[1];	// Name added to names array.
				scores[count] = Integer.parseInt(lineValues[0]);	// Score added to scores array.
				
				scoresList.add(new HighScore(names[count], scores[count]));	// Add new high score object to list of high scores
				
				line = br.readLine();
				count++;
			}
			br.close();	
			
			sortHighScores();
			formatHighScores();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Formats the {@code LinkedList} of {@code HighScore} objects into 
	 * a String formatted with spaces and new lines.
	 */
	public static void formatHighScores() {
		highScores = "";
		
		for(HighScore score : scoresList) {
			highScores = highScores + score.getScore() + " " + score.getName() + "\n";
		}
	}
	
	/**
	 * Sorts the LinkedList of HighScore objects from
	 * highest integer score to lowest.
	 */
	public static void sortHighScores() {
		Collections.sort(scoresList);

	}
	
	/**
	 * Adds a new high score. If the high score list has less than 5
	 * entries, or if the new score is greater than any of the current
	 * high scores, the new score will be written to the high-score.txt file.
	 * @param score The numeric new score to be added.
	 * @param name The name of the player attached to the score.
	 */
	public static void addScore(int score, String name) {
		try {
			fileString = System.getProperty("user.home") + "/high-scores.txt";   
			File file = new File(fileString);  // Create a file outside of jar in user's home directory
			BufferedReader br = new BufferedReader((new FileReader(file)));	// To read the file
			PrintWriter out = new PrintWriter(								// To write to the file
									new BufferedWriter(
											new FileWriter(file, true)));
			
			String line = br.readLine();	// Stores the first line as a String
			String[] lineValues;
			int highScore = 0;
			
			/*	If the line is whitespace, skips to the next line. 
				If the file is empty and the line is null, it will not attempt to split it into names/scores.
			*/
			if(line != null) {
				if(line.equals("")) {
					line = br.readLine();
				}
				lineValues = line.split(",");	// Index 0 being scores, index 1 names
				
				highScore = Integer.parseInt(lineValues[0]);	// Stores the score on the current line
			}
			
			done = false;
			isHighScore = false;
			
			/**
			 * Checks each line to see if new score beats the score on that line.
			 * Ends loop when a score is beaten or when the end of the line is reached.
			 */
			while(done == false) {	
				if(score == 0) {
					System.out.println("No Points: " + score + " " + name);
					
					done = true;
					isHighScore = false;
				} else if(scoresList.size() < 5) {
					out.print( "\n" + score + "," + name);
					System.out.println("Added new high score(<5 on list): " + score + name);
					
					scoresList.add(new HighScore(name, score));
					sortHighScores();
					formatHighScores();
					
					done = true;
					isHighScore = true;
				} else if(score > highScore) { // Deletes the lowest score and adds new score.
					scoresList.removeLast();
					scoresList.add(new HighScore(name, score));
					sortHighScores();
					
					out = new PrintWriter(
							new BufferedWriter(
									new FileWriter(file)));
					
					highScores = "";	// Clears old String of highScores
					
					for(HighScore sc : scoresList) {						
						String indivScore = ((Integer) sc.getScore()).toString();
						
						highScores = highScores + indivScore + "," + sc.getName() + "\n";
					}
					out.print(highScores);
					highScores = highScores.replace(",", " ");	// Stores the string with spaces instead of commas
					System.out.println("Added new high score(beat existing): " + score + name);
			
					done = true;
					isHighScore = true;
				} else if(score <= highScore) {
					// If we are here, the new score <= the lowest highscore and the list is full
					// Do not replace the lowest highscore in a tie or when less than
					done = true;
					isHighScore = false;
				} else {		
					// Continue loop to compare score against next highscore on list
					lineValues = line.split(",");
					highScore = Integer.parseInt(lineValues[0]);
					line = br.readLine();
				}
			}
		out.close();
		br.close();	
		
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
}
