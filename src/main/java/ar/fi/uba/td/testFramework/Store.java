package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

public abstract class Store {
	
	private boolean state;
	
	public Store() {
		state = false;
	}
	
	public abstract void saveInformationRun(RunnableTest test);
	
	public abstract boolean onStore(RunnableTest test);
	
	public abstract void refresh();
	
	public abstract ArrayList<StoreObject> getStore();
	
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
