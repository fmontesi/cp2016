package cp;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class ConsumerExecutor
{
	private static class Product {
		private final String name;
		private final String attributes;
		public Product( String name, String attributes )
		{
			this.name = name;
			this.attributes = attributes;
		}
		
		public String toString()
		{
			return name + ". " + attributes;
		}
	}
	
	private static void consume( Product product )
	{
		// System.out.println( "Consumer " + Thread.currentThread().getName() + " consumes " + product );
	}
	
	private static void produce( int prodNumber )
	{
		IntStream.range( 0, 5000 ).forEach( i -> {
			Product prod = new Product( "Water", "Producer " + prodNumber + " : " + Integer.toString( i ) );
			// consume( prod );
			// System.out.println( prod );
			// new Thread( () -> consume( prod ) ).start();
			EXEC.execute( () -> consume( prod ) );
		} );
	}
	
	private static void runWithThreadStarts()
	{
		/*
		Whenever something is produced, start a thread handling it.
		*/
		
		new Thread( () -> produce( 1 ) ).start();
		new Thread( () -> produce( 2 ) ).start();
		new Thread( () -> produce( 3 ) ).start();
		new Thread( () -> produce( 4 ) ).start();
	}
	
	private static void runWithExecutor()
	{
		/*
		Whenever something is produced, submit the consumption to the executor.
		*/
	}
	
	private static void runWithFuture()
	{
		/*
		Whenever something is produced, submit the consumption to the executor.
		*/
	}
	
	private static final Executor EXEC = Executors.newFixedThreadPool( 4 );
	
	public static void run()
	{
		runWithThreadStarts();
		// runWithExecutor();
	}
}
