package ar.fi.uba.td.testFramework;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCaseDifferentPassesAreNotTheSame;
import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForTheSameConcertAreEqual;

public class BackstagePassesTest {

	public static void main(String[] args) {
		RunnableTest mainTest = new TestSuite("mainTest");
		RunnableTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		RunnableTest differentPassesForTheSameConcertAreNotTheSame = new TestCaseDifferentPassesAreNotTheSame("TestCaseAreNotTheSame");
		RunnableTest identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCaseNotIdenticalPassesAreTheSameFailed");
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCasePassesAreNotEqual");
		RunnableTest passesForTheSameConcertAreEqual = new TestCasePassesForTheSameConcertAreEqual("TestCasePassesForTheSameConcertAreEqual");
		
		mainTest.add(createdPassesAreNotNull);
		mainTest.add(differentPassesForTheSameConcertAreNotTheSame);
		mainTest.add(identicalPassesAreTheSame);
		mainTest.add(passesForTheSameConcertAreEqual);
		mainTest.add(passesForDifferentConcertsAreNotEqual);
		
		TestRunner runner = new TestRunner(mainTest);
		runner.runTests();
	}

}
