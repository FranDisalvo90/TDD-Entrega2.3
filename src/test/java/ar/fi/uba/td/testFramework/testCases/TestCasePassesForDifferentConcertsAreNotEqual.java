package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.BackstagePasses;
import ar.fi.uba.td.testFramework.TestCase;
import ar.fi.uba.td.testFramework.TestFailedException;
import ar.fi.uba.td.testFramework.TestContext;

public class TestCasePassesForDifferentConcertsAreNotEqual extends TestCase {

	public TestCasePassesForDifferentConcertsAreNotEqual(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest(TestContext context) throws TestFailedException {
		BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
		BackstagePasses someOtherPasses = new BackstagePasses(
				"someOtherConcert", 1, 2);
		this.assertNotEquals(
				somePasses,
				someOtherPasses,
				"Tests that two created Backstage Passes are not equal if their concert names are different.");
	}

}
