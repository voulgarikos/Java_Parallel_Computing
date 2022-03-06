/*Erg7 Voulgaris Konstantinos it9876
MyConsumerThread.java einai o kodikas ton nimaton tou katanaloti */


public class MyConsumerThread extends Thread {
    private MyBufferNMSem buff;
        private int scale;

	// Constructor
	public MyConsumerThread(MyBufferNMSem b, int s) {
		this.buff = b;
                this.scale = s;
	}

	// Producer runs for reps times with random(scale) intervals
	public void run() {
		int value;
		while (true) {
			try {
              			sleep((int)(Math.random()*scale));
          		} catch (InterruptedException e) { }
			value = buff.get();
               }
	}
}
