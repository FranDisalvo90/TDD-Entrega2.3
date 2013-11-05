package ar.fi.uba.td.testFramework;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForTheSameConcertAreEqual;


public class FrameworkTest {

	RunnableTest mainTest;
	RunnableTest testSuiteA; 
	RunnableTest passesForTheSameConcertA;
	TestRunner runner;
	
	@Before
	public void setUp() throws Exception {
		mainTest = new TestSuite("mainTest");
		testSuiteA = new TestSuite("testSuite"); 
		passesForTheSameConcertA = new TestCasePassesForTheSameConcertAreEqual("TestCasePassesForTheSameConcertAreEqual");
		testSuiteA.add(passesForTheSameConcertA);
		mainTest.add(testSuiteA);
		TestRunner runner = new TestRunner(mainTest);
	}	
	
	@Test
	public void unrepeatedTestBaseNames() {
	
		RunnableTest passesForTheSameConcertB = new TestCasePassesForTheSameConcertAreEqual("TestCasePassesForTheSameConcertAreEqual");
		testSuiteA.add(passesForTheSameConcertB );
		
		assertTrue(mainTest.countTest() == 1);
	}
	
	@Test
	public void unrepeatedTestSuiteNames() {
	
		RunnableTest testSuiteB = new TestSuite("testSuite");
		testSuiteB.add(passesForTheSameConcertA);
		mainTest.add(testSuiteB);
		
		assertTrue(mainTest.countTest() == 1);
	}
	
	
	public void testSetUpTestBase(){
		
		RunnableTest createdPasses = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		
	}

	public void testSetUpTestSuite(){
		
	}
		
}
