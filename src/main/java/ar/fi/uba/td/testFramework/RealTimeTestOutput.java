package ar.fi.uba.td.testFramework;

public class RealTimeTestOutput extends TestOutput {

	@Override
	public void startTestSuiteOutput(String testSuiteName) {
		System.out.println("\n Running " + testSuiteName);
		System.out.println("-----------------------------");
	}

	@Override
	public void endTestCaseOutput(String testName, TestStatus testStatus, long runTime) {
		System.out.println(testStatus.toString() + " " + testName + " time: " + String.valueOf(runTime) + " ns.");
	}

}
