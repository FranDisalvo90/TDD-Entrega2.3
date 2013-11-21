package ar.fi.uba.td.testFramework;

import java.io.File;
import java.util.ArrayList;


public class FileBasedStore extends Store{
	
	private File store;
	private ArrayList<String>linesStore; 
	
	public FileBasedStore(String nameOfFileStore) {
		super();
		store = new File(nameOfFileStore);
		linesStore = new ArrayList<String>(); 
	}

	@Override
	public void saveInformationRun(RunnableTest test) {
		String lineFile = test.getName() + "/" + test.getStatus();
		linesStore.add(lineFile);
	}

	@Override
	public boolean onStore(RunnableTest test) {
		String line;
		int count = 0;
		line = HandlerFileTxt.readLineOfFile(store.getName(),count);
		while (line != null) {
			count++;
			StoreObject element = stringToStoreObject(line);
			if (test.getName().equals(element.getName()) && element.getStatus().equals("[ok]"))
				return true;
			line = HandlerFileTxt.readLineOfFile(store.getName(),count);
		}
		return false;
	}

	@Override
	public void refresh() {
		String nameStore = store.getName();
		store.delete();
		store = new File(nameStore);
		for (String line : linesStore) {
			HandlerFileTxt.writeLineOnFile(nameStore,line);	
		}
		linesStore = new ArrayList<String>();
	}
	
	protected StoreObject stringToStoreObject(String line) {
		int position = line.indexOf("/");
		String name	= line.substring(0,position);
		String status = line.substring(position+1);
		StoreObject element = new StoreObject(name, status);
		return element;
	}
}
