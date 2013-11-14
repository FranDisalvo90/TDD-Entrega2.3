package ar.fi.uba.td.testFramework;

import org.junit.Before;
import org.junit.Test;

public class AssertTest {

    BackstagePasses somePasses;
    BackstagePasses someMorePasses;
    BackstagePasses someOtherPasses;

    @Before
    public void setUp() throws Exception {
	this.somePasses = new BackstagePasses("someConcert", 1, 2);
	this.someMorePasses = new BackstagePasses("someConcert", 1, 3);
	this.someOtherPasses = new BackstagePasses("someOtherConcert", 1, 2);
    }

    @Test(expected = TestFailedException.class)
    public void testFail() throws TestFailedException {
	Assert.fail("");
    }

    @Test
    public void testAssertTrueAssertsTrue() throws TestFailedException {
	Assert.assertTrue(true, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertTrueFailsWhenFalse() throws TestFailedException {
	Assert.assertTrue(false, "");
    }

    @Test
    public void testAssertFalseAssertsFalse() throws TestFailedException {
	Assert.assertFalse(false, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertFalseFailsWhenTrue() throws TestFailedException {
	Assert.assertFalse(true, "");
    }

    @Test
    public void testAssertEqualsAssertsTheSameInstance()
	    throws TestFailedException {
	Assert.assertEquals(somePasses, somePasses, "");
    }

    @Test
    public void testAssertEqualsAssertsEqualUsingEqualsMethod()
	    throws TestFailedException {
	Assert.assertEquals(somePasses, someMorePasses, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertEqualsFailsUsingEqualsMethod()
	    throws TestFailedException {
	Assert.assertEquals(somePasses, someOtherPasses, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertNotEqualsFailsUsingEqualsMethod()
	    throws TestFailedException {
	Assert.assertNotEquals(somePasses, someMorePasses, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertNotEqualsFailsWithTheSameInstance()
	    throws TestFailedException {
	Assert.assertNotEquals(somePasses, somePasses, "");
    }

    @Test
    public void testAssertNotEqualsAssertsUsingEqualsMethod()
	    throws TestFailedException {
	Assert.assertNotEquals(somePasses, someOtherPasses, "");
    }

    @Test
    public void testAssertSameAssertsSameInstance() throws TestFailedException {
	Assert.assertSame(somePasses, somePasses, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertSameFailsWithEqualObjects()
	    throws TestFailedException {
	Assert.assertSame(somePasses, someMorePasses, "");
    }

    @Test
    public void testAssertNotSameAssertsNotSame() throws TestFailedException {
	Assert.assertNotSame(somePasses, someMorePasses, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertNotSameFailsWithSameInstance()
	    throws TestFailedException {
	Assert.assertNotSame(somePasses, somePasses, "");
    }

    @Test
    public void testAssertNullAssertsNull() throws TestFailedException {
	Assert.assertNull(null, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertNullFailsWithInstance() throws TestFailedException {
	Assert.assertNull(somePasses, "");
    }

    @Test(expected = TestFailedException.class)
    public void testAssertNotNullFailsWithNull() throws TestFailedException {
	Assert.assertNotNull(null, "");
    }

    @Test
    public void testAssertNotNullAssertsWithInstance()
	    throws TestFailedException {
	Assert.assertNotNull(somePasses, "");
    }

}
