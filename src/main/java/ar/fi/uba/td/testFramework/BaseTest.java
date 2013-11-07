package ar.fi.uba.td.testFramework;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class BaseTest extends Comparator implements RunnableTest {

	private String regExp;
	private String name;

	public BaseTest(String nameTest) {
		this.name = nameTest;
		this.regExp = ".*"; 
	}

	/**
	 * Abstract method where the user will define the actual test.
	 */
	public abstract void runTest(TestContext context) throws Exception;

	private boolean regularExpressionMatches() {
		return this.name.matches(this.regExp);
	}

	public void run(TestInformation information) {
		this.regExp = information.getRegExp();
		if (!regularExpressionMatches())
			return;

		this.setUp(information.getContext());

		try {
			this.runTest(information.getContext());
			information.getResults().addPassedTest();
			information.getResults().addToOutput("[ok] " + name);
		}

		catch (TestFailedException ex) {
			information.getResults().addFailedTest();
			information.getResults().addToOutput("[fail] " + name);
		}

		catch (Exception ex) {
			information.getResults().addErrorTest();
			information.getResults().addToOutput("[error] " + name);
		}

		this.tearDown(information.getContext());
	}

	public int countTest() {
		return regularExpressionMatches() ? 1 : 0;
	}

	public String getName() {
		return name;
	}

	public void setUp(TestContext context) {
	}

	public void tearDown(TestContext context) {
	}

	public int compareTo(RunnableTest test) {
		return -1;
	}

}
