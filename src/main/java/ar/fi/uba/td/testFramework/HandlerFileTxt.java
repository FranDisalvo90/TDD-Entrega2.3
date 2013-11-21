package ar.fi.uba.td.testFramework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HandlerFileTxt {
	
	static public void writeLineOnFile(String fileName,String line) {
		FileWriter fileWritter;
		BufferedWriter writeBuffer;
		try {
		    fileWritter = new FileWriter(fileName,true);
		    writeBuffer = new BufferedWriter(fileWritter);
		    writeBuffer.write(line);
		    writeBuffer.newLine();
		    writeBuffer.flush();
		    fileWritter.close();
		}
		catch(IOException e) {
			System.out.println("El archivo no puede ser abierto");
		}
	}
	
	static public String readLineOfFile(String fileName,int number) {
		int count = 0;
		String line  = null;
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(reader);
			line = buffer.readLine();
			while (line != null && number > count) {
				count++;
				line = buffer.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("El archivo no existe o no pueede leerse");
		}
		return line;
	}
}
