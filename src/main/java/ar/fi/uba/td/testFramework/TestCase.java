package ar.fi.uba.td.testFramework;

import java.util.ArrayList;

/**
 * Class that models a TestCase. This class works as the leaf node on the
 * composite pattern.
 */
public abstract class TestCase extends Comparator implements RunnableTest {

    private String name;
    private ArrayList<String> tags;

    public TestCase(String nameTest) {
	this.name = nameTest;
	this.tags = new ArrayList<String>();
    }

    /**
     * Abstract method where the user will define the actual test.
     */
    public abstract void runTest(TestContext context) throws Exception;

    private boolean regularExpressionMatches(String regExp) {
	return this.name.matches(regExp);
    }

    public void run(TestInformation information) {
	if (isRunnable(information))
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

    private boolean isRunnable(TestInformation information) {
	String regExp = information.getRegExp();
	ArrayList<String> tags = information.getTags();
	return !regularExpressionMatches(regExp) && tagsMatch(tags) && !isToSkip();
    }

    private boolean isToSkip() {
	return this.tags.contains("SKIP");
    }

    private boolean tagsMatch(ArrayList<String> tags) {
	// TODO Auto-generated method stub
	// TODO FIXME
	return false;
    }

    public int countTest() {
	//return regularExpressionMatches() ? 1 : 0;
	// TODO FIXME
	return 0;
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
