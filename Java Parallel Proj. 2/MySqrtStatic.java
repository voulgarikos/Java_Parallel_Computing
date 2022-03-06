
    /* Erg2 Voulgaris Konstantinos it9876
MySqrtStatic.java a programme that gets from user input the number of threads to create 
and the size of an array for which it calculates the square root of the arrays elements. 
The elements of the array are randomly created integers. The threads use a static distribution of the elements
 of the array on each thread  
*/ 

import java.util.Scanner;


public class MySqrtStatic {
    public static void main(String[] args) {
        
        int nimata = 0;
        int stoixia = 0;
        //User input of the number of threads to create
        System.out.println("Dwse enan arithmo nimaton");
        Scanner in = new Scanner(System.in);
        try {
			nimata = in.nextInt();
            }
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
	    		System.exit(1);
		}
                if (nimata <= 0) {
                        System.out.println("size should be positive integer");
	    		System.exit(1);
            }
        //User input of the size of the array
        System.out.println("Dwse megethos pinaka");
        try {
			stoixia = in.nextInt();
            }
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
	    		System.exit(1);
		}
                if (stoixia <= 0) {
                        System.out.println("size should be positive integer");
	    		System.exit(1);
            }
            //array declaration
            double[] pinakas = new double[stoixia];
            //randomly populating the array
            for(int i = 0; i < stoixia; i++)
                        
             pinakas[i] = Math.random()*stoixia; 
            
            // get current time
            long start = System.currentTimeMillis();

            // create threads
            SqrtGroupThread threads[] = new SqrtGroupThread[nimata];
            
            // thread execution   
            for(int i = 0; i < nimata; i++) 
            {
                threads[i] = new SqrtGroupThread(i, nimata, pinakas, stoixia);
                threads[i].start();
            }
    
            // wait for threads to terminate            
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
//class SqrtGroupThread containing the code of the threads
class SqrtGroupThread extends Thread
{
	private double [] table;
	private int myStart;
        private int myStop;

	// constructor
	public SqrtGroupThread(int myId, int nimata, double[] array, int stoixia)
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
		for(int i = myStart; i < myStop; i++) 
	           	table[i] = Math.sqrt(table[i]);
                  
	}
}