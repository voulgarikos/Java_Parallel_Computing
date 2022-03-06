public class MyRandevouzMainSem {
    public static void main(String[] args) {

        PassSem x = new PassSem();
        
		int cars = 5;

                EastCarSem et[] = new EastCarSem[cars];
                WestCarSem wt[] = new WestCarSem[cars];

           	for (int i=0; i<cars; i++) {
      			et[i] = new EastCarSem(x);
            wt[i] = new WestCarSem(x);
        		et[i].start(); 
            wt[i].start();
      		}
      		for (int i=0; i<cars; i++) 
        		try { 
           			 et[i].join(); 
                  wt[i].join();
       			} catch (InterruptedException e) { }
                 
          }
		
    }

