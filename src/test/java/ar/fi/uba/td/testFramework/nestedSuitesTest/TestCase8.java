package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase8 extends BaseTest {

	public TestCase8(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest() throws TestFailedException {
		assertTrue(true, "Passing test");
	}

}
