package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.nestedSuitesTest.TestCase15;
import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestBaseTest {

	@Test
	public void testBaseTestRunFailed() {
		TestCase identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed(
				"TestCasePassesAreTheSameFailed");
		TestInformation testInfo = new TestInformation();
		identicalPassesAreTheSame.run(testInfo);

		assertEquals(testInfo.getResults().getNumberOfFailedTests(), 1);
	}

	@Test
	public void testBaseTestRunFPassed() {
		TestCase passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual(
				"TestCasePassesAreNotEqual");
		TestInformation testInfo = new TestInformation();
		passesForDifferentConcertsAreNotEqual.run(testInfo);

		assertTrue(testInfo.getResults().getNumberOfPassedTests() == 1);
	}
	
	@Test
	public void testBaseTestRunTimeFast() {
		TestCase fastTest = new TestCase15("SLEEP1");
		TestInformation testInfo = new TestInformation();
		fastTest.run(testInfo);
		
		assertTrue((fastTest.getTime()/1000000) < 1050);
	}
	
	@Test
	public void testBaseTestRunTimeSlow() {
		TestCase fastTest = new TestCase15("SLEEP5");
		TestInformation testInfo = new TestInformation();
		fastTest.run(testInfo);
		
		assertTrue((fastTest.getTime()/1000000) > 5000);
	}
	
	@Test
	public void testBaseTestRunTime() {
		TestCase fastTest = new TestCase15("OTHERNAME");
		TestInformation testInfo = new TestInformation();
		fastTest.run(testInfo);
		
		assertTrue((fastTest.getTime()/1000000) < 1000);
	}

}
