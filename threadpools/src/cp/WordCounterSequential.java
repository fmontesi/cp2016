package cp;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class WordCounterSequential
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
	
	private static int wordCount( String str )
	{
		// May contains bugs!
		// The right number is: 14801631
		if ( str.isEmpty() ) {
			return 0;
		}
		
		boolean wasWhitespace = true;
		
		int counter = 0;

		for( int i = 0; i < str.length(); i++ ) {
			if ( Character.isWhitespace( str.charAt( i ) ) && !wasWhitespace ) {
				counter++;
				wasWhitespace = true;
			} else if ( !Character.isWhitespace( str.charAt( i ) ) ) {
				wasWhitespace = false;
			}
		}
		
		return counter;
	}

	public static void run()
	{
		try {
			File file = new File( "bigtext.txt" );
			FileInputStream is = new FileInputStream( file );
			final long size = file.length();
			byte[] content = new byte[ (int)size ];
			is.read( content );
			final String str = new String( content );
			
			long tStart = System.currentTimeMillis();
			System.out.println( wordCount( str ) );
			System.out.println( "Sequential took: " + (System.currentTimeMillis() - tStart) );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
