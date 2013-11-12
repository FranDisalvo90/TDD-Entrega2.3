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

	/* Returns true if the test's name isn't repeated, false otherwise. */
	public boolean add(RunnableTest test) {
		if (!repeatedName(test.getName())) {
			testList.add(test);
			return true;
		}
		return false;
	}

	public void run(TestInformation information) {
		String fullTestName = getFullTestName(information);
		information.getResults().startTestSuiteOutput(fullTestName);

		/* Sorts the list so that the output is prettier. */
		Collections.sort(testList);

		this.setUp(information.getContext());
		for (RunnableTest entity : this.testList) {
			entity.run(information.clone());
		}
		this.tearDown(information.getContext());
		
		information.getResults().endTestSuiteOutput();
	}

	/* Gets this suite's parent's name and changes it so that the correct name is 
	 * gotten across deeper children in the structure. */
	private String getFullTestName(TestInformation information) {
		String parentName = information.getParentName();
		String fullTestName;

		if (parentName.isEmpty())
			fullTestName = this.name;
		else
			fullTestName = parentName + "." + this.name;

		information.setParentName(fullTestName);
		return fullTestName;
	}

	public int getTestCount(TestInformation information) {
		int total = 0;
		for (RunnableTest runnableTest : this.testList)
			total += runnableTest.getTestCount(information);
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

	public int getTestCount() {
		int total = 0;
		for (RunnableTest runnableTest : this.testList)
			total += runnableTest.getTestCount();
		return total;
	}

}
