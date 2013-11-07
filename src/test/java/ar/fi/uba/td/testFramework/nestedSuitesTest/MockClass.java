package ar.fi.uba.td.testFramework.nestedSuitesTest;

public class MockClass implements Cloneable {

	private String text;
	
	public MockClass(String text) {
		this.text = text;
	}
	
	public void setTest(String text) {
		this.text = text;
	}

	public void printText() {
		System.out.println(text);
	}
}
