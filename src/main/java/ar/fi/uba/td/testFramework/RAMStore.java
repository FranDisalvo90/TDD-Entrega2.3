package ar.fi.uba.td.testFramework;

import java.util.ArrayList;


public class RAMStore extends Store {
	
	private ArrayList<StoreObject> store;
	
	public RAMStore(){
		super();
		store = new ArrayList<StoreObject>();
	}
	
	public void saveInformationRun(RunnableTest test) {
		StoreObject storeElement = new StoreObject(test.getName(),test.getStatus(),test.getTime());
		store.add(storeElement);
	}
	
	public boolean matchOnStore(RunnableTest test){
		StoreObject toCompareElement = new StoreObject(test.getName(),test.getStatus(),test.getTime());
		for (StoreObject element : store) {
			if (toCompareElement.equals(element))
				return true;
		}
		return false;
	}

}
