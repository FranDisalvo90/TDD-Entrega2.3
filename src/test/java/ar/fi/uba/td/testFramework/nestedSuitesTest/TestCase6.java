package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.*;

public class TestCase6 extends TestCase {

    public TestCase6(String nameTest) {
	super(nameTest);
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	Assert.assertTrue(true, "Passing test");
    }

}
