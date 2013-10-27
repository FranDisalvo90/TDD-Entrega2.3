
public interface Runable {
	//Run a suit of test, or a simple test
	public void run(TestOutput testOutput);
	public void add(Runable test);
//	public TestOutput getOutput();
//	public void setOutput(TestOutput testOutput);
}
