package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class used to store test results.
 */
public class TestResults {

	private int numberOfPassedTests;
	private int numberOfFailedTests;
	private ArrayList<String> failedTestsMessages;

	TestResults() {
		numberOfPassedTests = 0;
		numberOfFailedTests = 0;
		failedTestsMessages = new ArrayList<String>();
	}

	public void addPassedTest() {
		numberOfPassedTests++;
	}

	public void addFailedTest(String message) {
		numberOfFailedTests++;
		failedTestsMessages.add(message);
	}

	public int getNumberOfPassedTests() {
		return numberOfPassedTests;
	}

	public int getNumberOfFailedTests() {
		return numberOfFailedTests;
	}

	public ArrayList<String> getFailedTestsMessages() {
		return failedTestsMessages;
	}
}
