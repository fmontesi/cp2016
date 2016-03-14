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
				.sum();
			System.out.println( total );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
