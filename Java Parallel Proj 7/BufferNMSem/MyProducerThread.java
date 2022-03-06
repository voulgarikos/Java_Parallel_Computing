/* Erg7 Voulgaris Konstantinos it9876
MyProducerThread.java einai o kodikas ton nimaton tou paragogou */

public class MyProducerThread extends Thread {
    private MyBufferNMSem buff;
    private int reps;
    private int scale;

// Constructor
public MyProducerThread(MyBufferNMSem b, int r, int s) {
    this.buff = b;
            this.reps = r;
            this.scale = s;
}

//Producer runs for reps times with random(scale) intervals
public void run() {
    for(int i = 0; i < reps; i++) {
       
                try {
                     sleep((int)(Math.random()*scale));
                     buff.put(i);
              } catch (InterruptedException e) { }
            }
    
}
}
