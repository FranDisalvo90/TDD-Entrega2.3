package ar.fi.uba.td.testFramework;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCaseDifferentPassesForTheSameConcertAreNotTheSame;
import ar.fi.uba.td.testFramework.testCases.TestCaseIdenticalPassesAreTheSame;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForTheSameConcertAreEqual;

public class BackstagePassesTest {

	public static void main(String[] args) {
		RunnableTest mainTest = new TestSuite();
		RunnableTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull();
		RunnableTest differentPassesForTheSameConcertAreNotTheSame = new TestCaseDifferentPassesForTheSameConcertAreNotTheSame();
		RunnableTest identicalPassesAreTheSame = new TestCaseIdenticalPassesAreTheSame();
		RunnableTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual();
		RunnableTest passesForTheSameConcertAreEqual = new TestCasePassesForTheSameConcertAreEqual();
		
		mainTest.add(createdPassesAreNotNull);
		mainTest.add(differentPassesForTheSameConcertAreNotTheSame);
		mainTest.add(identicalPassesAreTheSame);
		mainTest.add(passesForTheSameConcertAreEqual);
		mainTest.add(passesForDifferentConcertsAreNotEqual);
		
		TestRunner runner = new TestRunner(mainTest);
		runner.runTests();
	}

}
