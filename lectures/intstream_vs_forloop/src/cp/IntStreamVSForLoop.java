package cp;

import java.util.stream.IntStream;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class IntStreamVSForLoop
{
	public static void main( String[] args )
	{
		IntStream.range( 0, 10 ).forEach( i -> System.out.println( i ) );
		// Does the same thing as:
		IntStream.range( 0, 10 ).forEach( System.out::println );
		
		// For loop equivalent:
		for( int i = 0; i < 10; i++ ) {
			System.out.println( i );
		}

		// Still equivalent:
		int i = -1;
		for( i = 0; i++ < 10; ) {
			System.out.println( i );
		}
		
		// for ( FIRST_STATEMENT; ITERATION_CONDITION; POST_STATEMENT )
	}	
}
