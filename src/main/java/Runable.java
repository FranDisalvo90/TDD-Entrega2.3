
public interface Runable {
	//Run a suit of test, or a simple test
	public void run();
	public TestOutput getOutput();
	public void setOutput(TestOutput test_output);
}
