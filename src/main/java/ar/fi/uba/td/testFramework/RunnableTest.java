package ar.fi.uba.td.testFramework;

/**
 * Interface shared by the BaseTest and the TestSuite to run the tests. This
 * interface works as the component on the composite pattern.
 */
public interface RunnableTest extends Comparable<RunnableTest> {

	public void run(TestInformation information);

	public int getTestCount(TestInformation information);
	
	public int getTestCount();

	public String getName();

}
