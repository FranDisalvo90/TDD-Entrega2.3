package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TestHandler {
	
	@Test
	public void succesWriteLineOnFileText() throws IOException {
		HandlerFileTxt.writeLineOnFile("test.txt","Primera Linea");
		FileReader reader = new FileReader("test.txt");
		BufferedReader buffer = new BufferedReader(reader);
		String linea = buffer.readLine();
		assertEquals(linea,"Primera Linea");
	}
	
	@Test
	public void succesVariousWriteLinesOnFileText() throws IOException {
		HandlerFileTxt.writeLineOnFile("secondTest.txt","Primera Linea");
		HandlerFileTxt.writeLineOnFile("secondTest.txt","Segunda Linea");
		HandlerFileTxt.writeLineOnFile("secondTest.txt","Tercera Linea");
		FileReader reader = new FileReader("secondTest.txt");
		BufferedReader buffer = new BufferedReader(reader);
		String linea = buffer.readLine();
		linea = buffer.readLine();
		linea = buffer.readLine();
		assertEquals(linea,"Tercera Linea");
	}
	
	@Test
	public void succesReadFirstLineOffFileText() throws IOException {
		HandlerFileTxt.writeLineOnFile("thirdTest.txt","Primera Linea");
		String line = HandlerFileTxt.readLineOfFile("thirdTest.txt",0);
		assertEquals(line,"Primera Linea");
	}
	
	@Test
	public void succesReadLastLineOffFileText() throws IOException {
		HandlerFileTxt.writeLineOnFile("fourthTest.txt","Primera Linea");
		HandlerFileTxt.writeLineOnFile("fourthTest.txt","Segunda Linea");
		HandlerFileTxt.writeLineOnFile("fourthTest.txt","Tercera Linea");
		String line = HandlerFileTxt.readLineOfFile("fourthTest.txt",2);
		assertEquals(line,"Tercera Linea");
	}
	
}
