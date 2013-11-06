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
	
	public void showResults(String prefix) {
		for (Output output : otherTest) {
			output.showResults(prefix+"."+this.name);
		}
		this.showMyTest(prefix+"."+this.name);
	}

	private void showMyTest(String name) {
		System.out.println(name);
		System.out.println("-------------");
		this.printOks();
		this.printError();
		this.printFail();
		System.out.println("==============");
		System.out.println("Tests OK: " + this.getNumberOfPassedTests());
		System.out.println("Tests ERROR: "+ this.getNumberOfErrorTests());
		System.out.println("Tests failed: "+ this.getNumberOfFailedTests());
	}
	
	private void printFail() {
		for(String fail: this.failedTestsNames) {
			System.out.println(fail + "  [ERROR]");
		}
	}

	private void printError() {
		for(String error: this.errorTestsNames) {
			System.out.println(error + "  [ERROR]");
		}		
	}

	private void printOks() {
		for(String ok: this.passedTestsNames) {
			System.out.println(ok + "  [OK]");
		}
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
