package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

public class TestInformation implements Cloneable {

	private TestContext context;
	private String regExp;
	private TestResults results;
	private String parentName;
	private ArrayList<String> tags;
	private TestLogger logger;

	public TestLogger getLogger() {
		return logger;
	}

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
			TestResults results, String parentName, ArrayList<String> tags, TestLogger logger) {
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
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

	public void setRegExp(String regExpression) {
		this.regExp = regExpression;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public ArrayList<String> getTags() {
		return this.tags;
	}

}
