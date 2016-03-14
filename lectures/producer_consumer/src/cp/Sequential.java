package cp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class Sequential
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
	private static final Deque< Product > THE_LIST = new LinkedList<>();
	
	private static void produce( Deque< Product > list )
	{
		IntStream.range( 1, 1000 ).forEach( i -> {
			list.add( new Product( "Water Bottle", "Liters: " + i ) );
			list.add( new Product( "Flower Bouquet", "Amount: " + i ) );
		} );
	}
	
	private static void consume( Deque< Product > list )
	{
		while( !list.isEmpty() ) {
			Product prod = list.removeFirst();
			System.out.println( prod ); // Equivalent to System.out.println( prod.toString() );
		}
	}
	
	public static void run()
	{
		produce( THE_LIST );
		consume( THE_LIST );
	}
}
