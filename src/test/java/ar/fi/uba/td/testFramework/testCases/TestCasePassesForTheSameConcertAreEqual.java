package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.BackstagePasses;
import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCasePassesForTheSameConcertAreEqual extends BaseTest {

	@Override
	public void runTest() throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		BackstagePasses someMorePasses = new BackstagePasses("someConcert", 1, 3);
		assertEquals(somePasses, someMorePasses, 
				"Tests that two created Backstage Passes are equal when their concert names are equal.");		
	}

}
