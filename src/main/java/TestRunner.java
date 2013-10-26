
public class TestRunner {
	Runable testList[];
	
	public TestRunner(Runable[] testList){
		this.testList = testList;
	}
	
	public void RunTests() {
		Output testOutput = new Output();
		for (Runable test : testList) { 
			test.run();
			TestOutput test_output = test.getOutput();
			testOutput.add(test_output);
		}
		//Sacar Output por pantalla
	}
}
