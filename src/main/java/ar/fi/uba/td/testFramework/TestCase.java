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

	public TestCase(String nameTest) {
		this.name = nameTest;
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

		String status;
		Timer timer = new Timer();
		this.setUp(information.getContext());
		timer.start();
		try {
			this.runTest(information.getContext());
			information.getResults().addPassedTest();
			status = "[ok] ";
		} catch (TestFailedException ex) {
			information.getResults().addFailedTest();
			status = "[fail] ";
		} catch (Exception ex) {
			information.getResults().addErrorTest();
			status = "[error] ";
		} finally {
			testTime = timer.getTotalTime();
		}
		this.tearDown(information.getContext());

		information.getResults().addToOutput(
				status + name + " time: " + String.valueOf(testTime) + " ns");
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
		for (String element : tags) {
			if (this.tags.contains(element))
				return true;
		}
		return false;
	}

	public int getTestCount(TestInformation information) {
		return this.isRunnable(information) ? 1 : 0;
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
