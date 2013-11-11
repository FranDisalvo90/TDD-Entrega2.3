package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.TestContext;
import ar.fi.uba.td.testFramework.TestSuite;

public class TestSuiteA extends TestSuite {

	public TestSuiteA(String name) {
		super(name);
	}

	public void setUp(TestContext context) {

		MockClass mock = new MockClass("Using TestSuiteA context!");
		context.addElement("mockA", mock);

	}

}
