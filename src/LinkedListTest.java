import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LinkedListTest {

	public LinkedList<Integer> theList;
	
	public void insert(int x) {
		ListIterator<Integer> itr = theList.listIterator();
		while (itr.hasNext())
			if ( x <= itr.next() ) {
				itr.previous();
				itr.add(x);
				break;
			}
	}
		
	@Before
	public void setUp() throws Exception {
		theList = new LinkedList<Integer>();
		for (int n = 0; n < 10; n++)
			theList.add(2*n);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetup() {
		Assert.assertEquals(new Integer(2), theList.get(1));
		Assert.assertEquals(new Integer(18), theList.getLast());
	}
	
	@Test
	public void testInsert() {
		insert(5);
		Assert.assertEquals(new Integer(4), theList.get(2));
		Assert.assertEquals(new Integer(5), theList.get(3));
		Assert.assertEquals(new Integer(6), theList.get(4));
	}

}
