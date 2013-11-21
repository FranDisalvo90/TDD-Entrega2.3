package ar.fi.uba.td.testFramework;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Store {
	
	private boolean state;
	
	public Store() {
		state = false;
	}
	
	public abstract void saveInformationRun(RunnableTest test) throws IOException;
	
	public abstract boolean onStore(RunnableTest test) throws IOException;
	
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
