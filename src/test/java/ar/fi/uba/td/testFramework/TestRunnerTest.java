package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	TestCase passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual(
		"TestCasePassesAreNotEqual");
	TestCase createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull(
		"TestCaseCreatedPassesAreNotNull");
	TestCase identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed(
		"TestCaseAreTheSameFailed");

	passesForDifferentConcertsAreNotEqual.addTag("SLOW");
	createdPassesAreNotNull.addTag("FAST");
	identicalPassesAreTheSame.addTag("FAST");
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
    public void testTestRunnerNumberTestPassed() throws Exception {
	TestRunner testRunner = new TestRunner(mainTestSuite);
	testRunner.runTests();
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfPassedTests() == 2);
    }

    @Test
    public void testTestRunnerNumberTestFailed() throws Exception {
	TestRunner testRunner = new TestRunner(mainTestSuite);
	testRunner.runTests();
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfFailedTests() == 1);
    }

    @Test
    public void testTestRunnerNumberTestTotal() throws Exception {
	TestRunner testRunner = new TestRunner(mainTestSuite);
	testRunner.runTests();
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfTotalTest() == 3);
    }

    @Test
    public void testTestRunnerNumberTestTaged() throws Exception {
	TestCase tagedTest = new TestCasePassesForDifferentConcertsAreNotEqual(
		"TestCasePassesAreNotEqual");
	tagedTest.addTag("SKIP");
	mainTestSuite.add(tagedTest);
	TestRunner testRunner = new TestRunner(mainTestSuite);
	testRunner.runTests();
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfSkippedTests() == 1);
	assertTrue(result.getNumberOfTestRun() == 3);
    }

    @Test
    public void testTestRunnerNumberTestOneTagged() throws Exception {
	TestCase tagedTest = new TestCasePassesForDifferentConcertsAreNotEqual(
		"TestCasePassesAreNotEqual");
	tagedTest.addTag("THISMUSTRUN");
	mainTestSuite.add(tagedTest);
	TestRunner testRunner = new TestRunner(mainTestSuite);
	ArrayList<String> list = new ArrayList<String>();
	list.add("THISMUSTRUN");
	testRunner.runTests(list);
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfTestRun() == 1);
    }

    @Test
    public void testTestRunnerNumberTestTagged() throws Exception {
	TestRunner testRunner = new TestRunner(mainTestSuite);
	ArrayList<String> list = new ArrayList<String>();
	list.add("FAST");
	testRunner.runTests(list);
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfTestRun() == 2);
    }

    @Test
    public void testTestRunnerNumberTestOneTaggedSkiped() throws Exception {
	TestCase tagedTest = new TestCasePassesForDifferentConcertsAreNotEqual(
		"TestCasePassesAreNotEqual");
	tagedTest.addTag("THISMUSTRUN");
	tagedTest.addTag("SKIP");
	mainTestSuite.add(tagedTest);
	TestRunner testRunner = new TestRunner(mainTestSuite);
	ArrayList<String> list = new ArrayList<String>();
	list.add("THISMUSTRUN");
	testRunner.runTests(list);
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfTestRun() == 0);
    }

    @Test
    public void testTestRunnerNumberTestTagRegex() throws Exception {
	TestRunner testRunner = new TestRunner(mainTestSuite);
	ArrayList<String> list = new ArrayList<String>();
	list.add("FAST");
	testRunner.runTests("TestCaseAreTheSameFailed", list);
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfTestRun() == 1);
    }

    @Test
    public void testTestRunnerNumberTestTagRegexAll() throws Exception {
	TestRunner testRunner = new TestRunner(mainTestSuite);
	ArrayList<String> list = new ArrayList<String>();
	list.add("FAST");
	testRunner.runTests(".*", list);
	TestResults result = testRunner.getResult();

	assertTrue(result.getNumberOfTestRun() == 2);
    }
}
