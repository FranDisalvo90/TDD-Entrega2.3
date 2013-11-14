package ar.fi.uba.td.testFramework;

/**
 * Class used to compare objects in assertions. All the methods return in case
 * of success and throw a TestFailedException in case of failure.
 */
public class Assert {

    /**
     * Protect constructor since it is a static class
     */
    protected Assert() {
    }

    /**
     * Fails a test throwing a TestFailedException.
     */
    static public void fail(String message) throws TestFailedException {
	throw new TestFailedException(message);
    }

    /**
     * Asserts that the source is a boolean with the truth value, throws a
     * TestFailedException otherwise.
     */
    static public void assertTrue(Boolean source, String message)
	    throws TestFailedException {
	if (source == false) {
	    fail(message);
	}
    }

    /**
     * Asserts that the source is a boolean with the false value, throws a
     * TestFailedException otherwise.
     */
    static public void assertFalse(Boolean source, String message)
	    throws TestFailedException {
	if (source == true) {
	    fail(message);
	}
    }

    /**
     * Asserts that the source object is equal to the expected one using its
     * equal(Object) method. Fails the test throwing a TestFailedException
     * otherwise.
     */
    static public void assertEquals(Object source, Object expected,
	    String message) throws TestFailedException {

	if (source == null && expected == null) {
	    return;
	}
	if (source != null && source.equals(expected)) {
	    return;
	}
	fail(message);
    }

    /**
     * Asserts that the source object is not equal to the expected one using its
     * equal(Object) method. Fails the test throwing a TestFailedException
     * otherwise.
     */
    static public void assertNotEquals(Object source, Object expected,
	    String message) throws TestFailedException {
	if (source == null && expected == null) {
	    return;
	}
	if (source != null && !source.equals(expected)) {
	    return;
	}
	fail(message);
    }

    /**
     * Asserts that the source object is the same as the expected one. Fails the
     * test throwing a TestFailedException otherwise.
     */
    static public void assertSame(Object source, Object expected, String message)
	    throws TestFailedException {
	if (source == null && expected == null) {
	    return;
	}
	if (source != null && source == expected) {
	    return;
	}
	fail(message);
    }

    /**
     * Asserts that the source object is not the same as the expected one. Fails
     * the test throwing a TestFailedException otherwise.
     */
    static public void assertNotSame(Object source, Object expected,
	    String message) throws TestFailedException {
	if (source == null && expected == null) {
	    return;
	}
	if (source != null && source != expected) {
	    return;
	}
	fail(message);
    }

    /**
     * Asserts that the source object is a null reference. Fails the test
     * throwing a TestFailedException otherwise.
     */
    static public void assertNull(Object source, String message)
	    throws TestFailedException {
	if (source != null)
	    throw new TestFailedException(message);
    }

    /**
     * Asserts that the source object is not a null reference. Fails the test
     * throwing a TestFailedException otherwise.
     */
    static public void assertNotNull(Object source, String message)
	    throws TestFailedException {
	if (source == null)
	    throw new TestFailedException(message);
    }

}
