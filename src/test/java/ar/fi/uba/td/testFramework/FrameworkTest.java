package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.nestedSuitesTest.*;
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
	
	@Test
	public void testFailedTest() throws Exception {
	
		BaseTest failedTest = new TestCase14("Failed Test");
		TestRunner testRunner = new TestRunner(failedTest);
		testRunner.runTests();
		assertEquals(testRunner.getResult().getNumberOfFailedTests(), 1);
	}
	
	@Test
	public void testErrorTest() throws Exception {
	    	BaseTest errorTest = new TestCase13("Error Test");
		TestRunner testRunner = new TestRunner(errorTest);
		testRunner.runTests();
		assertEquals(testRunner.getResult().getNumberOfErrorTests(), 1);
	}
	
}
