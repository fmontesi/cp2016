package cp;



import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public interface Stats
{
	/**
	 * Returns the number of times a number was found (in any files).
	 */
	public int occurrences( int number );
	
	/**
	 * Returns the list of files whose sum is major or equal to parameter min.
	 */
	public List< Path > atLeast( int min );
	
	/**
	 * Returns the number that was found the most times.
	 */
	public int mostFrequent();
	
	/**
	 * Returns the number that was found the least times.
	 */
	public int leastFrequent();
	
	/**
	 * Returns a list of all the numbers found, ordered from the least frequently occurring (first of the list)
	 * to the most frequently occurring (last of the list).
	 */
	public List< Integer > byOccurrences();
}
