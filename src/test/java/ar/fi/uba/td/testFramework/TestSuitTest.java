package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSuitTest {

	@Test
	public void testEmptyTestSuit() {
		RunnableTest emptyTestSuit = new TestSuite();
		TestResults testResult = new TestResults();
		emptyTestSuit.run(testResult);
		assertTrue(testResult.getNumberOfTotalTest() == 0);
	}

}
