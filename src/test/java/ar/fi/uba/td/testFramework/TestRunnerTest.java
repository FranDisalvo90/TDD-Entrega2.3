package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;

public class TestRunnerTest {

	RunnableTest mainTestSuite = new TestSuite();
	
	@Before
	public void setUp() throws Exception {
		
		RunnableTest testSuite1 = new TestSuite();
		RunnableTest testSuite2 = new TestSuite();
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual();
		RunnableTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull();
		RunnableTest identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed();
		
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
