package testFramework;


public interface Runable {
	
	public void run(TestOutput testOutput);
	public void add(Runable test);

}
