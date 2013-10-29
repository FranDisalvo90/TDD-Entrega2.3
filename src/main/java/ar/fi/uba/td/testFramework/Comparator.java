package ar.fi.uba.td.testFramework;

/**
 * Class used to compare objects in assertions.
 */

public class Comparator {
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

	public void assertDifferent(Object source, Object expected, String message)
			throws TestFailedException {
		if (!source.equals(expected)) {
			throw new TestFailedException(message);
		}
	}

	public void assertBigger(Object source, Object expected, String message)
			throws TestFailedException {
		/*
		 * if ((int)source < (int)expected) { throw new
		 * TestFailedException(message); }
		 */
	}

	public void assertLess(Object source, Object expected, String message)
			throws TestFailedException {
		/*
		 * if ((int)source > (int)expected) { throw new
		 * TestFailedException(message); }
		 */
	}
}
