package ar.fi.uba.td.testFramework;

import java.util.ArrayList;
import java.util.Collections;

import ar.fi.uba.td.testFramework.output.TestLogger;

/**
 * Class that groups a set of BaseTests, modeling a test suite. This class works
 * as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private String name;
	private ArrayList<RunnableTest> testList;

	public TestSuite(String name) {
		testList = new ArrayList<RunnableTest>();
		this.name = name;
	}

	/* Returns true if the test's name isn't repeated, false otherwise. */
	public boolean add(RunnableTest test) {
		if (!nameIsRepeated(test.getName())) {
			testList.add(test);
			return true;
		}
		return false;
	}

	public final int compareTo(RunnableTest test) {
		return 1;
	}

	/*
	 * Gets this suite's parent's name and changes it so that the correct name
	 * is gotten across deeper children in the structure.
	 */
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

	public String getName() {
		return name;
	}

	public final int getTestCount() {
		int total = 0;
		for (RunnableTest runnableTest : this.testList)
			total += runnableTest.getTestCount();
		return total;
	}

	public final int getTestCount(TestInformation information) {
		int total = 0;
		for (RunnableTest runnableTest : this.testList)
			total += runnableTest.getTestCount(information);
		return total;
	}

	private boolean nameIsRepeated(String name) {
		for (RunnableTest test : this.testList) {
			if (test.getName().equals(name))
				return true;
		}
		return false;
	}

	public final long run(TestInformation information) {
		String fullTestName = getFullTestName(information);

		TestLogger logger = information.getLogger();

		logger.startTestSuiteOutput(this.name, fullTestName);

		/* Sorts the list so that the output is prettier. */
		Collections.sort(testList);

		this.setUp(information.getContext());
		for (RunnableTest runnableTest : this.testList) {
			runnableTest.run(information.clone());
		}
		this.tearDown(information.getContext());

		logger.endTestSuiteOutput();
		return 0;
	}

	public void setUp(TestContext context) { }

	public void tearDown(TestContext context) {	}

}
