package ar.fi.uba.td.testFramework;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class TestContext implements CloneableObject {
	
	private Hashtable<String, CloneableObject> context;
	
	public TestContext() {
		this.context = new Hashtable<String, CloneableObject>();
	}
	
	public boolean addElement(String key, Object instance) {
		if(key == null || context.containsKey(key))
				return false;
		context.put(key, (CloneableObject) instance);
		return true;
	}

	public Object getElement(String key) {
		if(!context.containsKey(key))
			return null;
		return context.get(key);
	}
	
	public Collection<CloneableObject> getElements() {
		return context.values();
	}
	
	public TestContext clone() {
		TestContext newContext = new TestContext();
		Enumeration<String> keys = context.keys();
		
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			newContext.addElement(key,  context.get(key).clone());
		}
		
		return newContext;			
	}
	
	
}
