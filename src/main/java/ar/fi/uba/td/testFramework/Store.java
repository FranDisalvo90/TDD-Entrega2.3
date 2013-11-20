package ar.fi.uba.td.testFramework;

public abstract class Store {
	
	public abstract void saveInformationRun(TestCase test);
	
	public abstract boolean matchOnStore(TestCase test);
	
}
