package testFramework;
import java.util.ArrayList;


public class TestSuit implements Runable {

	private ArrayList<Runable> testList;
	
	public TestSuit() {
		testList = new ArrayList<Runable>();
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
}
