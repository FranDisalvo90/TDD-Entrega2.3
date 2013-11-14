package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.Assert;
import ar.fi.uba.td.testFramework.TestCase;
import ar.fi.uba.td.testFramework.TestContext;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase15 extends TestCase {
    int time;

    public TestCase15(String nameTest) {
	super(nameTest);
	if (nameTest == "SLEEP1") {
	    this.time = 1000;
	} else if (nameTest == "SLEEP5") {
	    this.time = 5000;
	} else {
	    this.time = 0;
	}
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	try {
	    Thread.sleep(this.time);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	MockClass mock = (MockClass) context.getElement("mockA");
	Assert.assertEquals(mock.getText(), "Using TestSuiteA context!",
		"Passing test");
    }

}
