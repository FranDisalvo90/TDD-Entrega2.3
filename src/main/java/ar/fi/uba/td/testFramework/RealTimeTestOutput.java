package ar.fi.uba.td.testFramework;

public class RealTimeTestOutput implements TestOutput {

	public void addTestSuiteName(String testSuiteName) {
		System.out.println("\n Running " + testSuiteName);
		System.out.println("-----------------------------");
	}

	public void addTestCaseResult(String testName, TestStatus testStatus, long runTime) {
		System.out.println(testStatus.toString() + " " + testName + " time: " + String.valueOf(runTime) + " ns.");
	}

	public void startTestOutput() { }

	public void endTestOutput(TestResults testResults) { }

}
