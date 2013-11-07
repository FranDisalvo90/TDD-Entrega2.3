package ar.fi.uba.td.testFramework.nestedSuitesTest;

public class MockClass implements Cloneable {

	private String text;
	
	public MockClass(String text) {
		this.text = text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText(){
	    return text;
	}
}
