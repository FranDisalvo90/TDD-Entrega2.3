package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

import ar.fi.uba.td.testFramework.output.TestLogger;

/**
 * Class used to run RunnableTests.
 */
public class TestRunner {
	
    TestInformation information;
    RunnableTest test;
    Store store;
	    
    public TestRunner(RunnableTest test, Store store) {
    	this.test = test;
    	this.store = store;
    }

    public TestResults getResult() throws Exception {
		TestResults results = information.getResults();
		if (results != null) {
		    return results;
		} else {
		    throw new Exception("No tests run.");
		}
    }

    private void run(boolean searchOnStored) {
    	if (searchOnStored)
    		store.active();
    	else
    		store.desactive();
    		
		TestLogger logger = information.getLogger();
		logger.startTestOutput(information);
		test.run(information,store);
		logger.endTestOutput(information.getResults());
		information.getResults().addTotalTest(test.getTestCount());	
    }
    
    public void runTests(boolean searchOnStored) {
		information = new TestInformation();
		run(searchOnStored);
    }

    public void runTests(ArrayList<String> tags,boolean searchOnStored) {
		information = new TestInformation();
		information.setTags(tags);
		run(searchOnStored);
    }

    public void runTests(String regExpression,boolean searchOnStored) {
		information = new TestInformation();
		information.setRegExp(regExpression);
		run(searchOnStored);
    }

    public void runTests(String regExpression, ArrayList<String> tags,boolean searchOnStored) {
		information = new TestInformation();
		information.setTags(tags);
		information.setRegExp(regExpression);
		run(searchOnStored);
    }
    
}
