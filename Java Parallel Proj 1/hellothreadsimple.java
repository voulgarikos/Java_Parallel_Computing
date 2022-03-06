//Ergasia 1 Voulgaris Konstantinos it9876
//hellothreadsimple.java
//creates a small number of threads using a class extending Thread
//



public class hellothreadsimple {
    public static void main(String[] args){
    //set the number of threads
    int nThreads = 15;

    Thread[] threads = new Thread[nThreads];

    //create and start threads
    for (int i=0; i<nThreads; i++){
        System.out.println("Inside Main:Create and Start Thread No. " + i);
        threads[i] = new MyNima();
        threads[i].start();
    }
    //wait for threads to finish
    for (int i=0; i<nThreads; i++){
        try{
            threads[i].join();
        }
        catch (InterruptedException e){
            System.err.println("this should not happen");
        }
    }
        System.out.println("Inside Main: All threads are finished");
    }
    }
//class MyNima with the code for the threads to run
class MyNima extends Thread{
    //code 
    public void run() {
        System.out.println("Hello World, this is my first thread, " + Thread.currentThread().getName());
    }
}




 