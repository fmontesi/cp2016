package cp;



import java.nio.file.Path;
import java.util.List;

/**
 * 
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class NumFinder
{
	/**
	 * Computes the sum of all numbers in all text files in a directory.
	 * Only text files should be considered (files ending with the .txt suffix).
	 * 
	 * You can assume that each text file contains a (non-empty) comma-separated sequence of
	 * numbers written. For example: 100,200,34,25
	 * There won't be any new lines, spaces, etc., and the sequence never ends with a comma.
	 * 
	 * The search is recursive: if the directory contains subdirectories,
	 * these are also searched and so on so forth (until there are no more
	 * subdirectories).
	 * 
	 * @param dir the directory to search
	 * @return a list of results ({@link Result}), each giving the sum for a file found
	 */
	public static List< Result > findAll( Path dir )
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Finds a file for which the sum of the numbers contained therein
	 * is major or equal than min.
	 * 
	 * This method searches only for one (any) file in the directory
	 * (parameter dir) such that the condition above is respected.
	 * As soon as one such occurrence is found, the search can be
	 * stopped and the method can return immediately.
	 * 
	 * As for method {@code findAll}, the search is recursive.
	 */
	public static Result findAny( Path dir, int min )
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Computes overall statistics about the occurrences of words in a directory.
	 * 
	 * This method recursively searches the directory for all words and returns
	 * a {@link Stats} object containing the statistics of interest. See the
	 * documentation of {@link Stats}.
	 */
	public static Stats stats( Path dir )
	{
		throw new UnsupportedOperationException();
	}
}
