package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

import ar.fi.uba.td.testFramework.output.TestLogger;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {
    TestInformation information;
    RunnableTest test;
    
    public TestRunner(RunnableTest test) {
	this.test = test;
    }

    public TestResults getResult() throws Exception {
	TestResults results = information.getResults();
	if (results != null) {
	    return results;
	} else {
	    throw new Exception("No tests run.");
	}
    }

    private void run(boolean runOnlyFailures) {
		if (testShouldRun(runOnlyFailures, test.getStatus())) {
			TestLogger logger = information.getLogger();
			logger.startTestOutput(information);
			test.run(information);
			logger.endTestOutput(information.getResults());
			information.getResults().addTotalTest(test.getTestCount());
		}
    }

    public void runTests(boolean runFailures) {
	information = new TestInformation();
	run(runFailures);
    }

    public void runTests(ArrayList<String> tags, boolean runFailures) {
	information = new TestInformation();
	information.setTags(tags);
	run(runFailures);
    }

    public void runTests(String regExpression, boolean runFailures) {
	information = new TestInformation();
	information.setRegExp(regExpression);
	run(runFailures);
    }

    public void runTests(String regExpression, ArrayList<String> tags, boolean runFailures) {
	information = new TestInformation();
	information.setTags(tags);
	information.setRegExp(regExpression);
	run(runFailures);
    }
    
    private boolean testShouldRun(boolean runFailures, String status){
    	return (runFailures && status != "OK") || runFailures == false;
    }
    
}
