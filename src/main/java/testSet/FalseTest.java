package testSet;
import testFramework.BaseTest;
import testFramework.TestFailedException;


public class FalseTest extends BaseTest {

	@Override
	public void runTest() throws TestFailedException{

		this.assertTrue(false, "Testing assertTrue: fail result ");
	
	}

}
