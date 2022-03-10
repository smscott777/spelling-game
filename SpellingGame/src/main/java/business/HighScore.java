/*************************************************************************************************************
  Name: Simone Scott
  
  Operation class to run HighScore. The constructor creates a HighScore object with a name
  and a score. Implements the comparable interface for sorting by score: high to low.
**************************************************************************************************************/
package business;

/**
 * Instances of this class construct a HighScore object with
 * a name and an integer score. The comparable interface is 
 * implemented to allow sorting by scores in descending order.
 * @author Simone Scott
 *
 */
public class HighScore implements Comparable {

	String name;
	int score;
	
	/**
	 * Two-args Constructor.
	 * @param name The user's name.
	 * @param score The user's integer score.
	 */
	HighScore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Gets the score.
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Sets the score
	 * @param score The score.
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the user's name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user's name.
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sorts by descending order, highest score to lowest.
	 */
	@Override
	public int compareTo(Object o) {
		if(this.score == ((HighScore) o).getScore()) {
			return 0;
		}
		else if(this.score < ((HighScore) o).getScore()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
