package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.BackstagePasses;
import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;
import ar.fi.uba.td.testFramework.TestContext;

public class TestCaseNotIdenticalPassesAreTheSameFailed extends BaseTest {

	public TestCaseNotIdenticalPassesAreTheSameFailed(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest(TestContext context) throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		BackstagePasses notPasses = new BackstagePasses("notConcert", 1, 2);
		assertSame(somePasses, notPasses, 
				"Tests that an instance of a Backstage Passes is not the same when compared with other.");
	}

}
