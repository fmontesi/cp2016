package cp;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

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
			HashMap< String, Integer > result = reader
				.lines()
				.parallel()
				.flatMap( line -> Stream.of( line.split( "\\s+" ) )	)
				.reduce(
					new HashMap<>(),
					( tempMap, word ) -> {
						HashMap< String, Integer > m = new HashMap<>();
						m.putAll( tempMap );
						if ( m.containsKey( word ) ) {
							m.put( word, m.get( word ) + 1 );
						} else {
							m.put( word, 1 );
						}
						return m;
					},
					( m1, m2 ) -> {
						HashMap< String, Integer > m = new HashMap<>();
						m.putAll( m1 );
						m2.forEach( ( k, v ) -> {
							if ( m.containsKey( k ) ) {
								m.put( k, m.get( k ) + v );
							} else {
								m.put( k, v );
							}
						} );
						return m;
					}
				);
				result.forEach( (k, v) -> System.out.println( k + " : " + v ) );
			/*
				U result = identity;
				for (T element : this stream)
					result = accumulator.apply(result, element)
				return result;
			*/
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
