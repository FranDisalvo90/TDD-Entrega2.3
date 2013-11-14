package ar.fi.uba.td.testFramework;

/**
 * Class that store and calculate the time.
 */

public class Timer {

    private long initialTime;

    Timer() {
	initialTime = 0;
    }

    public void start() {
	initialTime = getTime();
    }

    public long getTotalTime() {
	return getTime() - initialTime;
    }

    private long getTime() {
	return System.nanoTime();
    }
}
