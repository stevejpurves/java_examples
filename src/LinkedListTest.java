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

	public class FunkyObject implements Comparable<FunkyObject> {
		public Integer id;
		public String name;
		
		public FunkyObject(int i, String n)
		{
			id = i;
			name = n;
		}
		
		public int compareTo(FunkyObject obj)
		{
			return id - obj.id;				
		}
	}
	
	public <T extends Comparable<T>>void insert(LinkedList<T> theList, T x) {
		ListIterator<T> itr =theList.listIterator();
		while (itr.hasNext())
			if ( x.compareTo(itr.next()) < 0 ) {
				itr.previous();
				itr.add(x);
				break;
			}
	}
	

	@Test
	public void testSetup() {
		LinkedList<Integer> theList = new LinkedList<Integer>();
		for (int n = 0; n < 10; n++)
			theList.add(2*n);
		
		Assert.assertEquals(2, theList.get(1).intValue());
		Assert.assertEquals(18, theList.getLast().intValue());
	}
	
	@Test
	public void testInsert() {
		LinkedList<Integer> theList = new LinkedList<Integer>();
		for (int n = 0; n < 10; n++)
			theList.add(2*n);
		
		insert(theList, 5);
		
		Assert.assertEquals(4, theList.get(2).intValue());
		Assert.assertEquals(5, theList.get(3).intValue());
		Assert.assertEquals(6, theList.get(4).intValue());
	}

	@Test
	public
	void testInsertFunky() {
		LinkedList<FunkyObject> theList = new LinkedList<FunkyObject>();
		theList.add(new FunkyObject(0, "Cainton"));
		theList.add(new FunkyObject(2, "Steve"));
		theList.add(new FunkyObject(4, "Winston"));
		
		Assert.assertEquals("Cainton", theList.get(0).name);
		Assert.assertEquals("Steve", theList.get(1).name);
		Assert.assertEquals("Winston", theList.get(2).name);
		
		insert(theList, new FunkyObject(3, "Bob"));
		
		Assert.assertEquals("Steve", theList.get(1).name);
		Assert.assertEquals("Bob", theList.get(2).name);
		Assert.assertEquals("Winston", theList.get(3).name);
	}
}
