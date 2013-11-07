package ar.fi.uba.td.testFramework.nestedSuitesTest;

import java.io.IOException;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.RunnableTest;
import ar.fi.uba.td.testFramework.TestRunner;
import ar.fi.uba.td.testFramework.TestSuite;

public class NestedSuitesTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BaseTest  testCase1 = new TestCase1("TestCase1");
		BaseTest  testCase2 = new TestCase2("TestCase2");
		BaseTest  testCase3 = new TestCase3("testCase3");
		BaseTest  testCase4 = new TestCase4("testCase4");
		BaseTest  testCase5 = new TestCase5("testCase5");
		BaseTest  testCase6 = new TestCase6("testCase6");
		BaseTest  testCase7 = new TestCase7("testCase7");
		BaseTest  testCase8 = new TestCase8("testCase8");
		BaseTest  testCase9 = new TestCase9("testCase9");
		BaseTest  testCase10 = new TestCase10("testCase10");
		BaseTest  testCase11 = new TestCase11("testCase11");
		BaseTest  testCase12 = new TestCase12("testCase12");
		BaseTest  testCase13 = new TestCase13("testCase13");
		BaseTest  testCase14 = new TestCase14("testCase14");

		TestSuite  testSuiteA = new TestSuiteA("TestSuite1");
		TestSuite  testSuiteB = new TestSuiteB("testSuiteB");
		TestSuite  testSuiteC = new TestSuiteC("testSuiteC");
		TestSuite testSuiteD = new TestSuiteD("testSuiteD");
		TestSuite testSuiteE = new TestSuiteE("testSuiteE");
		
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
