package ar.fi.uba.td.testFramework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that groups a set of BaseTests, modeling a test suite. This class works
 * as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;
	private String name;

	public TestSuite(String name) {
		testList = new ArrayList<RunnableTest>();
		this.name = name;
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

	public void run(TestInformation information) {
		String parentName = information.getParentName();
		String fullTestName;
		
		if(parentName == null || parentName.isEmpty())
			fullTestName = this.name;
		else
			fullTestName = parentName + "." + this.name;
		
		information.setParentName(fullTestName);
		information.getResults().addToOutputTestSuite(fullTestName);
		Collections.sort(testList);

		this.setUp(information.getContext());
		for (RunnableTest entity : this.testList) {
			entity.run(information.clone());
		}

		this.tearDown(information.getContext());
	}

	public int countTest() {
		int total = 0;
		for (RunnableTest entity : this.testList) {
			total += entity.countTest();
		}
		return total;
	}

	public String getName() {
		return name;
	}

	public int compareTo(RunnableTest test) {
		return 1;
	}

	public void setUp(TestContext context) {
	}

	public void tearDown(TestContext context) {
	}

}
