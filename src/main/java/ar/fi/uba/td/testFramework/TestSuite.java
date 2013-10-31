package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class that groups a set of BaseTests, modeling a test suite.
 * This class works as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;

	public TestSuite() {
		testList = new ArrayList<RunnableTest>();
	}

	public void add(RunnableTest test) {
		testList.add(test);
	}

	public void run(TestResults testOutput) {
		for (RunnableTest entity : this.testList) {
			entity.run(testOutput);
		}
	}
	
	public int countTest() {
		int total = 0;
		for (RunnableTest entity : this.testList) {
			total += entity.countTest();
		}
		return total;
	}
}
