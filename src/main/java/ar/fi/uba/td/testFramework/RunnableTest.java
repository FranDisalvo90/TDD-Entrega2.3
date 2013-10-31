package ar.fi.uba.td.testFramework;

/**
 * Interface shared by the BaseTest and the TestSuite to run the tests.
 * This interface works as the component on the composite pattern. 
 */
public interface RunnableTest {

	/**
	 * Runs a test or a series of tests storing the results in the TestOutput.
	 */
	public void run(TestResults testOutput);

	public void add(RunnableTest test);

}
