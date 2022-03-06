/*Erg7 Voulgaris Konstantinos it9876
MyConsumerMonThread.java o kodikas ton nimaton ton katanaloton */

public class MyConsumerMonThread {
    private MyBufferNMMon buff;
        private int scale;

	// Constructor
	public MyConsumerMonThread(MyBufferNMMon b, int s) {
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
