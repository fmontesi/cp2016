package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordCounter
{	
	private static AtomicInteger counter = new AtomicInteger( 0 );
	
	public static void wordCount( String line )
	{
		String[] words = line.split( "\\s+" );
		counter.addAndGet( words.length );
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
		List< Thread > threads = new LinkedList<>();
		try {
			BufferedReader reader = Files.newBufferedReader( path );
			String line;
			while( (line = reader.readLine()) != null ) {
				final String currentLine = line;
				final Thread t = new Thread(
					() -> wordCount( currentLine )
				);
				t.start();
				threads.add( t );
			}
			for( Thread t : threads ) {
				t.join();
			}
			System.out.println( counter.get() );
		} catch( IOException e ) {
			e.printStackTrace();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
