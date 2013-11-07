package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestContext;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase2 extends BaseTest {

	public TestCase2(String nameTest) {
		super(nameTest);
	}
	
	public void setUp(TestContext context){
	    	MockClass mock = (MockClass)context.getElement("mockA");
	    	mock.setText("Change text");
	}

	@Override
	public void runTest(TestContext context) throws TestFailedException {
	    	MockClass mock = (MockClass)context.getElement("mockA");
	    	assertEquals(mock.getText(),"Change text", "Passing test");
	}

}
