import java.net.*;
import java.io.*;
import java.util.concurrent.locks.*;


public class MyPiServerProtocol {
    
    private MyPiSharedList mnimi;
    private Lock lock = new ReentrantLock();
	public MyPiServerProtocol (MyPiSharedList m) {
		
		mnimi = m;
        }

	public String processRequest(String theInput) {
            double sum = 0;
	        String theOutput;
            int numSteps = Integer.parseInt(theInput);
            if (mnimi.isIn(numSteps) != 1){
            double step = 1.0 / (double)numSteps;
            /* do computation */
            for (long i=0; i < numSteps; ++i) {
                double x = ((double)i+0.5)*step;
                sum += 4.0/(1.0+x*x);
            }
            double pi = sum * step;
            lock.lock();
            mnimi.add(pi); 
            lock.unlock();
			theOutput = Double.toString(pi);
        }else theOutput = mnimi.get(numSteps);
		return theOutput;
	}
}
