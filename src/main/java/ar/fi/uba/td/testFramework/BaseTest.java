package ar.fi.uba.td.testFramework;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class BaseTest extends Comparator implements RunnableTest {
	private static String regex = "test";
	
	public static void SetRegex(String regex) {
		BaseTest.regex = regex;
	}
		
	String nameTest;
	
	public BaseTest(String nameTest){
		this.nameTest = nameTest;
	}
		
	/**
	 * Abstract method where the user will define the actual test.
	 */
	public abstract void runTest() throws TestFailedException;
	
	private boolean regularExpressionMatches(){
	    return this.nameTest.matches(regex);
	}

	public void run(TestResults testOutput) { 
		if (this.regularExpressionMatches()){
			this.setUp();
			try {
				this.runTest();
				testOutput.addPassedTest(this.nameTest);
			} catch (TestFailedException ex) {
				testOutput.addFailedTest(ex.getMessage());
			}catch (Exception ex) {
				testOutput.addErrorTest(ex.getMessage());
			}
			this.tearDown();
		}
	}

	public int countTest() {
	    	if (this.regularExpressionMatches())
	    	    return 1;
	    	return 0;
	}
	
	public String getName(){
		return this.nameTest;
	}
	
	public void setUp(){}
	
	public void tearDown(){}
	
	public void add(RunnableTest test) {}
}
