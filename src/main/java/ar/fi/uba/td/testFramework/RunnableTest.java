package ar.fi.uba.td.testFramework;

/**
 * Interface shared by the BaseTest and the TestSuite to run the tests.
 * This interface works as the component on the composite pattern. 
 */
public interface RunnableTest extends Comparable<RunnableTest>{

	public void run(TestInformation information);

//	public void setUp();
	
//	public void tearDown();
	
	public int countTest();
	
	public String getName();
	
}
