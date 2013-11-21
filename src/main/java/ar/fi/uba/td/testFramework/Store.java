package ar.fi.uba.td.testFramework;


public abstract class Store {
	
	private boolean state;
	
	public Store() {
		state = false;
	}
	
	public abstract void saveInformationRun(RunnableTest test);
	
	public abstract boolean onStore(RunnableTest test);
	
	public abstract void refresh();
	
	public void active() {
		state = true;
	}
	
	public void desactive() {
		state = false;
	}
	
	public boolean isActive() {
		return state;
	}
}
