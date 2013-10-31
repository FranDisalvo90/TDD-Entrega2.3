package ar.fi.uba.td.testFramework;

/**
 * Class used to compare objects in assertions. All the methods return in case
 * of success and throw a TestFailedException in case of failure.
 */
public class Comparator {

	/**
	 * Fails a test throwing a TestFailedException.
	 */
	public void fail(String message) throws TestFailedException {
		throw new TestFailedException(message);
	}

	/**
	 * Asserts that the source object is a boolean with the truth value, throws
	 * a TestFailedException otherwise.
	 */
	public void assertTrue(Object source, String message)
			throws TestFailedException {
		if ((Boolean) source == false) {
			throw new TestFailedException(message);
		}
	}

	/**
	 * Asserts that the source object is a boolean with the false value, throws
	 * a TestFailedException otherwise.
	 */
	public void assertFalse(Object source, String message)
			throws TestFailedException {
		if ((Boolean) source == true) {
			throw new TestFailedException(message);
		}
	}

	/**
	 * Asserts that the source object is equal to the expected one using its
	 * equal(Object) method. Fails the test throwing a TestFailedException
	 * otherwise.
	 */
	public void assertEquals(Object source, Object expected, String message)
			throws TestFailedException {
		if (!source.equals(expected)) {
			throw new TestFailedException(message);
		}
	}

	/**
	 * Asserts that the source object is not equal to the expected one using its
	 * equal(Object) method. Fails the test throwing a TestFailedException
	 * otherwise.
	 */
	public void assertNotEquals(Object source, Object expected, String message)
			throws TestFailedException {
		if (source.equals(expected)) {
			throw new TestFailedException(message);
		}
	}

	/**
	 * Asserts that the source object is the same as the expected one. Fails the
	 * test throwing a TestFailedException otherwise.
	 */
	public void assertSame(Object source, Object expected, String message)
			throws TestFailedException {
		if (source != expected)
			throw new TestFailedException(message);
	}

	/**
	 * Asserts that the source object is not the same as the expected one. Fails
	 * the test throwing a TestFailedException otherwise.
	 */
	public void assertNotSame(Object source, Object expected, String message)
			throws TestFailedException {
		if (source == expected)
			throw new TestFailedException(message);
	}

	/**
	 * Asserts that the source object is a null reference. Fails the test
	 * throwing a TestFailedException otherwise.
	 */
	public void assertNull(Object source, String message)
			throws TestFailedException {
		if (source != null)
			throw new TestFailedException(message);
	}

	/**
	 * Asserts that the source object is not a null reference. Fails the test
	 * throwing a TestFailedException otherwise.
	 */
	public void assertNotNull(Object source, String message)
			throws TestFailedException {
		if (source == null)
			throw new TestFailedException(message);
	}

}
