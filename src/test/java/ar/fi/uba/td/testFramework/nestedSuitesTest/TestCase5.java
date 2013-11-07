package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.BaseTest;
import ar.fi.uba.td.testFramework.TestFailedException;

public class TestCase5 extends BaseTest {

	public TestCase5(String nameTest) {
		super(nameTest);
	}

	@Override
	public void runTest() throws TestFailedException {
		assertTrue(true, "Passing test");
	}
	
	public void setUp() {
		System.out.println("TestCase5 is setting up.");
		for(Object contextElement : this.getContext().getElements())
			((MockClass) contextElement).printText();
	}

}
