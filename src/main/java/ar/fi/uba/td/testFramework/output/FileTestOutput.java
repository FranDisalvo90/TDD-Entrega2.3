package ar.fi.uba.td.testFramework.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import ar.fi.uba.td.testFramework.TestResults;
import ar.fi.uba.td.testFramework.TestStatus;

public class FileTestOutput extends TestOutput {

	private static String FILE_EXTENSION = ".txt";
	private ArrayList<String> output;

	public FileTestOutput() {
		super();
		output = new ArrayList<String>();
	}

	@Override
	public void endTestCaseOutput(String testName, TestStatus testStatus, long runTime) {
		this.output.add(testStatus.toString() + " " + testName + " time: " + String.valueOf(runTime) + " ns.");
	}

	@Override
	public void endTestOutput(TestResults testResults) {
		this.printResultsToFile(testResults, getFileName() + FILE_EXTENSION);
	}

	private void printResultsToFile(TestResults testResults, String fileName) {
		FileWriter file;
		BufferedWriter writeBuffer;
		try {
			file = new FileWriter(fileName);
			writeBuffer = new BufferedWriter(file);

			/* Writes the report title. */
			writeBuffer.write("Test results:");

			/* Writes the results for each test in each TestCase. */
			for (String line : this.output) {
				writeBuffer.write(line);
				writeBuffer.newLine();
				writeBuffer.flush();
			}

			/* Writes the results of the entire run. */
			writeBuffer
					.write("----------------------------------------------\n");
			writeBuffer
					.write("----------------------------------------------\n");
			writeBuffer.write("Run: " + testResults.getNumberOfTotalTest()
					+ "\n");
			writeBuffer.write("Passed: " + testResults.getNumberOfPassedTests()
					+ "\n");
			writeBuffer.write("Failed: " + testResults.getNumberOfFailedTests()
					+ "\n");
			writeBuffer.write("Error: " + testResults.getNumberOfErrorTests()
					+ "\n");
			writeBuffer.flush();

			writeBuffer.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void startTestSuiteOutput(String testName, String testSuiteName) {
		this.output.add(testSuiteName);
		this.output.add("-----------------------------");
	}
	
	@Override
	public void endTestSuiteOutput() { 
		this.output.add("\n");
	}

}
