
public class App {

	public static void main (String [ ] args) 
	    { 
	        Runable testPrincipal = new TestSuit();
	        Runable testFunc1 = new TestSuit();
	        Runable ej = new ejemploDeTest();
	        
	        testFunc1.add(ej);
	        testPrincipal.add(testFunc1);
	        
	        TestRunner testRunner = new TestRunner(testPrincipal);
	        testRunner.runTests();
	     } 
	
	
}
