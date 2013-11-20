package ar.fi.uba.td.testFramework;

public abstract class Store {
	
	public abstract void saveInformationRun(RunnableTest test);
	
	public abstract boolean matchOnStore(RunnableTest test);
	
}
