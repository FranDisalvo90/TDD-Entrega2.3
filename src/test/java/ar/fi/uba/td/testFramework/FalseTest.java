package ar.fi.uba.td.testFramework;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class FalseTest extends BaseTest {

	@Override
	public void runTest() throws TestFailedException {

		this.assertTrue(false, "Testing assertTrue: fail result ");

	}

}
