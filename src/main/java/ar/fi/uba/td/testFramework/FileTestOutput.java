package ar.fi.uba.td.testFramework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileTestOutput implements TestOutput {

	private ArrayList<String> output;

	public FileTestOutput() {
		output = new ArrayList<String>();
	}

	public void addTestSuiteName(String testSuiteName) {
		this.output.add("\n");
		this.output.add(testSuiteName);
		this.output.add("-----------------------------");
	}

	public void addTestCaseResult(String testName, TestStatus testStatus, long runTime) {
		this.output.add(testStatus.toString() + " " + testName + " time: " + String.valueOf(runTime) + " ns.");
	}

	public void printResultsToFile(TestResults testResults, String fileName) {
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

	public void startTestOutput() {	}

	public void endTestOutput(TestResults testResults) {
		String filename = "Report-" + getCurrentTime() + ".txt";
		this.printResultsToFile(testResults, filename);
	}

	private String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
