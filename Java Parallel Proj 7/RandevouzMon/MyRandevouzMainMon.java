public class MyRandevouzMainMon {
    
    public static void main(String[] args) {

        PassMon x = new PassMon();
		
		int cars = 5;
                EastCarMon est[] = new EastCarMon[cars];
                WestCarMon wst[] = new WestCarMon[cars];

           	for (int i=0; i<cars; i++) {
      			est[i] = new EastCarMon(x);
                wst[i] = new WestCarMon(x);
        		est[i].start(); 
                wst[i].start();
      		}
      		for (int i=0; i<cars; i++) 
        		try { 
           			 est[i].join(); 
                     wst[i].join();
       			} catch (InterruptedException e) { }
    	}
		
    }


