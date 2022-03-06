// //Ergasia 1 Voulgaris Konstantinos it9876
//helloinnerrecursive.java
//The programm creates threads with inner class method and uses recursion to create threads


public class helloinnerrecursive {

    static int nThreads = 100;

    public static void main(String[] args) {

        // make threads 
        
        Thread[] threads = new Thread[nThreads];

        for (int i = 0; i < nThreads; ++i) {
            System.out.println("Arxizei sti main to nima me arithmo " + i);
            threads[i] = new Inner(i,i);
            threads[i].start();
        }

        // wait for them to finish 

        for (int i = 0; i < nThreads; ++i) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
            }
        }

        System.out.println("Oloklirothikan ta nimata sti main");
    }

    // inner class containing code for each thread to execute (recursive code also)

    static class Inner extends Thread {

        private int myID;
        private int telos;

        public Inner(int myID, int telos) {
            this.myID = myID;
            this.telos = telos;
        }

        public void run() {
            System.out.println("Kalimera eimai to nima " + myID + " apo " + nThreads);
            // do recursion until telos is reached 
            if (myID == telos) {
                System.out.println("Kalynyxta apo to " + myID);
         } else {
               System.out.println("Ksekina to nima " + (myID+1));
               Thread thread = new Thread(new Inner((myID+1), telos));
               thread.start();

               // wait for child thread 
               try {
               thread.join();
               } catch (InterruptedException e) {}
              System.out.println("Nima " + (myID+1) + " oloklirothike");
        }

    }
}

}
