package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestSuitTest {

	@Test
	public void testEmptyTestSuiteTotalTest() {
		RunnableTest emptyTestSuite = new TestSuite();
		TestResults testResult = new TestResults();
		emptyTestSuite.run(testResult);
		assertTrue(testResult.getNumberOfTotalTest() == 0);
	}
	
	@Test
	public void testEmptyTestSuitePassedTest() {
		RunnableTest emptyTestSuite = new TestSuite();
		TestResults testResult = new TestResults();
		emptyTestSuite.run(testResult);
		assertTrue(testResult.getNumberOfPassedTests() == 0);
	}
	
	@Test
	public void testTestSuitePassedTest() {
		RunnableTest testSuite = new TestSuite();
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual();
		TestResults testResult = new TestResults();
		
		testSuite.add(passesForDifferentConcertsAreNotEqual);
		testSuite.run(testResult);
		assertTrue(testResult.getNumberOfPassedTests() == 1);
	}

	@Test
	public void testTestSuiteCountTest() {
		RunnableTest mainTestSuite = new TestSuite();
		RunnableTest testSuite1 = new TestSuite();
		RunnableTest testSuite2 = new TestSuite();
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual();
		RunnableTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull();
		
		testSuite1.add(passesForDifferentConcertsAreNotEqual);
		testSuite2.add(createdPassesAreNotNull);
		mainTestSuite.add(testSuite1);
		mainTestSuite.add(testSuite2);
		
		
		assertTrue(mainTestSuite.countTest() == 2);
	}
	
	
	
}
