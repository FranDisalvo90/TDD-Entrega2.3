package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForTheSameConcertAreEqual;


public class FrameworkTest {

	TestSuite mainTest;
	TestSuite testSuiteA; 
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
		assertEquals(testSuiteA.add(passesForTheSameConcertB ),false);
	}
	
	@Test
	public void unrepeatedTestSuiteNames() {
	
		TestSuite testSuiteB = new TestSuite("testSuite");
		testSuiteB.add(passesForTheSameConcertA);
		assertEquals(mainTest.add(testSuiteB),false);
	}
	
	
	public void testSetUpTestBase(){
		
		RunnableTest createdPasses = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		
	}

	public void testSetUpTestSuite(){
		
	}
		
}
