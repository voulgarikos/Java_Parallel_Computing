/*Voulgaris Konstantinos it9876
MyProdConsNMMainMon eina to kyrios progamma me paragogous N(5), katanalotes M(5) kai buffer size 10 kanontas xrisi
epopton (synchronized). */
public class MyProdConsNMMainMon {
    
    public static void main(String[] args) {
        int bufferSize = 10;
		int noIterations = 20;
		int producerDelay = 1;
		int consumerDelay = 100;
        int noProds = 5;
        int noCons = 5;
        MyProducerMonThread prod[] = new MyProducerMonThread[noProds];
		MyConsumerMonThread cons[] = new MyConsumerMonThread[noCons];
		

		// Bounded Buffer
                MyBufferNMMon buff = new MyBufferNMMon(bufferSize);
		
		// Producer threads
                for (int i=0; i<noProds; i++) {
			prod[i] = new MyProducerMonThread(buff, noIterations, producerDelay);
			prod[i].start();
		}

		// Consumer threads
                for (int j=0; j<noCons; j++) {
		        cons[j] = new MyConsumerMonThread(buff, consumerDelay);
			cons[j].start();
                }
	}
}
