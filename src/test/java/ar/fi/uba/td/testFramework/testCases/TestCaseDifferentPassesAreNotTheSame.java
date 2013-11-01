package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.BackstagePasses;
import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCaseDifferentPassesAreNotTheSame extends BaseTest{

	public TestCaseDifferentPassesAreNotTheSame(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest() throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		BackstagePasses someMorePasses = new BackstagePasses("someConcert", 1, 3);
		assertNotSame(somePasses, someMorePasses, 
				"Tests that two different Backstage Passes instances aren't the same even if they are for the same concert.");		
	}

}
