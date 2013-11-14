package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.*;

public class TestCase9 extends TestCase {

    public TestCase9(String nameTest) {
	super(nameTest);
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	Assert.assertTrue(true, "Passing test");
    }

}
