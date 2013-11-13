package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {
	RunnableTest test;
	TestInformation information;
	TestLogger logger;

	public TestRunner(RunnableTest test) {
		this.test = test;
	}

	public void runTests() {
		information = new TestInformation();
		run();
	}

	public void runTests(String regExpression) {
		information = new TestInformation();
		information.setRegExp(regExpression);
		run();
	}

	public void runTests(ArrayList<String> tags) {
		information = new TestInformation();
		information.setTags(tags);
		run();
	}

	public void runTests(String regExpression, ArrayList<String> tags) {
		information = new TestInformation();
		information.setTags(tags);
		information.setRegExp(regExpression);
		run();
	}

	private void run() {
		test.run(information);
		TestLogger logger = information.getLogger();
		logger.startTestOutput(information);
		information.getResults().setNumberOfTotalTest(test.getTestCount(information));
		logger.endTestOutput(information.getResults());
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
