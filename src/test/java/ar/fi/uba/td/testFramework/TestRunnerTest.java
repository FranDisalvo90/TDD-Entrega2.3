package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestRunnerTest {

	TestSuite mainTestSuite = new TestSuite("mainTest");
	
	@Before
	public void setUp() throws Exception {
		
		TestSuite testSuite1 = new TestSuite("testSuite1");
		TestSuite testSuite2 = new TestSuite("testSuite2");
		BaseTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCasePassesAreNotEqual");
		BaseTest  createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		BaseTest  identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCaseAreTheSameFailed");
		
		testSuite1.add(passesForDifferentConcertsAreNotEqual);
		testSuite2.add(createdPassesAreNotNull);
		testSuite2.add(identicalPassesAreTheSame);
		mainTestSuite.add(testSuite1);
		mainTestSuite.add(testSuite2);
	}
	
	@Test(expected = Exception.class)
	public void testTestRunnerNotRun() throws Exception {
		TestRunner testRunner = new TestRunner(mainTestSuite);
		testRunner.getResult();
	}

	@Test
	public void testTestRunnerNumberTestPassed() throws Exception{
		TestRunner testRunner = new TestRunner(mainTestSuite);
		testRunner.runTests();
		TestResults result = testRunner.getResult();
		
		assertTrue(result.getNumberOfPassedTests() == 2);
	}


	@Test
	public void testTestRunnerNumberTestFailed() throws Exception{
		TestRunner testRunner = new TestRunner(mainTestSuite);
		testRunner.runTests();
		TestResults result = testRunner.getResult();
		
		assertTrue(result.getNumberOfFailedTests() == 1);
	}
	

	@Test
	public void testTestRunnerNumberTestTotal() throws Exception{
		TestRunner testRunner = new TestRunner(mainTestSuite);
		testRunner.runTests();
		TestResults result = testRunner.getResult();
		
		assertTrue(result.getNumberOfTotalTest() == 3);
	}
	
}
