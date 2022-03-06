public class MyProdConsMainB1Sem {
    
    public static void main(String[] args) {
      //  int bufferSize = 10;
		int noIterations = 20;
		int producerDelay = 1;
		int consumerDelay = 100;
        int noProds = 5;
        int noCons = 5;
        MyProducerThread prod[] = new MyProducerThread[noProds];
		MyConsumerThread cons[] = new MyConsumerThread[noCons];
		

		// Bounded Buffer
                MyBufferB1Sem buff = new MyBufferB1Sem();
		
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
