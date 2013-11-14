package ar.fi.uba.td.testFramework.output;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.fi.uba.td.testFramework.TestInformation;
import ar.fi.uba.td.testFramework.TestResults;
import ar.fi.uba.td.testFramework.TestStatus;

/**
 * Abstract class that shows the tests's results.
 */

public abstract class TestOutput {

    public void startTestOutput(TestInformation testInformation) {
    }

    public abstract void startTestSuiteOutput(String testName,
	    String testSuiteName);

    public void endTestSuiteOutput() {
    }

    public void startTestCaseOutput(String testName) {
    }

    public abstract void endTestCaseOutput(String testName,
	    TestStatus testStatus, long runTime);

    public void endTestOutput(TestResults testResults) {
    }

    protected String getFileName() {
	return "Report-" + getCurrentTimeFormattedToFileName();
    }

    private String getCurrentTimeFormattedToFileName() {
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
	Date date = new Date();
	return dateFormat.format(date);
    }

}
