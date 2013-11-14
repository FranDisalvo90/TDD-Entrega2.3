package ar.fi.uba.td.testFramework.testCases;

import ar.fi.uba.td.testFramework.*;

public class TestCasePassesForTheSameConcertAreEqual extends TestCase {

    public TestCasePassesForTheSameConcertAreEqual(String nameTest) {
	super(nameTest);
    }

    @Override
    public void runTest(TestContext context) throws TestFailedException {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses someMorePasses = new BackstagePasses("someConcert", 1,
		3);
	Assert.assertEquals(
		somePasses,
		someMorePasses,
		"Tests that two created Backstage Passes are equal when their concert names are equal.");
    }

}
