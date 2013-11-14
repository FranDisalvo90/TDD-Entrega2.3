package ar.fi.uba.td.testFramework.nestedSuitesTest;

import java.io.IOException;

import ar.fi.uba.td.testFramework.TestCase;
import ar.fi.uba.td.testFramework.TestRunner;
import ar.fi.uba.td.testFramework.TestSuite;

public class NestedSuitesTest {

    public static void main(String[] args) throws IOException {
	TestCase testCase1 = new TestCase1("TestCase1");
	TestCase testCase2 = new TestCase2("TestCase2");
	TestCase testCase3 = new TestCase3("TestCase3");
	TestCase testCase4 = new TestCase4("TestCase4");
	TestCase testCase5 = new TestCase5("TestCase5");
	TestCase testCase6 = new TestCase6("TestCase6");
	TestCase testCase7 = new TestCase7("TestCase7");
	TestCase testCase8 = new TestCase8("TestCase8");
	TestCase testCase9 = new TestCase9("TestCase9");
	TestCase testCase10 = new TestCase10("TestCase10");
	TestCase testCase11 = new TestCase11("TestCase11");
	TestCase testCase12 = new TestCase12("TestCase12");
	TestCase testCase13 = new TestCase13("TestCase13");
	TestCase testCase14 = new TestCase14("TestCase14");

	TestSuite testSuiteA = new TestSuiteA("TestSuiteA");
	TestSuite testSuiteB = new TestSuiteB("TestSuiteB");
	TestSuite testSuiteC = new TestSuite("TestSuiteC");
	TestSuite testSuiteD = new TestSuite("TestSuiteD");
	TestSuite testSuiteE = new TestSuite("TestSuiteE");

	testSuiteC.add(testCase7);
	testSuiteC.add(testCase8);
	testSuiteC.add(testCase9);

	testSuiteD.add(testCase10);
	testSuiteD.add(testCase11);
	testSuiteD.add(testCase12);

	testSuiteE.add(testCase13);
	testSuiteE.add(testCase14);

	testSuiteB.add(testSuiteC);
	testSuiteB.add(testCase4);
	testSuiteB.add(testSuiteD);
	testSuiteB.add(testCase5);
	testSuiteB.add(testSuiteE);
	testSuiteB.add(testCase6);

	testSuiteA.add(testCase1);
	testSuiteA.add(testCase2);
	testSuiteA.add(testSuiteB);
	testSuiteA.add(testCase3);

	TestRunner runner = new TestRunner(testSuiteA);
	runner.runTests();
    }
}
