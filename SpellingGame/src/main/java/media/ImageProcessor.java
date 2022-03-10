/*************************************************************************************************************
  Name: Simone Scott
  
  Operation class to run ImageProcessor. Has methods to search for image files, png or gif, 
  within the project images folder. 
**************************************************************************************************************/
package media;

/**
 * Processes png or gif files within the project.
 * @author Simone Scott
 *
 */
public class ImageProcessor {
	
	private String urlString;

	/**
	 * Searches for the name of a png file and returns the
	 * url of the file as a {@code String}.
	 * @param fileName The name of the file to be searched.
	 * @return the url of the searched file as a {@code String}
	 */
	public String getImage(String fileName) {
		urlString = getClass().getResource("/images/"+ fileName + ".png").toExternalForm();
		return urlString;
	}
	
	/**
	 * Searches for the name of a gif file and returns the
	 * url of the file as a {@code String}.
	 * @param fileName The name of the file to be searched.
	 * @return the url of the searched file as a {@code String}
	 */
	public String getGif(String fileName) {
		urlString = getClass().getResource("/images/" + fileName + ".gif").toExternalForm();
		return urlString;
	}
}
