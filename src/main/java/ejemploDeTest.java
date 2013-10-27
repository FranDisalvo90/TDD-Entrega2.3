
public class ejemploDeTest extends BaseTest {

	@Override
	public void run(int iterator) throws TestFailedException,NoMoreTestException {
		switch (iterator) {
			case 1:  this.Hello();
			break;
			case 2:  this.Bye();
			break;
			default: this.noMoreTest();
			break;
		}
	}

	public void result(){
		TestOutput result = this.getOutput();
		System.out.println("number tests OK:" + result.getNumTestOK());
		System.out.println("number tests Fail:" + result.getNumTestFailure());
	}
	
	private void Bye() throws TestFailedException {
		this.assertTrue(false, "Bye");
	}

	private void Hello() throws TestFailedException {
		this.assertFalse(true, "Hello");
	}
}
