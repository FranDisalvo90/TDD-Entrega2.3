package testFramework;

/**
 * Comparator implements all asserts comparisons
 */

/**
 * @author Patricio
 *
 */

public class Comparator {
	public void assertTrue(Object sourse, String message) throws TestFailedException {
		if ((Boolean)sourse == false) {
			throw new TestFailedException(message);
		}
	}
	
	public void assertFalse(Object sourse, String message) throws TestFailedException {
		if ((Boolean)sourse == true) {
			throw new TestFailedException(message);
		}
	}

	public void assertEquals(Object sourse, Object expected, String message) throws TestFailedException{
		if (sourse.equals(expected)) {
			throw new TestFailedException(message);
		}
	}
	
	public void assertDifferent(Object sourse, Object expected, String message) throws TestFailedException{
		if (!sourse.equals(expected)) {
			throw new TestFailedException(message);
		}
	}
	
	public void assertBigger(Object sourse, Object expected, String message) throws TestFailedException{
		/*if ((int)sourse < (int)expected) {
			throw new TestFailedException(message);
		}*/
	}
	
	public void assertLess(Object sourse, Object expected, String message) throws TestFailedException{
		/*if ((int)sourse > (int)expected) {
			throw new TestFailedException(message);
		}*/
	}
}
