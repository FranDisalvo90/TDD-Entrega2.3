package ar.fi.uba.td.testFramework;

/**
 * Class used to store test results.
 */
public class TestResults {

	private int numberOfPassedTests;
	private int numberOfFailedTests;
	private int numberOfTotalTests;
	private int numberOfErrorTests;
	private int numberOfTestsToRun;
	
	TestResults() {
		numberOfPassedTests = 0;
		numberOfFailedTests = 0;
		numberOfErrorTests = 0;
	}

	public int getNumberOfTestsToRun() {
		return numberOfTestsToRun;
	}

	public void setNumberOfTestsToRun(int numberOfTestsToRun) {
		this.numberOfTestsToRun = numberOfTestsToRun;
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
		return numberOfPassedTests + numberOfFailedTests + numberOfErrorTests;
	}

}
