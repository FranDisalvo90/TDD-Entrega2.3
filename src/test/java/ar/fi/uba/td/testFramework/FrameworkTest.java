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
	
	@Test
	public void testSetUpBaseTest() throws Exception {
	
		BaseTest test10 = new TestCase10("test10");
		TestRunner testRunner = new TestRunner(test10);
		testRunner.runTests();
		assertEquals(testRunner.getResult().getNumberOfPassedTests(), 1);
	}

	@Test
	public void testSetUpTestSuite() throws Exception {
	
		BaseTest test1 = new TestCase1("test1");
		TestSuite testSuiteA = new TestSuiteA("testSuiteA");
		testSuiteA.add(test1);
		TestRunner testRunner = new TestRunner(testSuiteA);
		testRunner.runTests();
		assertEquals(testRunner.getResult().getNumberOfPassedTests(), 1);
	}
	
	@Test
	public void testSetUpBaseTestandSuite() throws Exception {
	
		BaseTest test2 = new TestCase2("test2");
		BaseTest test3 = new TestCase2("test3");
		TestSuite testSuiteA = new TestSuiteA("testSuiteA");
		testSuiteA.add(test2);
		testSuiteA.add(test3);
		TestRunner testRunner = new TestRunner(testSuiteA);
		testRunner.runTests();
		assertEquals(testRunner.getResult().getNumberOfPassedTests(), 2);
	}
	
	
	@Test
	public void testRegularExpression() throws Exception {
	
		BaseTest test6 = new TestCase6("my special test case ");
		BaseTest test7 = new TestCase7("my special test case 1");
		BaseTest test8 = new TestCase8("my special");
		BaseTest test9 = new TestCase9("a test");
		TestSuite testSuiteA = new TestSuiteA("testSuiteA");
		testSuiteA.add(test6);
		testSuiteA.add(test7);
		testSuiteA.add(test8);
		testSuiteA.add(test9);
		TestRunner testRunner = new TestRunner(testSuiteA);
		testRunner.runTests(".*special.*");
		assertEquals(testRunner.getResult().getNumberOfTotalTest(), 3);
	}
	
	@Test
	public void testNameNotExists() throws Exception {
	
		BaseTest test6 = new TestCase6("my special test case ");
		BaseTest test9 = new TestCase9("a test");
		TestSuite testSuiteA = new TestSuiteA("testSuiteA");
		testSuiteA.add(test6);
		testSuiteA.add(test9);
		TestRunner testRunner = new TestRunner(testSuiteA);
		testRunner.runTests(".*notExists.*");
		assertEquals(testRunner.getResult().getNumberOfTotalTest(), 0);
	}
	
	
}
