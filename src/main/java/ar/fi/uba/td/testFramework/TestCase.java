package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

import ar.fi.uba.td.testFramework.output.TestLogger;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class TestCase implements RunnableTest {

    private String name;
    private ArrayList<String> tags;
    private TestStatus status;
    private long time;

    public TestCase(String testName) {
	this.status = TestStatus.NOT_RUN;
	this.name = testName;
	this.tags = new ArrayList<String>();
	this.time = 0;
    }

    /**
     * Abstract method where the user will define the actual test.
     */
    public abstract void runTest(TestContext context) throws Exception;

    public final void run(TestInformation information) {
	if (!isRunnable(information)) {
	    information.getResults().addSkippedTest();
	    return;
	}

	Timer timer = new Timer();
	TestLogger logger = information.getLogger();

	logger.startTestCaseOutput(this.name);

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
	    this.time = timer.getTotalTime();
	}
	this.tearDown(information.getContext());

	logger.endTestCaseOutput(this.name, this.status, this.time);
    }

    private boolean regularExpressionMatches(String regExp) {
	return this.name.matches(regExp);
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

    public final int getTestCount() {
	return 1;
    }

    public final String getName() {
	return name;
    }

    public void setUp(TestContext context) {
    }

    public void tearDown(TestContext context) {
    }

    public final int compareTo(RunnableTest test) {
	return -1;
    }

    public final void addTag(String tag) {
	this.tags.add(tag);
    }

    public final void addTags(ArrayList<String> tags) {
	this.tags.addAll(tags);
    }

    public final boolean removeTag(String tag) {
	return this.tags.remove(tag);
    }

    public long getTime() {
	return time;
    }
}