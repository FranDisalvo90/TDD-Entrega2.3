package ar.fi.uba.td.testFramework.nestedSuitesTest;

import ar.fi.uba.td.testFramework.CloneableObject;

public class MockClass implements CloneableObject {

	private String text;

	public MockClass(String text) {
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public Object clone() {
		return new MockClass(this.text);
	}
}
