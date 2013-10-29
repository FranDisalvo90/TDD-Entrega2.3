package ar.fi.uba.td.testFramework;

public class App {

	public static void main(String[] args) {
		RunnableTest testPrincipal = new TestSuite();
		RunnableTest testBoolean = new TestSuite();
		RunnableTest testFalse = new FalseTest();
		RunnableTest testTrue = new TrueTest();

		testBoolean.add(testTrue);
		testBoolean.add(testFalse);
		testPrincipal.add(testBoolean);

		TestRunner testRunner = new TestRunner(testPrincipal);
		testRunner.runTests();
	}

}
