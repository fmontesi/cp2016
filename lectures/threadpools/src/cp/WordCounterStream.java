package cp;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordCounterStream
{
	public static void run()
	{
		try {
			Path path = Paths.get( "bigtext.txt" );
			BufferedReader reader = Files.newBufferedReader( path );
			int total = reader
				.lines()
				.parallel()
				.mapToInt( line -> line.split( "\\s+" ).length )
				// .reduce( 0, (n1, n2) -> n1 + n2 ); // Same as:
				.sum();
			System.out.println( total );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
