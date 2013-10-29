package ar.fi.uba.td.testFramework;

public interface RunnableTest {

	public void run(TestOutput testOutput);

	public void add(RunnableTest test);

}
