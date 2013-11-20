package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestBaseTest {

    @Test
    public void testBaseTestRunFailed() {
	TestCase identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed(
		"TestCasePassesAreTheSameFailed");
	TestInformation testInfo = new TestInformation();
	RAMStore store = new RAMStore();
	identicalPassesAreTheSame.run(testInfo,store);

	assertEquals(testInfo.getResults().getNumberOfFailedTests(), 1);
    }

    @Test
    public void testBaseTestRunFPassed() {
	TestCase passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual(
		"TestCasePassesAreNotEqual");
	TestInformation testInfo = new TestInformation();
	RAMStore store = new RAMStore();
	passesForDifferentConcertsAreNotEqual.run(testInfo,store);

	assertTrue(testInfo.getResults().getNumberOfPassedTests() == 1);
    }

}
