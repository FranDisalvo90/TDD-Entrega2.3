package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;

public class TestCaseCreatedPassesAreNotNull extends BaseTest {

	@Override
	public void runTest() throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		assertNotNull(somePasses, 
				"Tests that an initialized Backstage Passes instance isn't null.");
	}

}
