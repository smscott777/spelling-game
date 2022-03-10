/*************************************************************************************************************
  Name: Simone Scott
  
  Driver class to test FileProcessor and SpellingChecker.
**************************************************************************************************************/
package business;

import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Calls methods to test various methods in FileProcessor and SpellingChecker
 * classes. For testing purposes.
 * @author Simone Scott
 */
public class FileProcessorTest {

	public static void main(String[] args) throws IOException {

		FileProcessor.newWord();
		
		System.out.println("From FileProcessor's getWord() method: " + FileProcessor.getWord());
		System.out.println("From FileProcessor's getWordCount() method: " + FileProcessor.getWordCount());
		
		SpellingChecker spell = new SpellingChecker();
		
		System.out.println("From SpellingChecker's getWord() method: " + spell.getWord());
		String guess = JOptionPane.showInputDialog("Spell it");
		JOptionPane.showMessageDialog(null, "It is correcly spelled: " + spell.isCorrectlySpelled(guess));

		FileProcessor.calcHighScores();
		System.out.println(FileProcessor.getHighScores());
		
		FileProcessor.addScore(1, "TestName");
		System.out.println(FileProcessor.getHighScores());
	}
}
