package ar.fi.uba.td.testFramework;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class BaseTest extends Comparator implements RunnableTest {
	private static String regex;
	String nameTest;
	private Output myOutput;
	
	public BaseTest(String nameTest){
		this.nameTest = nameTest;
	}
	
	/**
	 * Abstract method where the user will define the actual test.
	 */
	public abstract void runTest() throws TestFailedException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.fi.uba.td.testFramework.RunnableTest#add(ar.fi.uba.td.testFramework.RunnableTest) 
	 * Leaf node, unimplemented.
	 */
	
	public static void SetRegex(String regex) {
		BaseTest.regex = regex;
	}
	
	private boolean regularExpressionMatches(){
	    return this.nameTest.matches(regex);
	}

	public void run() { 
		if (this.regularExpressionMatches()){
			this.setUp();
			try {
				this.runTest();
				this.myOutput.addPassedTest(this.nameTest);
			} catch (TestFailedException ex) {
				this.myOutput.addFailedTest(this.nameTest, ex.getMessage());
			}catch (Exception ex) {
				this.myOutput.addErrorTest(this.nameTest, ex.getMessage());
			}
			this.tearDown();
		}
	}

	public int countTest() {
		return 1;
	}
	
	public String getName(){
		return this.nameTest;
	}
	
	public void setUp(){}
	
	public void tearDown(){}
	
	public void checkOutput(TestSuite testSuite) {
		this.myOutput = testSuite.GetOutput();
	}
	
}
