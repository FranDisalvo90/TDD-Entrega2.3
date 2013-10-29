package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.BackstagePasses;
import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCasePassesForDifferentConcertsAreNotEqual extends BaseTest {

	@Override
	public void runTest() throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		BackstagePasses someOtherPasses = new BackstagePasses("someOtherConcert", 1, 2);
		this.assertNotEquals(somePasses, someOtherPasses, 
				"Tests that two created Backstage Passes are not equal if their concert names are different.");		
	}

}
