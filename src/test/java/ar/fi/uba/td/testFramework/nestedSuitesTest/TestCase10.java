package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.*;

public class TestCase10 extends TestCase {

    public TestCase10(String nameTest) {
	super(nameTest);
    }

    public void setUp(TestContext context) {

	MockClass mock = new MockClass("TestCase10");
	context.addElement("mockTestCase10", mock);

    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	MockClass mock = (MockClass) context.getElement("mockTestCase10");
	Assert.assertEquals(mock.getText(), "TestCase10", "Passing test");
    }

}
