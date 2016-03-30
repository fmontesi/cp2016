package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class RecursiveWordCounter
{
	private static int countWordsStream( Path file )
		throws IOException
	{
		return Files.newBufferedReader( file )
					.lines()
					.mapToInt( line -> {
						String[] words = line.split( "\\s+" );
						int i = 0;
						for( String word : words ) {
							if ( !word.matches( "\\s*" ) ) {
								i++;
							}
						}
						return i;
					} )
					.sum();
	}
	
	private static int countWordsSomehow( Path file )
		throws IOException
	{
		BufferedReader reader = Files.newBufferedReader( file );
		int size = (int)Files.size( file );
		char[] cb = new char[ size ];
		reader.read( cb, 0, size );
		return new String( cb ).split( "\\s+" ).length;
	}
	
	private static int visit( Path dir )
	{
		int total = 0;
		
		// Files is a very useful utility class
		try (
			DirectoryStream< Path > dirStream = Files.newDirectoryStream( dir )
		) {
			for( Path path : dirStream ) {
				if ( Files.isDirectory( path ) ) {
					total += visit( path );
				} else {
					if ( path.toString().endsWith( ".txt" ) ) {
						System.out.println( path.toString() );
						// total += countWordsStream( path );
						total += countWordsSomehow( path );
					}
				}
			}
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
		return total;
	}

	public static void main( String[] args )
	{
		Path dir = Paths.get( "cash" );
		doAndMeasure( "Great!", () -> System.out.println( visit( dir ) ) );
		
		/* doAndMeasure( "Loop", () -> {
			int total = 0;
			for( int i = 0; i < 1000000; i++ ) {
				total += i;
			}
			System.out.println( "Total: " + total );
		} );
		doAndMeasure( "Stream", () -> {
			System.out.println( IntStream.range( 0, 1_000_000 ).sum() );
		} ); */
	}
	
	public static void doAndMeasure( String caption, Runnable runnable )
	{
		long tStart = System.currentTimeMillis();
		runnable.run();
		System.out.println( caption + " took " + (System.currentTimeMillis() - tStart) + "ms" );
	}
}
