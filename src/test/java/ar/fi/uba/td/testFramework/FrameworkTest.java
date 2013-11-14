package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ar.fi.uba.td.testFramework.nestedSuitesTest.*;
import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;

public class FrameworkTest {

    TestSuite mainTest;
    TestSuite testSuite;
    TestCase createdPasses;
    TestCase test1;
    TestCase test2;
    TestCase test3;
    TestSuite testSuiteA;
    ArrayList<String> tags;

    @Before
    public void setUp() throws Exception {
	mainTest = new TestSuite("mainTest");
	testSuite = new TestSuite("testSuite");
	tags = new ArrayList<String>();
	createdPasses = new TestCaseCreatedPassesAreNotNull(
		"TestCaseCreatedPassesAreNotNull");
	testSuite.add(createdPasses);
	mainTest.add(testSuite);
	test1 = new TestCase1("test1");
	test2 = new TestCase2("test2");
	test3 = new TestCase3("test3");
	testSuiteA = new TestSuiteA("testSuiteA");
    }

    @Test
    public void unrepeatedTestBaseNames() {

	TestCase createdPasses2 = new TestCaseCreatedPassesAreNotNull(
		"TestCaseCreatedPassesAreNotNull");
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

	TestCase failedTest = new TestCase14("Failed Test");
	TestRunner testRunner = new TestRunner(failedTest);
	testRunner.runTests();
	assertEquals(testRunner.getResult().getNumberOfFailedTests(), 1);
    }

    @Test
    public void testErrorTest() throws Exception {
	TestCase errorTest = new TestCase13("Error Test");
	TestRunner testRunner = new TestRunner(errorTest);
	testRunner.runTests();
	assertEquals(testRunner.getResult().getNumberOfErrorTests(), 1);
    }

    @Test
    public void testSetUpBaseTest() throws Exception {

	TestCase test10 = new TestCase10("test10");
	TestRunner testRunner = new TestRunner(test10);
	testRunner.runTests();
	assertEquals(testRunner.getResult().getNumberOfPassedTests(), 1);
    }

    @Test
    public void testSetUpTestSuite() throws Exception {
	testSuiteA.add(test1);
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests();
	assertEquals(testRunner.getResult().getNumberOfPassedTests(), 1);
    }

    @Test
    public void testSetUpBaseTestandSuite() throws Exception {
	testSuiteA.add(test3);
	testSuiteA.add(test2);
	testSuiteA.add(test1);
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests();
	assertEquals(testRunner.getResult().getNumberOfPassedTests(), 3);
    }

    @Test
    public void testRegularExpression() throws Exception {

	TestCase test6 = new TestCase6("my special test case ");
	TestCase test7 = new TestCase7("my special test case 1");
	TestCase test8 = new TestCase8("my special");
	TestCase test9 = new TestCase9("a test");
	TestSuite testSuiteA = new TestSuiteA("testSuiteA");
	testSuiteA.add(test6);
	testSuiteA.add(test7);
	testSuiteA.add(test8);
	testSuiteA.add(test9);
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests(".*special.*");
	assertEquals(testRunner.getResult().getNumberOfTestRun(), 3);
    }

    @Test
    public void testNameNotExists() throws Exception {

	TestCase test6 = new TestCase6("my special test case ");
	TestCase test9 = new TestCase9("a test");
	TestSuite testSuiteA = new TestSuiteA("testSuiteA");
	testSuiteA.add(test6);
	testSuiteA.add(test9);
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests(".*notExists.*");
	assertEquals(testRunner.getResult().getNumberOfTestRun(), 0);
    }

    @Test
    public void testTestCaseWithTAG() throws Exception {
	test1.addTag("SLOW");
	test3.addTag("SLOW");
	testSuiteA.add(test1);
	testSuiteA.add(test2);
	testSuiteA.add(test3);
	tags.add("SLOW");
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests(tags);
	assertEquals(testRunner.getResult().getNumberOfTestRun(), 2);
    }

    @Test
    public void testTestCaseWithTAGSandSKIP() throws Exception {
	test1.addTag("SLOW");
	test3.addTag("SLOW");
	testSuiteA.add(test1);
	testSuiteA.add(test2);
	testSuiteA.add(test3);
	test1.addTag("SKIP");
	tags.add("SLOW");
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests(tags);
	assertEquals(testRunner.getResult().getNumberOfTestRun(), 1);
    }

    @Test
    public void testTestCaseWithTAGS() throws Exception {
	TestCase test4 = new TestCase4("testCase4");
	TestCase test5 = new TestCase5("testCase5");
	TestCase test6 = new TestCase6("testCase6");
	test1.addTag("SLOW");
	test1.addTag("DB");
	test2.addTag("SLOW");
	test3.addTag("DB");
	test4.addTag("FAST");
	test5.addTag("SMOKE");
	testSuiteA.add(test1);
	testSuiteA.add(test2);
	testSuiteA.add(test3);
	testSuiteA.add(test4);
	testSuiteA.add(test5);
	testSuiteA.add(test6);

	tags.add("DB");
	tags.add("FAST");
	tags.add("SMOKE");
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests(tags);
	assertEquals(testRunner.getResult().getNumberOfTestRun(), 4);
    }

    @Test
    public void testTestCaseWithTAGSandRegEx2() throws Exception {
	TestCase test4 = new TestCase4("mySql.1");
	TestCase test5 = new TestCase5("mySql.2");
	TestCase test6 = new TestCase6("mySql.3");
	test1.addTag("DB");
	test2.addTag("DB");
	test3.addTag("SLOW");
	test4.addTag("DB");
	test5.addTag("DB");
	testSuiteA.add(test1);
	testSuiteA.add(test2);
	testSuiteA.add(test3);
	testSuiteA.add(test4);
	testSuiteA.add(test5);
	testSuiteA.add(test6);
	tags.add("DB");
	TestRunner testRunner = new TestRunner(testSuiteA);
	testRunner.runTests(".*mySql.*", tags);
	assertEquals(testRunner.getResult().getNumberOfTestRun(), 2);
    }

    @Test
    public void testBaseTestRunTimeFast() {
	TestCase fastTest = new TestCase15("SLEEP1");
	TestRunner runner = new TestRunner(fastTest);
	runner.runTests();
	assertTrue((fastTest.getTime() / 1000000) < 1050);
    }

    @Test
    public void testBaseTestRunTimeSlow() {
	TestCase slowTest = new TestCase15("SLEEP2");
	TestCase fastTest = new TestCase5("fastTest");
	TestSuite testSuite = new TestSuite("mainTestSuite");
	testSuite.add(slowTest);
	testSuite.add(fastTest);
	TestRunner runner = new TestRunner(testSuite);
	runner.runTests();
	assertTrue(fastTest.getTime() < slowTest.getTime());
    }

    @Test
    public void testBaseTestRunTime() {
	TestCase fastTest = new TestCase15("OTHERNAME");
	TestInformation testInfo = new TestInformation();
	fastTest.run(testInfo);

	assertTrue((fastTest.getTime() / 1000000) < 1000);
    }

}
