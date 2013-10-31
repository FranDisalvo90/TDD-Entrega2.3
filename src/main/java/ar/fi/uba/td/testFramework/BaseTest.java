package ar.fi.uba.td.testFramework;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class BaseTest extends Comparator implements RunnableTest {

	/**
	 * Abstract class where the user will define the actual test.
	 */
	public abstract void runTest() throws TestFailedException;

	/*
	 * (non-Javadoc)
	 * @see ar.fi.uba.td.testFramework.RunnableTest#add(ar.fi.uba.td.testFramework.RunnableTest) 
	 * Leaf node, unimplemented.
	 */
	public void add(RunnableTest test) {
	}

	public void run(TestOutput testOutput) {
		try {
			this.runTest();
			testOutput.testOK();
		} catch (Exception ex) {
			testOutput.testError(ex.getMessage());
		}
	}
}
