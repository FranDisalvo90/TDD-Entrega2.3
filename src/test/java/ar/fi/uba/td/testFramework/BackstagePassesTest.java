package ar.fi.uba.td.testFramework;

import java.io.IOException;

import ar.fi.uba.td.testFramework.testCases.TestCaseCreatedPassesAreNotNull;
import ar.fi.uba.td.testFramework.testCases.TestCaseDifferentPassesAreNotTheSame;
import ar.fi.uba.td.testFramework.testCases.TestCaseNotIdenticalPassesAreTheSameFailed;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForDifferentConcertsAreNotEqual;
import ar.fi.uba.td.testFramework.testCases.TestCasePassesForTheSameConcertAreEqual;

public class BackstagePassesTest {

	public static void main(String[] args) throws IOException {
		TestSuite mainTest = new TestSuite("mainTest");
		BaseTest createdPassesAreNotNull = new TestCaseCreatedPassesAreNotNull("TestCaseCreatedPassesAreNotNull");
		BaseTest differentPassesForTheSameConcertAreNotTheSame = new TestCaseDifferentPassesAreNotTheSame("TestCaseAreNotTheSame");
		BaseTest identicalPassesAreTheSame = new TestCaseNotIdenticalPassesAreTheSameFailed("TestCaseNotIdenticalPassesAreTheSameFailed");
		BaseTest passesForDifferentConcertsAreNotEqual = new TestCasePassesForDifferentConcertsAreNotEqual("TestCasePassesAreNotEqual");
		BaseTest passesForTheSameConcertAreEqual = new TestCasePassesForTheSameConcertAreEqual("TestCasePassesForTheSameConcertAreEqual");
		
		mainTest.add(createdPassesAreNotNull);
		mainTest.add(differentPassesForTheSameConcertAreNotTheSame);
		mainTest.add(identicalPassesAreTheSame);
		mainTest.add(passesForTheSameConcertAreEqual);
		mainTest.add(passesForDifferentConcertsAreNotEqual);
		
		TestRunner runner = new TestRunner(mainTest);
		runner.runTests("TestCasePasses.*");
	}

}
