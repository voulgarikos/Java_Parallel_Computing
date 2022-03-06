public class MyThreadPiLock {
    private double mySum;
    private int myId;
	private int myStart;
    private int myStop;
    private long mySize;

    public MyThreadPiLock(int id, int numThreads, long size)
	{
            mySize = size;
            mySum = 0.0;
            myId = id;
		    myStart = myId * (size / numThreads);
            myStop = myStart + (size / numThreads);
                if (myId == (numThreads - 1)) myStop = size;
	}

	// thread code
	public void run()
	{
		double sum = 0.0;
        double step = 1.0 / (double)mySize;
                MyThreadsParPi.lock.lock();
                try {
		   /* do computation */
    for (long i=0; i < mySize; ++i) {
        double x = ((double)i+0.5)*step;
        sum += 4.0/(1.0+x*x);
    }
     MyThreadsParPi.pi = sum * step;
                } finally {
		    ThreadParArray.lock.unlock();
                }
	}
}
