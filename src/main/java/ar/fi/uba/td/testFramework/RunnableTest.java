package ar.fi.uba.td.testFramework;

/**
 * Interface shared by the BaseTest and the TestSuite to run the tests.
 * This interface works as the component on the composite pattern. 
 */
public interface RunnableTest {

	public void run();

	//public void add(RunnableTest test);
	
	//public void setUp();
	
	//public void tearDown();
	
	public int countTest();
	
	public String getName();

	public void checkOutput(TestSuite testSuite);
	
	//public boolean regularExpressionMatches(String regExpression);

}
