package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class used to store test results.
 */
public class TestResults {

	private int numberOfPassedTests;
	private int numberOfFailedTests;
	private int numberOfTotalTests;
	private ArrayList<String> failedTestsMessages;

	TestResults() {
		numberOfPassedTests = 0;
		numberOfFailedTests = 0;
		numberOfTotalTests = 0;
		failedTestsMessages = new ArrayList<String>();
	}

	public void addPassedTest() {
		numberOfPassedTests++;
	}

	public void addFailedTest(String message) {
		numberOfFailedTests++;
		failedTestsMessages.add(message);
	}
	
	public void setNumberOfTotalTest(int totalTest){
		numberOfTotalTests = totalTest;
	}

	public int getNumberOfPassedTests() {
		return numberOfPassedTests;
	}

	public int getNumberOfFailedTests() {
		return numberOfFailedTests;
	}
	
	public int getNumberOfTotalTest(){
		return numberOfTotalTests;
	}

	public ArrayList<String> getFailedTestsMessages() {
		return failedTestsMessages;
	}
}
