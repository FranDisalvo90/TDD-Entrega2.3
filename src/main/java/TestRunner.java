
public class TestRunner {
	BaseTest testList[];
	
	public TestRunner(BaseTest[] testList){
		this.testList = testList;
	}
	
	public void RunTests() {
		Output testOutput = new Output();
		for (BaseTest test : testList) { 
			testOutput.add(test.run());
		}
		//Sacar Output por pantalla
	}
}
