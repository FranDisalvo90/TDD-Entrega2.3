package ar.fi.uba.td.testFramework;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLOutput {
	private Document document;
	private Element rootElement;

	public XMLOutput() {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentFactory
					.newDocumentBuilder();
			// define root elements
			this.document = documentBuilder.newDocument();
			this.rootElement = document.createElement("tests");
			this.document.appendChild(this.rootElement);
		} catch (Exception e) {
			// TODO
		}
	}

	public void addTest(String name, String Result, int time) {
		// TODO
	}

	public void openTestSuit(String name) {
		// TODO
	}

	public void closeTestSuit(String name) {
		// TODO
	}
}
