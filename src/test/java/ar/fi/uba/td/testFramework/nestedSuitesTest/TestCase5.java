package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestContext;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase5 extends BaseTest {

	public TestCase5(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest(TestContext context) throws TestFailedException {
		assertTrue(true, "Passing test");
	}


}
