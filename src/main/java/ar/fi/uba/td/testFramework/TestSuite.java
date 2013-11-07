package ar.fi.uba.td.testFramework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that groups a set of BaseTests, modeling a test suite. This class works
 * as the composite on the composite pattern.
 */
public class TestSuite implements RunnableTest {

	private ArrayList<RunnableTest> testList;
	private String name;
	private TestContext context;
	
	public TestSuite(String name) {
		testList = new ArrayList<RunnableTest>();
		this.name = name;
		this.context = new TestContext();
	}
	
	private boolean repeatedName(String name){
		for (RunnableTest test: this.testList) {
			if(test.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public boolean add(RunnableTest test){
		if(!repeatedName(test.getName())){
			testList.add(test);
			return true;
		}
		return false;
	}
	
	public void run(TestInformation information) {
		String fullTestName = information.getParentName() + "." + this.name;
		information.setParentName(fullTestName);
		
		information.getResults().addToOutputTestSuite(fullTestName);
//		Collections.sort(testList);
		
		
		for (RunnableTest entity : this.testList) {
			this.setUp();
	//		information.getResults().addToOutput("Results for Test Suite: " + this.name);
			entity.run(information.clone());
			this.tearDown();
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
	
	public TestContext getContext() {
		return this.context;
	}
	
	public int compareTo(Object test) { 
	        return 1;
	}

	public void setUp() {}

	public void tearDown() {}

}
