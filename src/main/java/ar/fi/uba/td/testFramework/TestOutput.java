package ar.fi.uba.td.testFramework;

import java.io.BufferedWriter;
import java.io.FileWriter;


/**
 * Class used to display the test results.
 */
public class TestOutput {

	private TestResults testResults;

	public TestOutput(TestResults testResults) {
		this.testResults = testResults;
	}
	
	public void showTrace(){
	    	
	    	FileWriter file;
	    	BufferedWriter writeBuffer;
		try {
		    file = new FileWriter("Report.txt");
		    writeBuffer = new BufferedWriter(file);
		    for (String line : testResults.getOutput()){
			writeBuffer.write(line);
			writeBuffer.newLine();
			writeBuffer.flush();
	           }	
		    writeBuffer.write("----------------------------------------------\n");
		    writeBuffer.write("----------------------------------------------\n");
		    writeBuffer.write("Run: "+ testResults.getNumberOfTotalTest() + "\n");
		    writeBuffer.write("Passed: " + testResults.getNumberOfPassedTests() + "\n");
		    writeBuffer.write("Failed: "+ testResults.getNumberOfFailedTests() + "\n");
		    writeBuffer.write("Error: "+ testResults.getNumberOfErrorTests() + "\n");
		    writeBuffer.flush();	
	           
	           writeBuffer.close(); 
	        } catch (Exception e) {
	             System.out.println(e);
	        }

	}

}
