package ar.fi.uba.td.testFramework;

/**
 * Interface shared by the BaseTest and the TestSuite to run the tests. This
 * interface works as the component on the composite pattern.
 */
public interface RunnableTest extends Comparable<RunnableTest> {

	public void run(TestInformation information, Store store);
	
	public int getTestCount();

	public String getName();
	
	public String getStatus();

	public long getTime();

}
