package ar.fi.uba.td.testFramework;
import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.TestCase;
import ar.fi.uba.td.testFramework.TestInformation;
import ar.fi.uba.td.testFramework.TestPerformance;
import ar.fi.uba.td.testFramework.nestedSuitesTest.TestCase1;
import ar.fi.uba.td.testFramework.testCases.*;


public class TestPerformanceTest {

	@Test
	public void testPerformanceTestPassed() {
		TestCase test = new TestCasePassesForDifferentConcertsAreNotEqual("TestCaseThatPasses");
		TestPerformance testPerformance = new TestPerformance("TestPerformanceTestCase1", test, 1000000000);
		TestInformation testInfo = new TestInformation();
		RAMStore store = new RAMStore();
		testPerformance.run(testInfo,store);		
		assertEquals(testInfo.getResults().getNumberOfPassedTests(), 1);
	}
	
	@Test
	public void testPerformanceInternalTestFailed() {
		TestCase test = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCaseThatFails");
		TestPerformance testPerformance = new TestPerformance("TestPerformanceTestCase1", test, 1000000000);
		TestInformation testInfo = new TestInformation();
		RAMStore store = new RAMStore();
		testPerformance.run(testInfo,store);
		assertEquals(testInfo.getResults().getNumberOfFailedTests(), 1);
	}
	
	@Test
	public void testPerformanceTestFailed() {
		TestCase test = new TestCasePassesForDifferentConcertsAreNotEqual("TestCaseThatPasses");
		TestPerformance testPerformance = new TestPerformance("TestPerformanceTestCase1", test, 1);
		TestInformation testInfo = new TestInformation();
		RAMStore store = new RAMStore();
		testPerformance.run(testInfo,store);		
		assertEquals(testInfo.getResults().getNumberOfFailedTests(), 1);
	}

}

