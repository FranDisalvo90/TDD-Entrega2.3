
public abstract class BaseTest extends Comparator implements Runable{
	private static final String NO_MORE_TEST = "No method to test";
	protected int iterator;	
	private TestOutput output;
	
	public abstract void run(int iterator) throws TestFailedException, NoMoreTestException;
	
	BaseTest() {
		this.iterator = 0;
		this.output = new TestOutput();
	}
	
		
	public void setOutput(TestOutput output) {
		this.output = output;
	}

	public void noMoreTest() throws NoMoreTestException {
		throw new NoMoreTestException(NO_MORE_TEST);
	}
	
	public TestOutput getOutput(){
		return this.output;
	}
	
	public void run() {
		boolean noMoreTest = true; 
		while(noMoreTest) {
			this.iterator++;
			try {
				this.run(this.iterator);
				this.output.testOk();
			}catch (NoMoreTestException ex) {
				noMoreTest = false;
			}catch(Exception ex){
				//Any type of error
				this.output.testError(ex.getMessage());
			}
		}
	}
}
