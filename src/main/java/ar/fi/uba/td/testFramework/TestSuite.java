package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class that groups a set of BaseTests, modeling a test suite. This class works
 * as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;
	Output myOutput;
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
	
	public Output GetOutput() {
		return this.myOutput;
	}

	public void add(RunnableTest test) {
		if (!repeatedName(test.getName())) {
			testList.add(test);
			test.checkOutput(this);
			
		}
	}

	public void run() {
		for (RunnableTest entity : this.testList) {
			//this.setUp();
			entity.run();
			//this.tearDown();
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

	@Override
	public void checkOutput(TestSuite testSuite) {
		testSuite.GetOutput().addOutput(this.GetOutput());
	}

	/*public void setUp() {
	}

	public void tearDown() {
	}
*/
}
