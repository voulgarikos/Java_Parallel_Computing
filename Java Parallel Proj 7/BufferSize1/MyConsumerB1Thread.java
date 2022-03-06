public class MyConsumerB1Thread extends Thread {
    private MyBufferB1Sem buff;
        private int scale;

	// Constructor
	public MyConsumerThread(MyBufferB1Sem b, int s) {
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
