package ar.fi.uba.td.testFramework.output;

import java.util.Arrays;
import java.util.List;

import ar.fi.uba.td.testFramework.TestInformation;
import ar.fi.uba.td.testFramework.TestResults;
import ar.fi.uba.td.testFramework.TestStatus;

public class TestLogger {

	private List<TestOutput> testOutputs;

	public TestLogger() {
		testOutputs = Arrays.asList(new FileTestOutput(),
				new RealTimeTestOutput(), new XMLOutput());
	}

	public void startTestOutput(TestInformation testInformation) {
		for (TestOutput testOutput : this.testOutputs)
			testOutput.startTestOutput(testInformation);
	}

	public void startTestSuiteOutput(String testName, String testSuiteName) {
		for (TestOutput testOutput : this.testOutputs)
			testOutput.startTestSuiteOutput(testName, testSuiteName);
	}

	public void endTestSuiteOutput() {
		for (TestOutput testOutput : this.testOutputs)
			testOutput.endTestSuiteOutput();
	}

	public void startTestCaseOutput(String testName) {
		for (TestOutput testOutput : this.testOutputs)
			testOutput.startTestCaseOutput(testName);
	}

	public void endTestCaseOutput(String testName, TestStatus testStatus,
			long runTime) {
		for (TestOutput testOutput : this.testOutputs)
			testOutput.endTestCaseOutput(testName, testStatus, runTime);
	}

	public void endTestOutput(TestResults testResults) {
		for (TestOutput testOutput : this.testOutputs)
			testOutput.endTestOutput(testResults);
	}

}
