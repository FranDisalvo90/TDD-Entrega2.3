package ar.fi.uba.td.testFramework;

public interface TestOutput {
	
	void startTestOutput();
	
	void addTestSuiteName(String name);
	
	void addTestCaseResult(String testName, TestStatus testStatus, long runTime);
	
	void endTestOutput(TestResults testResults);

}
