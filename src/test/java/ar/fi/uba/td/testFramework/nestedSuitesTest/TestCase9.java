package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase9 extends BaseTest {

	public TestCase9(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest() throws TestFailedException {
		assertTrue(true, "Passing test");
	}

}
