package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;

public class TestCaseDifferentPassesAreNotTheSame extends TestCase {

    public TestCaseDifferentPassesAreNotTheSame(String nameTest) {
	super(nameTest);
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses someMorePasses = new BackstagePasses("someConcert", 1,
		3);
	Assert.assertNotSame(
		somePasses,
		someMorePasses,
		"Tests that two different Backstage Passes instances aren't the same even if they are for the same concert.");
    }

}
