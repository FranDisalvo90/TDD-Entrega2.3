package ar.fi.uba.td.testFramework;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

public class FileBasedStore extends Store{
	
	File store;
	File temporalStore;
	
	public FileBasedStore(String nameOfFileStore) {
		super();
		store = new File(nameOfFileStore);
		temporalStore = new File("store.tmp");
	}

	@Override
	public void saveInformationRun(RunnableTest test) throws IOException {
		String lineFile = test.getName() + "/" + test.getStatus();
		HandlerFileTxt.writeLineOnFile(temporalStore, lineFile);	
	}

	@Override
	public boolean onStore(RunnableTest test) throws IOException {
		String line;
		int count = 0;
		line = HandlerFileTxt.readLineOfFile(store,count);
		while (line != null) {
			count++;
			StoreObject element = stringToStoreObject(line);
			if (test.getName() == element.getName() && element.getStatus() != "OK")
				return true;
			line = HandlerFileTxt.readLineOfFile(store,count);
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
		String name	= line.substring(0,position-1);
		String status = line.substring(position+1);
		StoreObject element = new StoreObject(name, status);
		return element;
	}
}
