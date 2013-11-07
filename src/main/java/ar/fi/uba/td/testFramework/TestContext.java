package ar.fi.uba.td.testFramework;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class TestContext implements Cloneable {
	
	private Hashtable<String, Cloneable> context;
	
	public TestContext() {
		this.context = new Hashtable<String, Cloneable>();
	}
	
	public boolean addElement(String key, Cloneable instance) {
		if(key == null || context.containsKey(key))
				return false;
		context.put(key, instance);
		return true;
	}

	public Cloneable getElement(String key) {
		if(!context.containsKey(key))
			return null;
		return context.get(key);
	}
	
	public Collection<Cloneable> getElements() {
		return context.values();
	}
	
	public TestContext clone() {
		TestContext newContext = new TestContext();
		Enumeration<String> keys = context.keys();
		
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			newContext.addElement(key, context.get(key));
		}
		
		return newContext;			
	}
	
	
}
