package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordOccurrencesFuture
{	
	private static ExecutorService executor =
		Executors.newFixedThreadPool( 4 );

	public static Map< String, Integer > wordCount( String line )
	{
		String[] words = line.split( "\\s+" );
		Map< String, Integer > occurrences = new HashMap<>();
		for( String word : words ) {
			if ( occurrences.containsKey( word ) ) {
				int count = occurrences.get( word );
				occurrences.put( word, count + 1 );
			} else {
				occurrences.put( word, 1 );
			}
		}
		return occurrences;
	}
	
	public static void run()
	{
		/*
			word -> number of occurrences
		
			hello hello hi class room class
		
			hello -> 2
			hi -> 1
			class -> 2
			room -> 1
		*/
		Path path = Paths.get( "bigtext.txt" );
		try {
			BufferedReader reader = Files.newBufferedReader( path );
			String line;
			List< Future< Map< String, Integer > > > results = new ArrayList<>();
			while( (line = reader.readLine()) != null ) {
				final String currentLine = line;
				results.add( executor.submit(
					() -> wordCount( currentLine )
				) );
			}
			
			
			executor.shutdown();
			executor.awaitTermination( 1, TimeUnit.DAYS );
			Map< String, Integer > occurrences = new HashMap<>();
			for( Future< Map< String, Integer > > f : results ) {
				Map< String, Integer > lineResult = f.get();
				for( String word : lineResult.keySet() ) {
					occurrences.compute( word,
					( k, v ) -> {
						/* ( v == null ) ?
							lineResult.get( word ) : v + lineResult.get( word ) */
						if ( v == null ) {
							return lineResult.get( word );
						} else {
							return v + lineResult.get( word );
						}
					} );
				}
			}
			for( String key : occurrences.keySet() ) {
				System.out.println( key + " -> " + occurrences.get( key ) );
			}
		} catch( IOException e ) {
			e.printStackTrace();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		} catch( ExecutionException e ) {
			e.printStackTrace();
		}
	}
}
