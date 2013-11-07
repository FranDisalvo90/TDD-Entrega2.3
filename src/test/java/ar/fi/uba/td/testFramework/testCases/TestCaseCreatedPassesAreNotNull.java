package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;

public class TestCaseCreatedPassesAreNotNull extends BaseTest {
	
	public TestCaseCreatedPassesAreNotNull(String nameTest) {
		super(nameTest);
	}

	BackstagePasses somePasses;
	
	public void setUp(){
		somePasses = new BackstagePasses("someConcert", 1, 2);
	}
	
	
	@Override
	public void runTest() throws TestFailedException {
		
		assertNotNull(somePasses, 
				"Tests that an initialized Backstage Passes instance isn't null.");
	}

}
