package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;

public class TestCaseNotIdenticalPassesAreTheSameFailed extends TestCase {

    public TestCaseNotIdenticalPassesAreTheSameFailed(String nameTest) {
	super(nameTest);
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses notPasses = new BackstagePasses("notConcert", 1, 2);
	Assert.assertSame(
		somePasses,
		notPasses,
		"Tests that an instance of a Backstage Passes is not the same when compared with other.");
    }

}
