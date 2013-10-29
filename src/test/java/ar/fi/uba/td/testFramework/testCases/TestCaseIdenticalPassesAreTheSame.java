package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.BackstagePasses;
import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCaseIdenticalPassesAreTheSame extends BaseTest {

	@Override
	public void runTest() throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		assertSame(somePasses, somePasses);
	}

}
