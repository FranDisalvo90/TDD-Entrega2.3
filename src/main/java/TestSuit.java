
public class TestSuit implements Runable {
	private TestOutput output;
	private Runable[] testlist;
	
	TestSuit(BaseTest[] testlist) {
		this.testlist = testlist;
		this.setOutput(new TestOutput());
	}
	public void run() {
		for (Runable entity: this.testlist){
			entity.run();
		}
	}

	public TestOutput getOutput() {
		return this.output;
	}
	public void setOutput(TestOutput test_output) {
		this.output = test_output;
		for(Runable entity: this.testlist){
			entity.setOutput(this.output);
		}
	}

}
