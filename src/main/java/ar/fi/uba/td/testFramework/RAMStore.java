package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

public class RAMStore implements Saveable {
	
	private ArrayList<StoreObject> store;
	
	public RAMStore(){
		store = new ArrayList<StoreObject>();
	}
	
	@Override
	public void saveInformationRun(TestCase test) {
		StoreObject storeElement = new StoreObject(test.getName(),test.getStatus(),test.getTime());
		store.add(storeElement);
	}

}
