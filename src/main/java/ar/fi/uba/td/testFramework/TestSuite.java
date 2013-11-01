package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class that groups a set of BaseTests, modeling a test suite. This class works
 * as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;
	String name;

	public TestSuite(String name) {
		testList = new ArrayList<RunnableTest>();
		this.name = name;
	}
	
	private boolean repeatedName(String name){
		for (RunnableTest test: this.testList) {
			if(test.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public void add(RunnableTest test){
		if(!repeatedName(test.getName())){
			testList.add(test);
		}
	}
	
	public void run(TestResults testOutput) {
		this.setUp();
		for (RunnableTest entity : this.testList) {
			entity.run(testOutput);
		}
	}

	public int countTest() {
		int total = 0;
		for (RunnableTest entity : this.testList) {
			total += entity.countTest();
		}
		return total;
	}
	
	public String getName(){
		return name;
	}

	public void setUp() {}

	public void tearDown() {}
}
