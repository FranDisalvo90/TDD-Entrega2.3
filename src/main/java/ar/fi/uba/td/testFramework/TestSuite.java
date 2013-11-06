package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class that groups a set of BaseTests, modeling a test suite. This class works
 * as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;
	String nameTestSuite;

	public TestSuite(String name) {
		testList = new ArrayList<RunnableTest>();
		this.nameTestSuite = name;
	}

	private boolean repeatedName(String name) {
		for (RunnableTest test : this.testList) {
			if (test.getName().equals(name))
				return true;
		}
		return false;
	}

	public boolean add(RunnableTest test) {
		if (!repeatedName(test.getName())) {
			testList.add(test);
			return true;
		}
		return false;
	}

	public void run(TestResults testOutput) {
		for (RunnableTest entity : this.testList) {
			this.setUp();
			entity.run(testOutput);
			this.tearDown();
		}
	}
	
	public int countTest() {
		int total = 0;
		for (RunnableTest entity : this.testList) {
			total += entity.countTest();
		}
		return total;
	}

	public String getName() {
		return nameTestSuite;
	}

	public void setUp() {
	}

	public void tearDown() {
	}
	
}
