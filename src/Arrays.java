import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Arrays {
	public int[] sortedNumbers;

	public void insert(int x) {
		// x = 5
		int index = 0;
		for (int n = 0; n < 10; n++) {
			if (x <= sortedNumbers[n]) { // [0, 2, 4, 6, 8 , ...]
				index = n;
				break;
			}
		}
		
		int[] newArray = new int[11];
		
		for (int n = 0; n < index; n++) {
			newArray[n] = sortedNumbers[n];
		}
		// [0, 2, 4, 0,0,0,0,0,0,0]
		
		newArray[index] = x;
		// [0, 2, 4, 5, 0,0,0,0,0,0]
		
		for (int n = index+1; n < 11; n++) {
			newArray[n] = sortedNumbers[n-1];
		}
		// [0, 2, 4, 5, 6,8,10,12,....]
		
		sortedNumbers = newArray;
	}
		
	
	@Before
	public void setUp() throws Exception {
		sortedNumbers = new int[10];
		for (int n = 0; n < 10; n++) {
			sortedNumbers[n] = 2*n;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void hasNumbers() {
		Assert.assertEquals(2, sortedNumbers[1]);
		Assert.assertEquals(18, sortedNumbers[9]);
	}

}
