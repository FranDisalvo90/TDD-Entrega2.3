package ar.fi.uba.td.testFramework;

/**
 * Class that has the possible test's status.
 */

public enum TestStatus {
    NOT_RUN, FAILED, OK, ERROR;

    public String toString() {
	String stringTestStatus = "";
	switch (this) {
	case NOT_RUN:
	    stringTestStatus = "[not run]";
	case OK:
	    stringTestStatus = "[ok]";
	    break;
	case FAILED:
	    stringTestStatus = "[failed]";
	    break;
	case ERROR:
	    stringTestStatus = "[error]";
	    break;
	}

	return stringTestStatus;
    }
}
