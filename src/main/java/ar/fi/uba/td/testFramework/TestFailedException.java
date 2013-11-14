package ar.fi.uba.td.testFramework;

/**
 * Special exception of this framework thrown by tests that fail.
 */

public class TestFailedException extends Exception {
    private static final long serialVersionUID = 1L;

    public TestFailedException(String message) {
	super(message);
    }
}
