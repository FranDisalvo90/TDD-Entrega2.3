
public abstract class BaseTest extends Comparator {
	private static final String NO_MORE_TEST = "No method to test";
	private int iterator;	
	
	public abstract void run(int iterator) throws TestFailedException, NoMoreTestException;
	
	BaseTest() {
		this.iterator = 0;
	}
		
	public void noMoreTest() throws NoMoreTestException {
		throw new NoMoreTestException(NO_MORE_TEST);
	}
	
	public TestOutput run() {
		TestOutput _testOutput = new TestOutput();
		boolean noMoreTest = true; 
		while(noMoreTest) {
			this.iterator++;
			try {
				this.run(this.iterator);
				_testOutput.testOk();

			} catch (TestFailedException ex) {
				_testOutput.testError(ex.getMessage());

			}catch (NoMoreTestException ex) {
				noMoreTest = false;
			}
		}
		return _testOutput;		
	}
}
