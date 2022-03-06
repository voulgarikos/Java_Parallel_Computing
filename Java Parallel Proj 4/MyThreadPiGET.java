/*Erg 4 Voulgaris Konstantinos it9876
MyThreadPiGET.java - programma parallhlou ypologismou tou arithmou pi
Dexetai eisodo ton arithmo ton nimaton kai ton vimaton kai epistrefei ton ypologismo tou pi kai tin diafora apo to mathimatiko pi kathos
kai to xrono pou xreiastike na to ypologisei. Xrisimopoiei mia methodo get gia ti lipsi ton apotelesmaton */







public class MyThreadPiGET {

    
    
    public static void main(String[] args) {
     //eisodos plithous vimaton kai arithmo nimaton   
        long nSteps = 1000000;
        int nThreads = 4;

        long startTime = System.currentTimeMillis();

        MyThreadGet threads[] = new MyThreadGet[nThreads];
    //ekinisi nimaton
        for (int i=0; i < nThreads; i++)
        {
        threads[i] = new MyThreadGet(i,nThreads,nSteps);
        threads[i].start();
        }
        //oloklirosi nimaton kai syllogi apotelesmatos sti metavliti pi me ti methodo get
        double pi = 0.0;
        for (int i = 0; i < nThreads; i++) {
            try {
                threads[i].join();
                pi = pi + threads[i].get();
                   } catch (InterruptedException e) {}
            }
            long endTime = System.currentTimeMillis();
            //typoma apotelesmaton
            System.out.printf("Parallel GET program results with %d steps\n", nSteps);
            System.out.printf("computed pi = %22.20f\n" , pi);
            System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
            System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
    }
}
//klasi MyThreadGet
class MyThreadGet extends Thread {
//topikes metavlites ton nimaton
    private double mySum;
    private int myId;
	private int myStart;
    private int myStop;
    private double step;
    private double myPi;
//constructor
    public MyThreadGet(int id, int nThreads, long nSteps){
        mySum = 0.0;
        myPi = 0.0;
        myId = id;
        step = 1.0 / (double)nSteps;
        //SPMD
        myStart = myId * ((int)nSteps / nThreads);
        myStop = myStart + ((int)nSteps / nThreads);
            if (myId == (nThreads - 1)) myStop =(int) nSteps;
    }
    //kodikas nimaton
    public void run() {
     //ypologismos pi
    for (int i= myStart;i < myStop; ++i) {
        double x = ((double)i+0.5)*step;
        mySum += 4.0/(1.0+x*x);
    }
    myPi = mySum * step;
    }
    //methodos get
    public double get() {
        return myPi;
    }
}