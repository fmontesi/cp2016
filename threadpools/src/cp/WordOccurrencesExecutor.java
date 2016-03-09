package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordOccurrencesExecutor
{	
	private static ExecutorService executor =
		Executors.newFixedThreadPool( 4 );
	
	private static Map< String, Integer > occurrences
		= new HashMap<>();
		// = new ConcurrentHashMap<>();

	public static void wordCount( String line )
	{
		String[] words = line.split( "\\s+" );
		synchronized( occurrences ) {
		for( String word : words ) {
			
				if ( occurrences.containsKey( word ) ) {
					int count = occurrences.get( word );
					occurrences.put( word, count + 1 );
				} else {
					occurrences.put( word, 1 );
				}
			}
		}
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
			while( (line = reader.readLine()) != null ) {
				final String currentLine = line;
				executor.submit(
					() -> wordCount( currentLine )
				);
			}
			executor.shutdown();
			executor.awaitTermination( 1, TimeUnit.DAYS );
			for( String key : occurrences.keySet() ) {
				System.out.println( key + " -> " + occurrences.get( key ) );
			}
		} catch( IOException e ) {
			e.printStackTrace();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
