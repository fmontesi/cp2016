package cp;

import java.util.List;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public interface Stats
{
	/**
	 * Returns the number of times a word was found.
	 * @param word the word
	 * @return the number of times the word was found
	 */
	public int occurrences( String word );
	
	/**
	 * Returns the list of results in which a word was found.
	 * @param word the word
	 * @return the list of results in which the word was found
	 */
	public List< Result > foundIn( String word );
	
	/**
	 * Returns the word that was found the most times.
	 * @return the word that was found the most times
	 */
	public String mostFrequent();
	
	/**
	 * Returns the word that was found the least times.
	 * @return the word that was found the least times
	 */
	public String leastFrequent();
	
	/**
	 * Returns a list of all the words found.
	 * @return a list of all the words found
	 */
	public List< String > words();
	
	/**
	 * Returns a list of all the words found, ordered from the least frequently occurring (first of the list)
	 * to the most frequently occurring (last of the list).
	 * @return a list of all the words found, ordered from the least to the most frequently occurring
	 */
	public List< String > wordsByOccurrences();
}
