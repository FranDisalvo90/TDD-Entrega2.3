package ar.fi.uba.td.testFramework;

import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLOutput {
	private Document document;
	private Stack<Element> stack;

	public XMLOutput() {
		try {
			this.stack = new Stack < Element > ();
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			// define root elements
			this.document = documentBuilder.newDocument();
			Element actual = document.createElement("testframework");
			this.document.appendChild(actual);
			this.stack.add(actual);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTest(String name, String result, String time) {
		Element testCaseElement = this.document.createElement("testcase");
		testCaseElement.setAttribute("name", name);
		testCaseElement.setAttribute("result", result);
		testCaseElement.setAttribute("time", time);
		this.stack.peek().appendChild(testCaseElement);
	}
	
	public void openTestSuit(String name) {
		Element testSuitElement = this.document.createElement("testsuit");
		testSuitElement.setAttribute("name", name);
		this.stack.peek().appendChild(testSuitElement);
		this.stack.add(testSuitElement);
	}
	
	public void closeTestSuit() {
		this.stack.pop();
	}
	
	public void writeXml(String filename) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(this.document);
			StreamResult result = new StreamResult(new File(filename));
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
