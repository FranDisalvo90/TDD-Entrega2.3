package ar.fi.uba.td.testFramework;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class BaseTest extends Comparator implements RunnableTest {

	String nameTest;
	
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
	public void add(RunnableTest test) {
	}

	public void run(TestResults testOutput) {
		this.setUp();
		try {
			this.runTest();
			testOutput.addPassedTest(this.nameTest);
		} catch (TestFailedException ex) {
			testOutput.addFailedTest(ex.getMessage());
		}catch (Exception ex) {
			testOutput.addErrorTest(ex.getMessage());
		}	
	}

	public int countTest() {
		return 1;
	}
	
	public String getName(){
		return nameTest;
	}
	
	public void setUp(){}
	
	public void tearDown(){}
}
