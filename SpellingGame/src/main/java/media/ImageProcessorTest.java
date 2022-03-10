/*************************************************************************************************************
  Name: Simone Scott
  
  Driver class to test ImageProcessor. Prints the location of specified image files.
**************************************************************************************************************/
package media;

/**
 * Tests the {@code ImageProcessor} class.
 * @author Simone Scott
 *
 */
public class ImageProcessorTest {

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		ImageProcessor photos = new ImageProcessor();
		System.out.println(photos.getImage("a"));
		System.out.println(photos.getGif("squares-background"));
	}
}
