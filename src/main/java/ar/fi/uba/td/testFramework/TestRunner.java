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

		TestOutput testOutput = new TestOutput();
		test.run(testOutput);

		Output output = new Output(testOutput);
		output.showResult();
	}
}
