package ar.fi.uba.td.testFramework;

/**
 * Class used to store test results.
 */
public class TestResults {

	private int numberOfPassedTests;
	private int numberOfFailedTests;
	private int numberOfErrorTests;
	private int numberOfSkippedTests;
	
	TestResults() {
		numberOfPassedTests = 0;
		numberOfFailedTests = 0;
		numberOfErrorTests = 0;
		numberOfSkippedTests = 0;
	}

	public void addPassedTest() {
		numberOfPassedTests++;
	}

	public void addFailedTest() {
		numberOfFailedTests++;
	}

	public void addErrorTest() {
		numberOfErrorTests++;
	}
	
	public void addSkippedTest() {
		numberOfSkippedTests++;
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
	
	public int getNumberOfSkippedTests() {
		return numberOfSkippedTests;
	}
	
	public int getNumberOfTestRun() {
		return numberOfPassedTests + numberOfFailedTests + numberOfErrorTests;
	}

	public int getNumberOfTotalTest() {
		return numberOfPassedTests + numberOfFailedTests + numberOfErrorTests + numberOfSkippedTests;
	}

}
