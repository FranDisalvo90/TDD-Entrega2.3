package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class used to display the test results.
 */
public class TestOutput {

	private TestResults testResults;

	public TestOutput(TestResults testResults) {
		this.testResults = testResults;
	}

	public void showResults() {
		System.out.println("Total tests: ....");
		System.out.println("Tests OK: " + testResults.getNumberOfPassedTests());
		System.out.println("Tests failed: "
				+ testResults.getNumberOfFailedTests());
		System.out.println("Failure messages: ");
		
		ArrayList<String> failedTestsMessages = testResults.getFailedTestsMessages();
		
		for(String failedTestMessage : failedTestsMessages)
			System.out.println(failedTestMessage);
	}

}
