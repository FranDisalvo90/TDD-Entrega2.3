package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestBaseTest {

	@Test
	public void testBaseTestRunFailed() {
		BaseTest identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCasePassesAreTheSameFailed");
		TestInformation testInfo = new TestInformation();
		identicalPassesAreTheSame.run(testInfo);
		
		assertEquals(testInfo.getResults().getNumberOfFailedTests(), 1);
	}
	
	@Test
	public void testBaseTestRunFPassed() {
		BaseTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCasePassesAreNotEqual");
		TestInformation testInfo = new TestInformation();
		passesForDifferentConcertsAreNotEqual.run(testInfo);
		
		assertTrue(testInfo.getResults().getNumberOfPassedTests() == 1);
	}

}
