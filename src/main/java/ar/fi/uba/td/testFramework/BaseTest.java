package ar.fi.uba.td.testFramework;

public abstract class BaseTest extends Comparator implements RunnableTest {

	public abstract void runTest() throws TestFailedException;

	public void add(RunnableTest test) {
		// this is a leaf node
	}

	public void run(TestOutput testOutput) {
		try {
			this.runTest();
			testOutput.testOK();
		} catch (Exception ex) {
			// Any type of error
			testOutput.testError(ex.getMessage());
		}
	}
}
