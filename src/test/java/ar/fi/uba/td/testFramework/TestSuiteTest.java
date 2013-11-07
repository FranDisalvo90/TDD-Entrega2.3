package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestSuiteTest {

	@Test
	public void testEmptyTestSuiteTotalTest() {
		TestSuite emptyTestSuite = new TestSuite("emptyTestSuite");
		TestInformation testInfo = new TestInformation();
		emptyTestSuite.run(testInfo);
		assertTrue(testInfo.getResults().getNumberOfTotalTest() == 0);
	}
	
	@Test
	public void testEmptyTestSuitePassedTest() {
		TestSuite emptyTestSuite = new TestSuite("emptyTestSuite");
		TestInformation testInfo = new TestInformation();
		emptyTestSuite.run(testInfo);
		assertTrue(testInfo.getResults().getNumberOfPassedTests() == 0);
	}
	
	@Test
	public void testTestSuitePassedTest() {
		TestSuite testSuite = new TestSuite("testSuite ");
		BaseTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCaseAreNotTheSame");
		TestInformation testInfo = new TestInformation();
		
		testSuite.add(passesForDifferentConcertsAreNotEqual);
		testSuite.run(testInfo);
		assertTrue(testInfo.getResults().getNumberOfPassedTests() == 1);
	}

	@Test
	public void testTestSuiteCountTest() {
		TestSuite mainTestSuite = new TestSuite("mainTestSuite");
		TestSuite testSuite1 = new TestSuite("testSuite1");
		TestSuite testSuite2 = new TestSuite("testSuite2");
		BaseTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCaseAreNotTheSame");
		BaseTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		
		testSuite1.add(passesForDifferentConcertsAreNotEqual);
		testSuite2.add(createdPassesAreNotNull);
		mainTestSuite.add(testSuite1);
		mainTestSuite.add(testSuite2);
		
		
		assertTrue(mainTestSuite.countTest() == 2);
	}
	
}
