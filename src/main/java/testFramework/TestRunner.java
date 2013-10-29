package testFramework;


public class TestRunner {

	Runable test;

	public TestRunner(Runable test){
		this.test = test;
	}
	
	public void runTests() {

		TestOutput testOutput = new TestOutput();
		test.run(testOutput);

		Output output = new Output(testOutput);
		output.showResult();
	}
}
