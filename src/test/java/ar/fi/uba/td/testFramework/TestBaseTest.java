package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestBaseTest {

	@Test
	public void testBaseTestRunFailed() {
		RunnableTest identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCasePassesAreTheSameFailed");
		TestResults testResult = new TestResults();
//		identicalPassesAreTheSame.run(testResult);
		
//		assertTrue(testResult.getNumberOfFailedTests() == 1);
	}
	
	@Test
	public void testBaseTestRunFPassed() {
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCasePassesAreNotEqual");
		TestResults testResult = new TestResults();
//		passesForDifferentConcertsAreNotEqual.run(testResult);
		
//		assertTrue(testResult.getNumberOfPassedTests() == 1);
	}

}
