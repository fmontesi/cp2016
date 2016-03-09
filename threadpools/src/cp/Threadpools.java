package cp;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class Threadpools
{
	public static void main( String[] args )
	{
		// LetterCounterSequential.run();
		// LetterCounterThreads.run();
		// WordCounter.run();
		// doAndMeasure( "", WordCounterExecutor::run );
		doAndMeasure( "", WordOccurrencesExecutor::run );
		// WordCounterFuture.run();
	}
	
	public static void doAndMeasure( String caption, Runnable runnable )
	{
		long tStart = System.currentTimeMillis();
		runnable.run();
		System.out.println( caption + " took " + (System.currentTimeMillis() - tStart) + "ms" );
	}
}
