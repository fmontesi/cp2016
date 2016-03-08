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
		WordCounterThreads.run(); // Warm up
		System.out.println( " -------------- Second Phase -------------- " );
		WordCounterThreads.run();
	}
}
