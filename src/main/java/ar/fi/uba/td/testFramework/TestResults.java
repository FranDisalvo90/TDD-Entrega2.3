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
	
	private ArrayList<String> output;

	TestResults() {
		numberOfPassedTests = 0;
		numberOfFailedTests = 0;
		numberOfErrorTests = 0;
		numberOfTotalTests = 0;
		output = new ArrayList<String>();
	}

	public void addPassedTest() {
		numberOfPassedTests++;
	}

	public void addFailedTest() {
		numberOfFailedTests++;
	}
	
	public void addErrorTest(){
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
		return numberOfTotalTests;
	}

	public void addToOutputTestSuite(String string) {
	    	this.output.add("\n");
	    	this.output.add(string);
	    	this.output.add("-----------------------------");
	    	
	}
	
	public void addToOutput(String string) {
		this.output.add(string);
	}
	
	public ArrayList<String> getOutput() {
		return this.output;
	}
}
