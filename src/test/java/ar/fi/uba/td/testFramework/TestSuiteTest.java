package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestSuiteTest {

	@Test
	public void testEmptyTestSuiteTotalTest() {
		RunnableTest emptyTestSuite = new TestSuite("emptyTestSuite");
		TestResults testResult = new TestResults();
		emptyTestSuite.run(testResult);
		assertTrue(testResult.getNumberOfTotalTest() == 0);
	}
	
	@Test
	public void testEmptyTestSuitePassedTest() {
		RunnableTest emptyTestSuite = new TestSuite("emptyTestSuite");
		TestResults testResult = new TestResults();
		emptyTestSuite.run(testResult);
		assertTrue(testResult.getNumberOfPassedTests() == 0);
	}
	
	@Test
	public void testTestSuitePassedTest() {
		RunnableTest testSuite = new TestSuite("testSuite ");
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCaseAreNotTheSame");
		TestResults testResult = new TestResults();
		
		testSuite.add(passesForDifferentConcertsAreNotEqual);
		testSuite.run(testResult);
		assertTrue(testResult.getNumberOfPassedTests() == 1);
	}

	@Test
	public void testTestSuiteCountTest() {
		RunnableTest mainTestSuite = new TestSuite("mainTestSuite");
		RunnableTest testSuite1 = new TestSuite("testSuite1");
		RunnableTest testSuite2 = new TestSuite("testSuite2");
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCaseAreNotTheSame");
		RunnableTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		
		testSuite1.add(passesForDifferentConcertsAreNotEqual);
		testSuite2.add(createdPassesAreNotNull);
		mainTestSuite.add(testSuite1);
		mainTestSuite.add(testSuite2);
			
		assertTrue(mainTestSuite.countTest() == 2);
	}
	
}
