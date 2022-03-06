import java.util.concurrent.Semaphore;

public class PassSem {
    int capacity = 10;
        private Semaphore EastSem = new Semaphore(1);
        private Semaphore WestSem = new Semaphore(0);
	int waitscale = 100;
        int inscale = 1000;
       // int bridge = 0;
       
        void arriveEast () {
            //Car arrival
            try {
               Thread.sleep((int)(Math.random()*waitscale));
            } catch (InterruptedException e) { }
            System.out.println(Thread.currentThread().getName()+" --- wait east");
          //Car waiting
            try {
              EastSem.acquire();
              
         
            } catch (InterruptedException e) { }

            //Car passing
            System.out.println(Thread.currentThread().getName()+" >>>     pass bridge from East");

        
        }
    
        
        void departEast () {
          //Car exiting
            System.out.println(Thread.currentThread().getName()+" <<<         exit");
            WestSem.release();
        
            }

            void arriveWest () {
              //Car arrival
              try {
                 Thread.sleep((int)(Math.random()*waitscale));
              } catch (InterruptedException e) { }
              System.out.println(Thread.currentThread().getName()+" --- wait wes");
            //Car waiting
              try {
                WestSem.acquire();
                
           
              } catch (InterruptedException e) { }
  
              //Car passing
              System.out.println(Thread.currentThread().getName()+" >>>     pass bridge from West");
  
          
          }
      
          
          void departWest () {
            //Car exiting
              System.out.println(Thread.currentThread().getName()+" <<<         exit");
              EastSem.release();
          
              }
        
           
        void pass() {    
            try {
                Thread.sleep((int)(Math.random()*inscale));
            } catch (InterruptedException e) { }
       }
}
