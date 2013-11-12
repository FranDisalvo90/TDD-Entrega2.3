package ar.fi.uba.td.testFramework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileTestOutput extends TestOutput {

	private ArrayList<String> output;
	private static String FILE_EXTENSION = ".txt";

	public FileTestOutput() {
		super();
		output = new ArrayList<String>();
	}

	@Override
	public void startTestSuiteOutput(String testSuiteName) {
		this.output.add("\n");
		this.output.add(testSuiteName);
		this.output.add("-----------------------------");
	}

	@Override
	public void endTestCaseOutput(String testName, TestStatus testStatus, long runTime) {
		this.output.add(testStatus.toString() + " " + testName + " time: " + String.valueOf(runTime) + " ns.");
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
	public void endTestOutput(TestResults testResults) {
		this.printResultsToFile(testResults, getFileName() + FILE_EXTENSION);
	}

}
