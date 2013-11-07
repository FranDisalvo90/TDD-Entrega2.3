package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.TestSuite;

public class TestSuiteA extends TestSuite {

	public TestSuiteA(String name) {
		super(name);
	}
	
	public void setUp() {
		System.out.println("TestSuiteA is setting up.");
		MockClass mock = new MockClass("Using TestSuiteA context!");
		this.getContext().addElement("mockA", mock);
		
	}

}
