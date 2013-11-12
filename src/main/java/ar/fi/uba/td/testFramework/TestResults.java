package ar.fi.uba.td.testFramework;

import java.util.Arrays;
import java.util.List;

/**
 * Class used to store test results.
 */
public class TestResults {

	private int numberOfPassedTests;
	private int numberOfFailedTests;
	private int numberOfTotalTests;
	private int numberOfErrorTests;
	private int numberOfTestsToRun;
	
	private List<TestOutput> testOutputs;
	
	TestResults() {
		testOutputs = Arrays.asList(new FileTestOutput(), new RealTimeTestOutput(), new XMLOutput());
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
	
	public void startTestOutput(TestInformation testInformation) { 
		for(TestOutput testOutput : this.testOutputs)
			testOutput.startTestOutput(testInformation);
	}
	
	public void startTestSuiteOutput(String testSuiteName) {
		for(TestOutput testOutput : this.testOutputs)
			testOutput.startTestSuiteOutput(testSuiteName);
	}
	
	public void endTestSuiteOutput() { 
		for(TestOutput testOutput : this.testOutputs)
			testOutput.endTestSuiteOutput();		
	}
	
	public void startTestCaseOutput(String testName) { 
		for(TestOutput testOutput : this.testOutputs)
			testOutput.startTestCaseOutput(testName);		
	}	
	
	public void endTestCaseOutput(String testName, TestStatus testStatus, long runTime) {
		for(TestOutput testOutput : this.testOutputs)
			testOutput.endTestCaseOutput(testName, testStatus, runTime);
	}

	public void endTestOutput() {
		for(TestOutput testOutput : this.testOutputs)
			testOutput.endTestOutput(this);		
	}
}
