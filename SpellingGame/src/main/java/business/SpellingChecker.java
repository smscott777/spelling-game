/*************************************************************************************************************
  Name: Simone Scott
  
  Operation class to run SpellingChecker. Checks if a word matches the correct spelling of
  a word in the SpellingWords.txt file.
**************************************************************************************************************/
package business;

/**
 * Instances of this class are used to compare the correct spelling
 * of a word from the spelling file to a user's guess spelling.
 * @author Simone Scott
 *
 */
public class SpellingChecker {
	
	private String correctSpelling;

	/**
	 * Constructor initializes {@code correctSpelling} with
	 * the most recent generated word.
	 */
	public SpellingChecker() {
		correctSpelling = FileProcessor.getWord();
	}
	
	/**
	 * Returns true if the spelling guess is correctly spelled.
	 * @param guessSpelling the user's spelling guess
	 * @return true if spelled correctly or false if not
	 */
	public boolean isCorrectlySpelled(String guessSpelling) {
		
		correctSpelling = FileProcessor.getWord();
		
		if(correctSpelling.equalsIgnoreCase(guessSpelling)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gets the correct spelling
	 * @return the correctly spelled word.
	 */
	public String getWord() {
		return correctSpelling;
	}
	
}
