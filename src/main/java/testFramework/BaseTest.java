package testFramework;


public abstract class BaseTest extends Comparator implements Runable{

	public abstract void runTest() throws TestFailedException;

	public void add(Runable test){
		//this is a leaf node
	}

	public void run(TestOutput testOutput) {
		try {
			this.runTest();
			testOutput.testOk();
		}catch(Exception ex){
			//Any type of error
			testOutput.testError(ex.getMessage());
		}
	}
}
