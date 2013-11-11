package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;



public class XMLOutputTest {
	private static String EXPECTED_XML_BASIC = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><testframework><testsuit name=\"testsuitbase\"><testcase name=\"test1\" result=\"OK\" time=\"0.123\"/></testsuit></testframework>";
	private static String EXPECTED_XML_COMPLEX = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><testframework><testsuit name=\"testsuitbase\"><testcase name=\"test1\" result=\"OK\" time=\"0.123\"/><testcase name=\"test2\" result=\"ERROR\" time=\"0.123\"/><testsuit name=\"testsuitbase2\"><testcase name=\"test3\" result=\"OK\" time=\"0.123\"/><testcase name=\"test4\" result=\"OK\" time=\"0.123\"/><testsuit name=\"testsuitbase3\"><testcase name=\"test5\" result=\"FAIL\" time=\"0.123\"/><testcase name=\"test6\" result=\"ERROR\" time=\"0.123\"/><testcase name=\"test7\" result=\"ERROR\" time=\"0.123\"/><testcase name=\"test8\" result=\"OK\" time=\"0.123\"/><testcase name=\"test9\" result=\"OK\" time=\"0.123\"/></testsuit></testsuit></testsuit></testframework>";
	@Test
	public void testSimpleXMLStructure() {
		XMLOutput xml = new XMLOutput();
		xml.openTestSuit("testsuitbase");
		xml.addTest("test1", "OK", "0.123");
		xml.closeTestSuit();
		xml.writeXml("resultado.xml");
		try {
			BufferedReader bf = new BufferedReader(new FileReader("resultado.xml"));
			assertEquals(EXPECTED_XML_BASIC, bf.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testComplexXMLStructure() {
		XMLOutput xml = new XMLOutput();
		xml.openTestSuit("testsuitbase");
		xml.addTest("test1", "OK", "0.123");
		xml.addTest("test2", "ERROR", "0.123");
		xml.openTestSuit("testsuitbase2");
		xml.addTest("test3", "OK", "0.123");
		xml.addTest("test4", "OK", "0.123");
		xml.openTestSuit("testsuitbase3");
		xml.addTest("test5", "FAIL", "0.123");
		xml.addTest("test6", "ERROR", "0.123");
		xml.addTest("test7", "ERROR", "0.123");
		xml.addTest("test8", "OK", "0.123");
		xml.addTest("test9", "OK", "0.123");
		xml.closeTestSuit();
		xml.closeTestSuit();
		xml.closeTestSuit();
		xml.writeXml("resultado2.xml");
		try {
			BufferedReader bf = new BufferedReader(new FileReader("resultado2.xml"));
			assertEquals(EXPECTED_XML_COMPLEX, bf.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
