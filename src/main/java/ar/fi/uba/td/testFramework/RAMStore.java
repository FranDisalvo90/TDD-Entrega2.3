package ar.fi.uba.td.testFramework;

import java.util.ArrayList;


public class RAMStore extends Store {
	
	private ArrayList<StoreObject> store;
	private ArrayList<StoreObject> storeAuxiliar;
	
	public RAMStore(){
		super();
		store = new ArrayList<StoreObject>();
		storeAuxiliar = new ArrayList<StoreObject>();
	}
	
	public void saveInformationRun(RunnableTest test) {
		StoreObject storeElement = new StoreObject(test.getName(),test.getStatus(),test.getTime());
		storeAuxiliar.add(storeElement);
	}
	
	
	
	public boolean onStore(RunnableTest test){
		for (StoreObject element : store) {
			if (test.getName() == element.getName() && element.getStatus() != "OK")
				return true;
		}
		return false;
	}
	
	public void refresh() {
		store = storeAuxiliar;
		storeAuxiliar = new ArrayList<StoreObject>();
	}

	@Override
	public ArrayList<StoreObject> getStore() {
		return store;
	}

}
