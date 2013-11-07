package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase10 extends BaseTest {

	public TestCase10(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest() throws TestFailedException {
		assertTrue(true, "Passing test");
	}

}
