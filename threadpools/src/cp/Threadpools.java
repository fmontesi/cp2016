package cp;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class Threadpools
{
	public static void main( String[] args )
	{
		// WordCounterSequential.run();
		LetterCounterThreads.run(); // Warm up
		System.out.println( " -------------- Second Phase -------------- " );
		LetterCounterThreads.run();
	}
}
