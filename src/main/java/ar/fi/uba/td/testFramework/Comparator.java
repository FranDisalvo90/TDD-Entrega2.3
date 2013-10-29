package ar.fi.uba.td.testFramework;

/**
 * Class used to compare objects in assertions.
 */

public class Comparator {
	
	public void fail(String message) throws TestFailedException {
		throw new TestFailedException(message);
	}
	
	public void assertTrue(Object source, String message)
			throws TestFailedException {
		if ((Boolean) source == false) {
			throw new TestFailedException(message);
		}
	}

	public void assertFalse(Object source, String message)
			throws TestFailedException {
		if ((Boolean) source == true) {
			throw new TestFailedException(message);
		}
	}

	public void assertEquals(Object source, Object expected, String message)
			throws TestFailedException {
		if (!source.equals(expected)) {
			throw new TestFailedException(message);
		}
	}

	public void assertNotEquals(Object source, Object expected, String message)
			throws TestFailedException {
		if (source.equals(expected)) {
			throw new TestFailedException(message);
		}
	}

	public void assertSame(Object source, Object expected, String message)
			throws TestFailedException {
		if (source != expected)
			throw new TestFailedException(message);
	}

	public void assertNotSame(Object source, Object expected, String message)
			throws TestFailedException {
		if (source == expected)
			throw new TestFailedException(message);
	}

	public void assertNull(Object source, String message)
			throws TestFailedException {
		if (source != null)
			throw new TestFailedException(message);
	}
	
	public void assertNotNull(Object source, String message)
			throws TestFailedException {
		if (source == null)
			throw new TestFailedException(message);
	}	
	
}
