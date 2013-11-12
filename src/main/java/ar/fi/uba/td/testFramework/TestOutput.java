package ar.fi.uba.td.testFramework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestOutput {
	
	void startTestOutput(TestInformation testInformation) { };
		
	abstract void startTestSuiteOutput(String testSuiteName);
	
	void endTestSuiteOutput() { };
	
	void startTestCaseOutput(String testName) { };
	
	abstract void endTestCaseOutput(String testName, TestStatus testStatus, long runTime);
	
	void endTestOutput(TestResults testResults) { }
	
	protected String getFileName() {
		return "Report-" + getCurrentTime();
	}
	
	private String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}


}
