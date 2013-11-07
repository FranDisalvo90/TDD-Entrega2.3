package ar.fi.uba.td.testFramework;

public class TestInformation implements Cloneable {
	
	private TestContext context;
	private String regExp;
	private TestResults results;
	private String parentName;
	
	public TestInformation() {
		this.regExp = ".*";
		initialize();
	}
	
	public TestInformation(String regExpression) {
		this.regExp = regExpression;
		initialize();
	}
	
	private void initialize(){
	    	this.context = new TestContext();
		this.results = new TestResults();
	}
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	private TestInformation(String regExp, TestContext context, TestResults results, String parentName) {
		this.regExp = regExp;
		this.context = context;
		this.results = results;
		this.parentName = parentName;
	}

	public TestContext getContext() {
		return context;
	}

	public void setContext(TestContext context) {
		this.context = context;
	}

	public String getRegExp() {
		return regExp;
	}

	public TestResults getResults() {
		return results;
	}
	
	public TestInformation clone() {
		return new TestInformation(this.regExp, this.context.clone(), results, this.parentName);
	}
	

}
