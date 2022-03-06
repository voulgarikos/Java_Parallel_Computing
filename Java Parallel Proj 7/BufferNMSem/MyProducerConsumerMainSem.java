/*Erg7 Voulgaris Konstantinos it9876
MyProducerConsumerMainSem.java einai to kyrios programma pou dimiourgei ta nimata paragogou katanaloti kai 
dilonei N(5) paragogous kai M(5) katanalotes*/


public class MyProducerConsumerMainSem {
	
    public static void main(String[] args) {
        int bufferSize = 10;
		int noIterations = 20;
		int producerDelay = 1;
		int consumerDelay = 100;
        int noProds = 5;
        int noCons = 5;
        MyProducerThread prod[] = new MyProducerThread[noProds];
		MyConsumerThread cons[] = new MyConsumerThread[noCons];
		

		// Bounded Buffer
                MyBufferNMSem buff = new MyBufferNMSem(bufferSize);
		
		// Producer threads
                for (int i=0; i<noProds; i++) {
			prod[i] = new MyProducerThread(buff, noIterations, producerDelay);
			prod[i].start();
		}

		// Consumer threads
                for (int j=0; j<noCons; j++) {
		        cons[j] = new MyConsumerThread(buff, consumerDelay);
			cons[j].start();
                }
	}
}