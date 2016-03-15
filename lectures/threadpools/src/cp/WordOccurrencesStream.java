package cp;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordOccurrencesStream
{
	public static void run()
	{
		try {
			Path path = Paths.get( "bigtext.txt" );
			BufferedReader reader = Files.newBufferedReader( path );
		/* 	int total = reader
				.lines()
				.parallel()
				// .
				.flatMap( line -> line.split( "\\s+" ) ); */
			// System.out.println( total );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
