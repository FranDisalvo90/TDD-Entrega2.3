package ar.fi.uba.td.testFramework;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {

	RunnableTest test;
	TestInformation information;

	public TestRunner(RunnableTest test) {
		this.test = test;
	}
	
	public void runTests() {
		information = new TestInformation();
		run(information);
		
	}
	
	public void runTests(String regExpression){
	    	information = new TestInformation(regExpression);
	    	run(information);
	}

	private void run(TestInformation information){
	    	test.run(information);
		information.getResults().setNumberOfTotalTest(test.countTest());

		TestOutput output = new TestOutput(information.getResults());
		output.showTrace();
	}
	
	
	public TestResults getResult() throws Exception {
		TestResults results = information.getResults();
		if (results != null) {
			return results;
		} else {
			throw new Exception("No tests run.");
		}
	}
}
