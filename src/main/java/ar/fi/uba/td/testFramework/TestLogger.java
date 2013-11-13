package ar.fi.uba.td.testFramework;

import java.util.Arrays;
import java.util.List;

public class TestLogger {

	private List<TestOutput> testOutputs;

	TestLogger() {
		testOutputs = Arrays.asList(new FileTestOutput(), new RealTimeTestOutput(), new XMLOutput());
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

	public void endTestOutput(TestResults testResults) {
		for(TestOutput testOutput : this.testOutputs)
			testOutput.endTestOutput(testResults);		
	}

}
