package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;

public class FrameworkTest {

    	TestSuite mainTest;
	TestSuite testSuite; 
	BaseTest createdPasses;
	
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
	
		BaseTest createdPasses2 = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		assertFalse(testSuite.add(createdPasses2));
	}
	
	@Test
	public void unrepeatedTestSuiteNames() {
	
		TestSuite testSuite2 = new TestSuite("testSuite");
		testSuite2.add(createdPasses);
		assertFalse(mainTest.add(testSuite2));
	}
	
	
	
}
