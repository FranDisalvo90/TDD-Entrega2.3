package ar.fi.uba.td.testFramework;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {

	RunnableTest test;

	public TestRunner(RunnableTest test) {
		this.test = test;
	}

	public void runTests() {

		TestResults testOutput = new TestResults();
		test.run(testOutput);

		TestOutput output = new TestOutput(testOutput);
		output.showResults();
	}
}
