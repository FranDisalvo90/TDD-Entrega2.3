package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestContext;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase3 extends BaseTest {

	public TestCase3(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest(TestContext context) throws TestFailedException {
	    	MockClass mock = (MockClass)context.getElement("mockA");
	    	assertEquals(mock.getText(),"Using TestSuiteA context!", "Passing test");
	}

}
