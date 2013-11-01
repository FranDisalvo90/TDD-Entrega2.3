package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;

public class FrameworkTest {

	RunnableTest mainTest;
	RunnableTest testSuite; 
	RunnableTest createdPasses;
	
	@Before
	public void setUp() throws Exception {
		mainTest = new TestSuite("mainTest");
		testSuite = new TestSuite("testSuite"); 
		createdPasses = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		testSuite.add(createdPasses);
		mainTest.add(testSuite);
	}	
	
	@Test
	public void unrepeatedTestBaseNames() {
	
		RunnableTest createdPasses2 = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		testSuite.add(createdPasses2);
		
		assertTrue(mainTest.countTest() == 1);
	}
	
	@Test
	public void unrepeatedTestSuiteNames() {
	
		RunnableTest testSuite2 = new TestSuite("testSuite");
		testSuite2.add(createdPasses);
		mainTest.add(testSuite2);
		
		assertTrue(mainTest.countTest() == 1);
	}
	
	
	
	
}
