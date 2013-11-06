package ar.fi.uba.td.testFramework;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCaseDifferentPassesAreNotTheSame;
import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForTheSameConcertAreEqual;

public class BackstagePassesTest {

	public static void main(String[] args) {
		TestSuite mainTest = new TestSuite("mainTest");
		TestCaseCreatedPassesAreNotNull createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		TestCaseDifferentPassesAreNotTheSame differentPassesForTheSameConcertAreNotTheSame = new TestCaseDifferentPassesAreNotTheSame("TestCaseAreNotTheSame");
		TestCaseNotIdenticalPassesAreTheSameFailed identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCaseNotIdenticalPassesAreTheSameFailed");
		TestCasePassesForDifferentConcertsAreNotEqual passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCasePassesAreNotEqual");
		TestCasePassesForTheSameConcertAreEqual passesForTheSameConcertAreEqual = new TestCasePassesForTheSameConcertAreEqual("TestCasePassesForTheSameConcertAreEqual");
		
		mainTest.add(createdPassesAreNotNull);
		mainTest.add(differentPassesForTheSameConcertAreNotTheSame);
		mainTest.add(identicalPassesAreTheSame);
		mainTest.add(passesForTheSameConcertAreEqual);
		mainTest.add(passesForDifferentConcertsAreNotEqual);
		
		TestRunner runner = new TestRunner(mainTest);
		runner.runTests();
	}

}
