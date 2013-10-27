
public class Output {

	private TestOutput testOutput;
	
	public Output(TestOutput testOutput){
		this.testOutput = testOutput;
	}
	
	public void add(TestOutput testOutput) {
		// TODO Auto-generated method stub		
	}
	
	//TODO calcular los test totales (recursiva en el testRunner)
	public void showResult(){
		System.out.println("Total test: ....");
		System.out.println("Number tests OK:" + testOutput.getNumTestOK());
		System.out.println("Number tests Fail:" + testOutput.getNumTestFailure());
		System.out.println("Failure messages: ");
		testOutput.printFailureMessage();
	}
	
}
