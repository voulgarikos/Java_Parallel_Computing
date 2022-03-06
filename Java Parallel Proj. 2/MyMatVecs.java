/*Erg 2 Voulgaris Konstantinos it9876
MyMatVecs.java: Programma pou dexetai eisodo apo to xristi ton arithmo ton nimaton kai to megethos tou pinaka 
kai ektelei pollaplasiasmo pinakon.
Simeiosi: Den doulevei vgazei sfalma java.lang.NullPointerException
        at MatVecThreads.run(MyMatVecs.java:95) To epsaksa alla den mporo na entopiso to provlima, exete mipos kamia symvouli?
 */

import java.util.Scanner;

public class MyMatVecs {
    public static void main(String[] args) {
        
        int nimata = 0;
        int stoixia = 0;
        //User input of the number of threads to create
        System.out.println("Dwse enan arithmo nimaton");
        Scanner in = new Scanner(System.in);
        
			nimata = in.nextInt();
         
		
                if (nimata <= 0) {
                        System.out.println("size should be positive integer");
	    		System.exit(1);
            }
        //User input of the size of the array
        System.out.println("Dwse megethos pinaka");
            stoixia = in.nextInt();
                if (stoixia <= 0) {
                        System.out.println("size should be positive integer");
	    		System.exit(1);
            }
             /* initialization */
    double[][] pinakas = new double[stoixia][stoixia];
    for(int i = 0; i < stoixia; i++)
    	for(int j = 0; j < stoixia; j++)
	    pinakas[i][j] = 1;
    
    double[] x = new double[stoixia];
    double[] y = new double[stoixia];
    for(int i = 0; i < stoixia; i++) {
	x[i] = 1;
        y[i] = 0;
    }

    // get current time
    long start = System.currentTimeMillis();
    
    // create threads
    MatVecThreads threads[] = new MatVecThreads[nimata];
    // start threads
    for(int i = 0; i < nimata; i++) 
    {
        threads[i] = new MatVecThreads(i,nimata,pinakas,stoixia,x,y);
        threads[i].start();
    }

    //              
    for(int i = 0; i < nimata; i++) {
        try {
            threads[i].join();
               } catch (InterruptedException e) {}
    }

     // get current time and calculate elapsed time
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("time in ms = "+ elapsedTimeMillis);

   
}

}
//class SqrtThread containing the code of the threads
class MatVecThreads extends Thread
{
	private double [][] table;
	private int myStart;
    private int myStop;
    private double x[];
    private double y[]; 

	// constructor
	public MatVecThreads(int myId, int nimata, double[][] array, int stoixia, double[] x, double[] y)
	{
		table = array;
		myStart = myId * (stoixia / nimata);
                myStop = myStart + (stoixia / nimata);
                if (myId == (nimata - 1)){ 
                    myStop = stoixia;
                }
    }


	// thread code
	public void run()
	{
		
        double sum;
        for (int i= myStart; i < myStop; i++){
            sum = 0;
            for (int j = myStart; j < myStop; j++) {
                sum = sum + table[i][j]*x[j];
            }
            y[i] = sum;
        }              
	
}
}