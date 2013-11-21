package ar.fi.uba.td.testFramework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HandlerFileTxt {
	
	static public void writeLineOnFile(File file,String line) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter writer = new PrintWriter(file);
		writer.println();
		fileWriter.close();
	}
	
	static public String readLineOfFile(File file,int number) throws IOException {
		int count = 0;
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String linea = buffer.readLine();
		while (linea != null && number > count) {
			count++;
			linea = buffer.readLine();
		}
		return linea;
	}
}
