//Ergasia 1/2021
//Voulgaris Konstantinos
//it9876
//This is a programme that uses a simple menu for the user to choose between
//a programme that creates and runs threads using anonymous class or 
//a programme that creates and runs threads by using an extending class and performs a computational heavy task

import java.util.Scanner;
public class Erg11 {
    
    //prints the menu contents
    public static void displayMenu(){
    System.out.println("-- Actions --");
    System.out.println(
    "Select an option: \n" +
    "  1) Run Anonymous Threads\n" +
    "  2) Run Computational Heavy Threads\n" +
    "  3) Exit \n"
        );
    }
        
    public static void main(String[] args){
        
        
            //shows menu
            displayMenu();
            //user choice
            int choice;
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
           
            if (choice == 1){
                Thread t= new Thread(){ 	
                //Anonymous class     
                    public void run()	
                    {
                    setName("Anonymous Thread");	
                    System.out.println("Name of the other thread - " + getName());
                    int numCores = Runtime.getRuntime().availableProcessors();
                    for(int i=0;i<numCores;i++)
                    {
                        System.out.println(getName() + " " + i);
                    }
                
                    }
                    };				
                    
                //Starting anonymous thread
                t.start();
                
                //Gets the name of main thread
                System.out.println("Name of main thread - "+ Thread.currentThread().getName()); 
            }
            if (choice == 2){
                    int nThreads = 10;
                    Thread[] threads = new Thread[nThreads];
            
                    // create and start threads 
                    for (int i = 0; i < nThreads; ++i) {
                    System.out.println("Stin Main: Dimiourgia kai enarksi nimatos " + i);
                    threads[i] = new MyThread(i);
                    threads[i].start();
                    }
                    
                    // wait for threads to finish 
                    for (int i = 0; i < nThreads; ++i) {
                        try {
                            threads[i].join();
                        }
                        catch (InterruptedException e) {
                            System.err.println("this should not happen");
                        }
                    }
            
                    System.out.println("In main: threads all done");
                }
                
               
            if (choice == 3){
                System.exit(0);
            }
        }
            //class extending Thread
            private static class MyThread extends Thread {
            
                private int myID;
        
                public MyThread(int myID) {
                   this.myID = myID;
              }
        
                public void run() {
                //code for thread with the computational heavy task
                    System.out.println("Thread "+myID+" Exits");
                    for (long i=0; i < 100000; i++){
                        for (long j=0; j < 100000; j++){
                            double x = ((double)j);
                            x = Math.sqrt(4.0/(1.0+x*x));
                        }
                    }
               }
        
            }
 
}
           