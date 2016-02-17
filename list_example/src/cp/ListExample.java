package cp;

/**
 * A really good bad example about lists.
 * @author Fabrizio Montesi <fmontesi@imada.sdu.dk>
 */
public class ListExample
{
		private static class Node {
		private Node next = null;
		private int i;
		public Node( int i )
		{
			this.i = i;
		}
		
		public void setNext( Node next )
		{
			this.next = next;
		}
		
		public int content()
		{
			return i;
		}
		
		public Node next()
		{
			return next;
		}
	}
	
	private static void listAllDoWhile( Node node )
	{
		do {
			System.out.println( node.i );
		} while( (node = node.next()) != null );
	}
	
	private static void listAllWhile( Node node )
	{
		System.out.println( node.i );
		while( node.next() != null ) {
			node = node.next();
			System.out.println( node.i );
		}
	}
	
	private static void listAllRecursive( Node node )
	{
		System.out.println( node.i );
		if ( node.next() != null ) {
			listAllRecursive( node.next() );
		}
	}
	
	public static void main( String[] args )
	{
		Node n1 = new Node( 5 );
		Node n2 = new Node( 6 );
		Node n3 = new Node( 7 );
		n1.setNext( n2 );
		n2.setNext( n3 );
		listAllRecursive( n1 );
		listAllDoWhile( n1 );
		listAllWhile( n1 );
	}	
}
