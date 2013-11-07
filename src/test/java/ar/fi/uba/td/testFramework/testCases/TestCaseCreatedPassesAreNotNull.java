package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;
import ar.fi.uba.td.testFramework.TestContext;

public class TestCaseCreatedPassesAreNotNull extends BaseTest {
	
	public TestCaseCreatedPassesAreNotNull(String nameTest) {
		super(nameTest);
	}

	BackstagePasses somePasses;
	
	public void setUp(TestContext context){
		somePasses = new BackstagePasses("someConcert", 1, 2);
	}
	
	
	@Override
	public void runTest(TestContext context) throws TestFailedException {
		
		assertNotNull(somePasses, 
				"Tests that an initialized Backstage Passes instance isn't null.");
	}

}
