package ar.fi.uba.td.testFramework;

import org.junit.Before;
import org.junit.Test;

public class ComparatorTest {
	
	BackstagePasses somePasses;
	BackstagePasses someMorePasses;
	BackstagePasses someOtherPasses;
	Comparator comparator;

	@Before
	public void setUp() throws Exception {
		this.somePasses = new BackstagePasses("someConcert", 1, 2);
		this.someMorePasses = new BackstagePasses("someConcert", 1, 3);
		this.someOtherPasses = new BackstagePasses("someOtherConcert", 1, 2);
		
		this.comparator = new Comparator();
	}

	@Test(expected = TestFailedException.class)
	public void testFail() throws TestFailedException {
		comparator.fail("");
	}

	@Test
	public void testAssertTrueAssertsTrue() throws TestFailedException {
		comparator.assertTrue(true, "");
	}
	
	@Test(expected = TestFailedException.class)
	public void testAssertTrueFailsWhenFalse() throws TestFailedException {
		comparator.assertTrue(false, "");
	}

	@Test
	public void testAssertFalseAssertsFalse() throws TestFailedException {
		comparator.assertFalse(false, "");
	}
	
	@Test(expected = TestFailedException.class)
	public void testAssertFalseFailsWhenTrue() throws TestFailedException {
		comparator.assertFalse(true, "");
	}

	@Test
	public void testAssertEqualsAssertsTheSameInstance() throws TestFailedException {
		comparator.assertEquals(somePasses, somePasses, "");
	}
	
	@Test
	public void testAssertEqualsAssertsEqualUsingEqualsMethod() throws TestFailedException {
		comparator.assertEquals(somePasses, someMorePasses, "");
	}
	
	@Test(expected = TestFailedException.class)
	public void testAssertEqualsFailsUsingEqualsMethod() throws TestFailedException {
		comparator.assertEquals(somePasses, someOtherPasses, "");
	}

	@Test(expected = TestFailedException.class)
	public void testAssertNotEqualsFailsUsingEqualsMethod() throws TestFailedException {
		comparator.assertNotEquals(somePasses, someMorePasses, "");
	}
	
	@Test(expected = TestFailedException.class)
	public void testAssertNotEqualsFailsWithTheSameInstance() throws TestFailedException {
		comparator.assertNotEquals(somePasses, somePasses, "");
	}
	
	@Test
	public void testAssertNotEqualsAssertsUsingEqualsMethod() throws TestFailedException {
		comparator.assertNotEquals(somePasses, someOtherPasses, "");
	}

	@Test
	public void testAssertSameAssertsSameInstance() throws TestFailedException {
		comparator.assertSame(somePasses, somePasses, "");
	}

	@Test(expected = TestFailedException.class)
	public void testAssertSameFailsWithEqualObjects() throws TestFailedException {
		comparator.assertSame(somePasses, someMorePasses, "");
	}
	
	@Test
	public void testAssertNotSameAssertsNotSame() throws TestFailedException {
		comparator.assertNotSame(somePasses, someMorePasses, "");
	}
	
	@Test(expected = TestFailedException.class)
	public void testAssertNotSameFailsWithSameInstance() throws TestFailedException {
		comparator.assertNotSame(somePasses, somePasses, "");
	}
	
	@Test
	public void testAssertNullAssertsNull() throws TestFailedException {
		comparator.assertNull(null, "");
	}
	
	@Test(expected = TestFailedException.class)
	public void testAssertNullFailsWithInstance() throws TestFailedException {
		comparator.assertNull(somePasses, "");
	}

	@Test(expected = TestFailedException.class)
	public void testAssertNotNullFailsWithNull() throws TestFailedException {
		comparator.assertNotNull(null, "");
	}
	
	@Test
	public void testAssertNotNullAssertsWithInstance() throws TestFailedException {
		comparator.assertNotNull(somePasses, "");
	}

}
