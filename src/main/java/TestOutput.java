import java.util.ArrayList;

public class TestOutput {

	private int numTestOK;
	private int numTestFailure;
	private ArrayList<String> testFailure;
	
	public TestOutput(){
		numTestOK = 0;
		numTestFailure = 0;
		testFailure = new ArrayList<String>();
	}
	
	public void testOk() {
		numTestOK++;	
	}

	public void testError(String message) {
		numTestFailure++;
		testFailure.add(message);		
	}
	
	public int getNumTestOK(){
		return numTestOK;
	}
	
	public int getNumTestFailure(){
		return numTestFailure;
	}
}
