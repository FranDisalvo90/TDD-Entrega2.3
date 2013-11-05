package ar.fi.uba.td.testFramework;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {

	RunnableTest test;
	TestResults testOutput;
//	String regExpression;
	
	public TestRunner(RunnableTest test) {
		this.test = test;
//		regExpression= ".*";
	}

	public void runTests() {

		testOutput = new TestResults();
		test.run(testOutput);
		testOutput.setNumberOfTotalTest(test.countTest());

		TestOutput output = new TestOutput(testOutput);
		output.showResults();
	}

	public TestResults getResult() throws Exception {
		if (testOutput != null) {
			return testOutput;
		} else {
			throw new Exception("No tests run.");
		}
	}
}
