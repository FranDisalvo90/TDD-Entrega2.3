package ar.fi.uba.td.testFramework.output;

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

import ar.fi.uba.td.testFramework.TestResults;
import ar.fi.uba.td.testFramework.TestStatus;

/**
 * Class that extends from TestOutput use to write the result on a XML file.
 */

public class XMLOutput extends TestOutput {
    private Document document;
    private Stack<Element> stack;
    private static String FILE_EXTENSION = ".xml";

    public XMLOutput() {
	try {
	    this.stack = new Stack<Element>();
	    DocumentBuilderFactory documentFactory = DocumentBuilderFactory
		    .newInstance();
	    DocumentBuilder documentBuilder = documentFactory
		    .newDocumentBuilder();
	    // define root elements
	    this.document = documentBuilder.newDocument();
	    Element actual = document.createElement("testframework");
	    this.document.appendChild(actual);
	    this.stack.add(actual);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void endTestCaseOutput(String testName, TestStatus testStatus,
	    long runTime) {
	Element testCaseElement = this.document.createElement("testcase");
	testCaseElement.setAttribute("name", testName);
	testCaseElement.setAttribute("result", testStatus.toString());
	testCaseElement.setAttribute("time", String.valueOf(runTime) + " ns.");
	this.stack.peek().appendChild(testCaseElement);
    }

    @Override
    public void startTestSuiteOutput(String testName, String testSuiteName) {
	Element testSuitElement = this.document.createElement("testsuite");
	testSuitElement.setAttribute("name", testName);
	this.stack.peek().appendChild(testSuitElement);
	this.stack.add(testSuitElement);
    }

    @Override
    public void endTestSuiteOutput() {
	this.stack.pop();
    }

    @Override
    public void endTestOutput(TestResults testResults) {
	String fileName = getFileName() + FILE_EXTENSION;

	try {
	    TransformerFactory transformerFactory = TransformerFactory
		    .newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(this.document);
	    StreamResult result = new StreamResult(new File(fileName));
	    transformer.transform(source, result);
	} catch (TransformerException e) {
	    e.printStackTrace();
	}
    }

}
