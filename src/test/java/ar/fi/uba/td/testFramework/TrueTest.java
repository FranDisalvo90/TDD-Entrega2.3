package ar.fi.uba.td.testFramework;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TrueTest extends BaseTest {

	@Override
	public void runTest() throws TestFailedException {
		this.assertTrue(true, "Testing assertTrue: ok result");
	}

}
