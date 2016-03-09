package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordCounterFutureStream
{	
	private static ExecutorService executor =
		Executors.newFixedThreadPool( 4 );
		// Executors.newCachedThreadPool();
	
	public static Integer wordCount( String line )
	{
		return line.split( "\\s+" ).length;
	}
	
	public static void run()
	{
		// Read bigtext.txt
		// read the lines
		// give each line to a new thread
		// the thread counts the words in the line
		// a shared int is updated.
		// latch and print
		Path path = Paths.get( "bigtext.txt" );
		try {
			BufferedReader reader = Files.newBufferedReader( path );
			String line;
			List< Future< Integer > > results = new ArrayList<>();
			while( (line = reader.readLine()) != null ) {
				final String currentLine = line;
				Future< Integer > f = executor.submit(
					() -> wordCount( currentLine )
				);
				results.add( f );
			}
			executor.shutdown();
			executor.awaitTermination( 1, TimeUnit.DAYS );
			int total = results.stream().mapToInt(
				fut -> {
					try {
						return fut.get();
					} catch( Exception e ) {
						return 0;
					}
				}
			).sum();
			System.out.println( total );			
		} catch( IOException e ) {
			e.printStackTrace();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
