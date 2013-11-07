package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase11 extends BaseTest {

	public TestCase11(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest() throws TestFailedException {
		assertTrue(true, "Passing test");
	}

}
