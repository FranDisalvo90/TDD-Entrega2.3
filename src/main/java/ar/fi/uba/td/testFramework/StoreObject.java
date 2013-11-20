package ar.fi.uba.td.testFramework;

public class StoreObject {
	
	private String name;
	private String status;
	private long time;
	
	public StoreObject(String name, String status, long time) {
		this.name = name;
		this.status = status;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public long getTime() {
		return time;
	}
	
}
