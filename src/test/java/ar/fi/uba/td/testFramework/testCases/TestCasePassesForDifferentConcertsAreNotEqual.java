package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;

public class TestCasePassesForDifferentConcertsAreNotEqual extends TestCase {

    public TestCasePassesForDifferentConcertsAreNotEqual(String nameTest) {
	super(nameTest);
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses someOtherPasses = new BackstagePasses(
		"someOtherConcert", 1, 2);
	Assert.assertNotEquals(
		somePasses,
		someOtherPasses,
		"Tests that two created Backstage Passes are not equal if their concert names are different.");
    }

}
