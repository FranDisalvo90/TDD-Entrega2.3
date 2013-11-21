package ar.fi.uba.td.testFramework;

import java.io.File;


public class FileBasedStore extends Store{
	
	File store;
	String fileName;
	File temporalStore;
	
	public FileBasedStore(String nameOfFileStore) {
		super();
		store = new File(nameOfFileStore);
		temporalStore = new File("store.tmp");
	}

	@Override
	public void saveInformationRun(RunnableTest test) {
		String lineFile = test.getName() + "/" + test.getStatus();
		HandlerFileTxt.writeLineOnFile(temporalStore.getName(),lineFile);	
	}

	@Override
	public boolean onStore(RunnableTest test) {
		String line;
		int count = 0;
		line = HandlerFileTxt.readLineOfFile(store.getName(),count);
		while (line != null) {
			count++;
			StoreObject element = stringToStoreObject(line);
			if (test.getName() == element.getName() && element.getStatus() != "OK")
				return true;
			line = HandlerFileTxt.readLineOfFile(store.getName(),count);
		}
		return false;
	}

	@Override
	public void refresh() {
		store = temporalStore;
		temporalStore = new File("store.tmp");
	}
	
	protected StoreObject stringToStoreObject(String line) {
		int position = line.indexOf("/");
		String name	= line.substring(0,position);
		String status = line.substring(position+1);
		StoreObject element = new StoreObject(name, status);
		return element;
	}
}
