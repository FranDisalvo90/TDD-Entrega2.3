package ar.fi.uba.td.testFramework;

public class StoreObject {
	
	private String name;
	private String status;
	
	public StoreObject(String name, String status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}
	
}
