package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

import ar.fi.uba.td.testFramework.output.TestLogger;

public class TestInformation implements Cloneable {

	private TestContext context;
	private TestLogger logger;
	private String parentName;
	private String regExp;
	private TestResults results;
	private ArrayList<String> tags;

	public TestInformation() {
		this.context = new TestContext();
		this.results = new TestResults();
		this.regExp = ".*";
		this.tags = new ArrayList<String>();
		this.parentName = "";
		this.logger = new TestLogger();
	}

	/* Private constructor used by the clone() method. */
	private TestInformation(String regExp, TestContext context,
			TestResults results, String parentName, ArrayList<String> tags,
			TestLogger logger) {
		this.regExp = regExp;
		this.context = context;
		this.results = results;
		this.parentName = parentName;
		this.tags = tags;
		this.logger = logger;
	}

	public TestInformation clone() {
		return new TestInformation(this.regExp, this.context.clone(), results,
				this.parentName, this.tags, this.logger);
	}

	public TestContext getContext() {
		return context;
	}
	
	public TestLogger getLogger() {
		return logger;
	}

	public String getParentName() {
		return parentName;
	}

	public String getRegExp() {
		return regExp;
	}

	public TestResults getResults() {
		return results;
	}

	public ArrayList<String> getTags() {
		return this.tags;
	}

	public void setContext(TestContext context) {
		this.context = context;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void setRegExp(String regExpression) {
		this.regExp = regExpression;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

}
