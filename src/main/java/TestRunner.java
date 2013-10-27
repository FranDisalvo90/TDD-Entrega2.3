
public class TestRunner {
//	Runable testList[];
	Runable test;
//	public TestRunner(Runable[] testList){
//		this.testList = testList;
//	}
	
	public TestRunner(Runable test){
		this.test = test;
	}
	
	public void runTests() {
//		Output testOutput = new Output();
//		for (Runable test : testList) { 
		TestOutput testOutput = new TestOutput();
		test.run(testOutput);
//			TestOutput test_output = test.getOutput();
//			testOutput.add(test_output);
//		}
		//Sacar Output por pantalla
		Output output = new Output(testOutput);
		output.showResult();
	}
}
