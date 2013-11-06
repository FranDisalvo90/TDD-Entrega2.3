package ar.fi.uba.td.testFramework;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {

	TestSuite test;
	Output testOutput;
//	String regExpression;
	
	public TestRunner(TestSuite test) {
		this.test = test;
//		regExpression= ".*";
	}

	public void runTests() {
		test.run();
		//testOutput.setNumberOfTotalTest(test.countTest());
		testOutput = this.test.GetOutput();
		//TestOutput output = new TestOutput(testOutput);
		testOutput.showResults("Main");
	}

	public Output getResult() throws Exception {
		if (testOutput != null) {
			return testOutput;
		} else {
			throw new Exception("No tests run.");
		}
	}
}

