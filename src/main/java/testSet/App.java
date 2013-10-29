package testSet;

import testFramework.*;


public class App {

	public static void main (String [ ] args) 
	    { 
	        Runable testPrincipal = new TestSuit();
	        Runable testBoolean = new TestSuit();
	        Runable testFalse = new FalseTest();
	        Runable testTrue = new TrueTest();
	        
	        testBoolean.add(testTrue);
	        testBoolean.add(testFalse);
	        testPrincipal.add(testBoolean);
	        
	        TestRunner testRunner = new TestRunner(testPrincipal);
	        testRunner.runTests();
	     } 
	
	
}
