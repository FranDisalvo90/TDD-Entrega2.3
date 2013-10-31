package ar.fi.uba.td.testFramework;

/**
 * Class used to display the test results.
 */
public class Output {

	private TestOutput testOutput;

	public Output(TestOutput testOutput) {
		this.testOutput = testOutput;
	}

	public void add(TestOutput testOutput) {
		// TODO Auto-generated method stub
	}

	// TODO calcular los test totales (recursiva en el testRunner)
	public void showResult() {
		System.out.println("Total tests: ....");
		System.out.println("Tests OK: " + testOutput.getNumTestOK());
		System.out.println("Tests failed: "
				+ testOutput.getNumTestFailure());
		System.out.println("Failure messages: ");
		testOutput.printFailureMessage();
	}

}
