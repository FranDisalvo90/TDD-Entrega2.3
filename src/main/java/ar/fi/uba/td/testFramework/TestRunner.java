package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

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

	public void runTests(String regExpression) {
		information = new TestInformation();
		information.setRegExp(regExpression);
		run(information);
	}

	public void runTests(ArrayList<String> tags) {
		information = new TestInformation();
		information.setTags(tags);
		run(information);
	}

	public void runTests(String regExpression, ArrayList<String> tags) {
		information = new TestInformation();
		information.setTags(tags);
		information.setRegExp(regExpression);
		run(information);
	}

	private void run(TestInformation information) {
		test.run(information);
		information.getResults().setNumberOfTotalTest(test.getTestCount(information));
		information.getResults().endTestRun();
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
