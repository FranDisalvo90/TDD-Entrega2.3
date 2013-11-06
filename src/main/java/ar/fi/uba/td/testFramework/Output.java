package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

public class Output {
	
	private ArrayList<Output> otherTest;
	private ArrayList<String> passedTestsNames;
	private ArrayList<String> failedTestsNames;
	private ArrayList<String> errorTestsNames;
	
	private String name;
	
	public Output(String name) {
		this.name = name;
		this.otherTest = new ArrayList<Output>();
		this.failedTestsNames = new ArrayList<String>();
		this.passedTestsNames = new ArrayList<String>();
		this.errorTestsNames = new ArrayList<String>();
	}
	
	void addOutput(Output newOutput) {
		this.otherTest.add(newOutput);
	}
	
	public boolean showResults(String prefix) {
		for (Output output : otherTest) {
			output.showResults(prefix+"."+this.name);
		}
		this.showMyTest(prefix);
		return this.getGlobalResult();
	}

	private boolean getGlobalResult() {
		// TODO Auto-generated method stub
		return false;
	}

	private void showMyTest(String prefix) {
		// TODO Auto-generated method stub	
	}
	
	public void addPassedTest(String name) {
		this.passedTestsNames.add(name);
	}

	public void addFailedTest(String name, String string) {
		this.failedTestsNames.add(name);
	}
	
	public void addErrorTest(String name, String string){
		this.errorTestsNames.add(name);
	}

	public int getNumberOfPassedTests() {
		return this.passedTestsNames.size();
	}

	public int getNumberOfFailedTests() {
		return this.failedTestsNames.size();
	}

	public int getNumberOfErrorTests() {
		return this.errorTestsNames.size();
	}
	
	public int getNumberOfTotalTest() {
		return (this.getNumberOfErrorTests() +
				this.getNumberOfFailedTests() +
				this.getNumberOfPassedTests());
	}

	public ArrayList<String> getFailedTestsMessages() {
		return failedTestsNames;
	}
}
