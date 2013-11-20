package ar.fi.uba.td.testFramework;

import java.util.HashMap;


public class TestPerformance extends TestCase {
	
	TestCase test;
	long maxTimeExpected;
	String internalTestFailureMessage = "Internal test failed. Could not run performance test";
	String internalTestErrorMessage = "Internal test errored. Could not run performance test";
	String performanceTestFailMessage = "Performance test failed. Execution time was greater than maximum time expected";

	public TestPerformance(String testName, TestCase test, long maxTimeExpected) {
		super(testName);
		this.test = test;
		this.maxTimeExpected = maxTimeExpected;
	}

	@Override
	public void runTest(TestContext context) throws Exception {
		TestInformation testInformation = new TestInformation();
		HashMap<String, Integer> previousResultsMap = new HashMap<String, Integer>();
		HashMap<String, Integer> resultsMap = new HashMap<String, Integer>();
		TestResults previousResults = testInformation.getResults();
		addResultsToHash(previousResultsMap, previousResults);
		//test.run(testInformation);
		long totalTimeTaken = test.getTime();
		TestResults results = testInformation.getResults();
		addResultsToHash(resultsMap, results);
		analizeInternalTestSuccess(previousResultsMap, resultsMap);
		Assert.assertPerformance(totalTimeTaken, maxTimeExpected, performanceTestFailMessage);
	}
	
	private void analizeInternalTestSuccess(HashMap<String, Integer> previousResults,
			HashMap<String, Integer> results) throws Exception {
		if (results.get("error") > previousResults.get("error")) {
			throw new Exception(internalTestErrorMessage);
		} else if(results.get("failure") > previousResults.get("failure")) {
			Assert.fail(internalTestFailureMessage);
		}
	}
	
	private void addResultsToHash(HashMap<String, Integer> map, TestResults results) {
		map.put("success", results.getNumberOfPassedTests());
		map.put("error", results.getNumberOfErrorTests());
		map.put("failure", results.getNumberOfFailedTests());
	}

}
