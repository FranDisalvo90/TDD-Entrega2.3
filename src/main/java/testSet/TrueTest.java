package testSet;

import testFramework.BaseTest;
import testFramework.TestFailedException;

public class TrueTest extends BaseTest {
	
	@Override
	public void runTest() throws TestFailedException{
		this.assertTrue(true, "Testing assertTrue: ok result");
	}
	
}



