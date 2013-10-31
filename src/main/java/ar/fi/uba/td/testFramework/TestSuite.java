package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;

	public TestSuite() {
		testList = new ArrayList<RunnableTest>();
	}

	public void add(RunnableTest test) {
		testList.add(test);
	}

	public void run(TestOutput testOutput) {
		for (RunnableTest entity : this.testList) {
			entity.run(testOutput);
		}
	}
}
