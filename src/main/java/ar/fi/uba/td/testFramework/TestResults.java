package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class used to store test results.
 */
public class TestResults {

	private int numberOfPassedTests;
	private int numberOfFailedTests;
	private int numberOfTotalTests;
	private int numberOfErrorTests;
	private ArrayList<String> passedTestsNames;
	private ArrayList<String> failedTestsNames;
	private ArrayList<String> errorTestsNames;

	TestResults() {
		numberOfPassedTests = 0;
		numberOfFailedTests = 0;
		numberOfErrorTests = 0;
		numberOfTotalTests = 0;
		failedTestsNames = new ArrayList<String>();
		passedTestsNames = new ArrayList<String>();
		errorTestsNames = new ArrayList<String>();
	}

	public void addPassedTest(String message) {
		numberOfPassedTests++;
		passedTestsNames.add(message);
	}

	public void addFailedTest(String message) {
		numberOfFailedTests++;
		failedTestsNames.add(message);
	}
	
	public void addErrorTest(String message){
		numberOfErrorTests++;
		errorTestsNames.add(message);
	}

	public void setNumberOfTotalTest(int numberOfTotalTests) {
		this.numberOfTotalTests = numberOfTotalTests;
	}

	public int getNumberOfPassedTests() {
		return numberOfPassedTests;
	}

	public int getNumberOfFailedTests() {
		return numberOfFailedTests;
	}

	public int getNumberOfErrorTests() {
		return numberOfErrorTests;
	}
	
	public int getNumberOfTotalTest() {
		return numberOfTotalTests;
	}

	public ArrayList<String> getFailedTestsMessages() {
		return failedTestsNames;
	}
}
