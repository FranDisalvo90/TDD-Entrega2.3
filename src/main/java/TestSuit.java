import java.util.ArrayList;


public class TestSuit implements Runable {
//	private TestOutput output;
	private ArrayList<Runable> testList;
	
	TestSuit() {
		testList = new ArrayList<Runable>();
//		this.setOutput(new TestOutput());
	}
	
	public void add(Runable test) {
		testList.add(test);
	}
	
	//TODO: TestSuit vacios => exception
	
	public void run(TestOutput testOutput) {
		for (Runable entity: this.testList){
			entity.run(testOutput);
		}
	}
/*
	public TestOutput getOutput() {
		return this.output;
	}
	public void setOutput(TestOutput test_output) {
		this.output = test_output;
		for(Runable entity: this.testList){
			entity.setOutput(this.output);
		}
	}
*/
}
