package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import ar.fi.uba.td.testFramework.output.XMLOutput;

public class XMLOutputTest {
	private static String EXPECTED_XML_BASIC = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><testframework><testsuit name=\"testsuitbase\"><testcase name=\"test1\" result=\"OK\" time=\"0.123\"/></testsuit></testframework>";
	private static String EXPECTED_XML_COMPLEX = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><testframework><testsuit name=\"testsuitbase\"><testcase name=\"test1\" result=\"OK\" time=\"0.123\"/><testcase name=\"test2\" result=\"ERROR\" time=\"0.123\"/><testsuit name=\"testsuitbase2\"><testcase name=\"test3\" result=\"OK\" time=\"0.123\"/><testcase name=\"test4\" result=\"OK\" time=\"0.123\"/><testsuit name=\"testsuitbase3\"><testcase name=\"test5\" result=\"FAIL\" time=\"0.123\"/><testcase name=\"test6\" result=\"ERROR\" time=\"0.123\"/><testcase name=\"test7\" result=\"ERROR\" time=\"0.123\"/><testcase name=\"test8\" result=\"OK\" time=\"0.123\"/><testcase name=\"test9\" result=\"OK\" time=\"0.123\"/></testsuit></testsuit></testsuit></testframework>";

	@Test
	public void testSimpleXMLStructure() {
		XMLOutput xml = new XMLOutput();
		xml.startTestSuiteOutput("testsuitbase", null);
		xml.endTestCaseOutput("test1", TestStatus.OK, (long) 0.123);
		xml.endTestSuiteOutput();
		xml.endTestOutput(null);
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"resultado.xml"));
			assertEquals(EXPECTED_XML_BASIC, bf.readLine());
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testComplexXMLStructure() {
		XMLOutput xml = new XMLOutput();
		xml.startTestSuiteOutput("testsuitbase", null);
		xml.endTestCaseOutput("test1", TestStatus.OK, (long) 0.123);
		xml.endTestCaseOutput("test3", TestStatus.ERROR, (long) 0.123);
		xml.startTestSuiteOutput("testsuitbase2", null);
		xml.endTestCaseOutput("test3", TestStatus.OK, (long) 0.123);
		xml.endTestCaseOutput("test4", TestStatus.OK, (long) 0.123);
		xml.startTestSuiteOutput("testsuitbase3", null);
		xml.endTestCaseOutput("test5", TestStatus.FAILED, (long) 0.123);
		xml.endTestCaseOutput("test6", TestStatus.ERROR, (long) 0.123);
		xml.endTestCaseOutput("test7", TestStatus.ERROR, (long) 0.123);
		xml.endTestCaseOutput("test8", TestStatus.OK, (long) 0.123);
		xml.endTestCaseOutput("test9", TestStatus.OK, (long) 0.123);
		xml.endTestSuiteOutput();
		xml.endTestSuiteOutput();
		xml.endTestSuiteOutput();
		xml.endTestOutput(null);
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"resultado2.xml"));
			assertEquals(EXPECTED_XML_COMPLEX, bf.readLine());
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}