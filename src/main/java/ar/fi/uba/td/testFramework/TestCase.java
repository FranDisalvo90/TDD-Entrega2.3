package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class TestCase extends Comparator implements RunnableTest {

	private String name;
	private ArrayList<String> tags;
	private long testTime;
	private TestStatus status;

	public TestCase(String testName) {
		this.status = TestStatus.NOT_RUN;
		this.name = testName;
		this.tags = new ArrayList<String>();
		this.testTime = 0;
	}

	/**
	 * Abstract method where the user will define the actual test.
	 */
	public abstract void runTest(TestContext context) throws Exception;

	private boolean regularExpressionMatches(String regExp) {
		return this.name.matches(regExp);
	}

	public void run(TestInformation information) {
		if (!isRunnable(information))
			return;

		Timer timer = new Timer();
		this.setUp(information.getContext());
		timer.start();
		try {
			this.runTest(information.getContext());
			information.getResults().addPassedTest();
			this.status = TestStatus.OK;
		} catch (TestFailedException ex) {
			information.getResults().addFailedTest();
			this.status = TestStatus.FAILED;
		} catch (Exception ex) {
			information.getResults().addErrorTest();
			this.status = TestStatus.ERROR;
		} finally {
			testTime = timer.getTotalTime();
		}
		this.tearDown(information.getContext());

		information.getResults().addTestCaseResultToOutput(this.name, this.status, testTime);
	}

	private boolean isRunnable(TestInformation information) {
		String regExp = information.getRegExp();
		ArrayList<String> tags = information.getTags();
		return regularExpressionMatches(regExp) && tagsMatch(tags)
				&& !isToSkip();
	}

	private boolean isToSkip() {
		return this.tags.contains("SKIP");
	}

	private boolean tagsMatch(ArrayList<String> tags) {
		if (tags.isEmpty())
			return true;
		for (String tag : tags) {
			if (this.tags.contains(tag))
				return true;
		}
		return false;
	}

	public int getTestCount(TestInformation information) {
		return this.isRunnable(information) ? 1 : 0;
	}
	
	public int getTestCount() {
		return 1;
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

	public void addTag(String tag) {
		this.tags.add(tag);
	}

	public void addTags(ArrayList<String> tags) {
		this.tags.addAll(tags);
	}

	public boolean removeTag(String tag) {
		return this.tags.remove(tag);
	}

}
