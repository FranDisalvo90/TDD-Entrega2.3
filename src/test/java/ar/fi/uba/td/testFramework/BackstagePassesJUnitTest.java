package ar.fi.uba.td.testFramework;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.td.testFramework.BackstagePasses;

public class BackstagePassesJUnitTest {

    @Test
    public void testPassesForDifferentConcertsAreNotEqual() {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses someOtherPasses = new BackstagePasses(
		"someOtherConcert", 1, 2);
	assertNotEquals(somePasses, someOtherPasses);
    }

    @Test
    public void testPassesForTheSameConcertAreEqual() {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses someMorePasses = new BackstagePasses("someConcert", 1,
		3);
	assertEquals(somePasses, someMorePasses);
    }

    @Test
    public void testIdenticalPassesAreTheSame() {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	assertSame(somePasses, somePasses);
    }

    @Test
    public void testDifferentPassesForSameConcertAreNotTheSame() {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	BackstagePasses someMorePasses = new BackstagePasses("someConcert", 1,
		3);
	assertNotSame(somePasses, someMorePasses);
    }

    @Test
    public void testCreatedPassesAreNotNull() {
	BackstagePasses somePasses = new BackstagePasses("someConcert", 1, 2);
	assertNotNull(somePasses);
    }

}
