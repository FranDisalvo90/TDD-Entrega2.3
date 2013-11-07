package ar.fi.uba.td.regularExpressionTest;

import java.io.IOException;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestRunner;
import ar.fi.uba.td.testFramework.TestSuite;

public class RegularExpressionTest {

	public static void main(String[] args) throws IOException {
		
		BaseTest testCase1 = new TestCase1("TestCase1");
		BaseTest testCase2 = new TestCase2("TestCase2");
		BaseTest testCase3 = new TestCase3("TestCase3");
		BaseTest testCaseA = new TestCaseA("TestCaseA");
		BaseTest testCaseB = new TestCaseB("TestCaseB");
		
		TestSuite testSuite1 = new TestSuite1("TestSuite1");
		TestSuite testSuite2 = new TestSuite1("TestSuite2");
		
		testSuite1.add(testCase2);
		testSuite1.add(testCaseA);
		testSuite2.add(testCase3);
		testSuite2.add(testSuite1);
		testSuite2.add(testCaseB);
		testSuite2.add(testCase1);
		
		TestRunner runner = new TestRunner(testSuite2);
		runner.runTests(".*[AB]");		
	}

}
