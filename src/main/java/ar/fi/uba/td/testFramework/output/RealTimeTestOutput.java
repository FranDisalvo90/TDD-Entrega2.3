package ar.fi.uba.td.testFramework.output;

import ar.fi.uba.td.testFramework.TestStatus;

public class RealTimeTestOutput extends TestOutput {
	
	@Override
	public void startTestCaseOutput(String testName) { 
		System.out.print("Running: " + testName + "... ");		
	}
	
	@Override
	public void endTestCaseOutput(String testName, TestStatus testStatus, long runTime) {
		System.out.print(testStatus.toString() + " time: " + String.valueOf(runTime) + " ns. \n");
	}

	@Override
	public void startTestSuiteOutput(String testName, String testSuiteName) {
		System.out.println("\n Running " + testSuiteName);
		System.out.println("-----------------------------");
	}
	
	@Override
	public void endTestSuiteOutput() { 
		System.out.println("");
	}

}
