/*Erg7 Voulgaris Konstantinos it9876
PassCond.java einai o kodikas me tis methodous arrivedtoEast kai arrivedtoWest pou xrisimopoioun ta kleidomata 
condition */



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class PassCond {
    
   // int capacity = 4;
//int spaces = capacity;
    private Lock lock = new ReentrantLock();
	private Condition eastcond = lock.newCondition();
    private Condition westcond = lock.newCondition();
    private boolean toEast = true;
    private boolean toWest = false; 
	int waitscale = 10;
        int inscale = 1000;
       
        void arrivedtoEast () {
            //Car arrival
            try {
               Thread.sleep((int)(Math.random()*waitscale));
            } catch (InterruptedException e) { }
            System.out.println(Thread.currentThread().getName()+" --- wait to East");
            //Car waiting
            lock.lock();
            try {
                while (toEast == false) 
        		try {
                        	eastcond.await();
			} catch (InterruptedException e) { }
    		
                //Car entering
                System.out.println(Thread.currentThread().getName()+" >>>     pass to East");
                
               toEast = false;
                
                // Car passing
                try {
                    Thread.sleep((int)(Math.random()*inscale));
                } catch (InterruptedException e) { }

                System.out.println(Thread.currentThread().getName()+" >>>         exit to East");
               
                toWest = true;
                //Tell everybody
                westcond.signalAll();
            	
            } finally {
               	lock.unlock() ;
            }
        }
        

       void arrivedtoWest () {
        //Car arrival
        try {
           Thread.sleep((int)(Math.random()*waitscale));
        } catch (InterruptedException e) { }
        System.out.println(Thread.currentThread().getName()+" --- wait to West");
        //Car waiting
        lock.lock();
        try {
            while (toWest == false) 
            try {
                        westcond.await();
        } catch (InterruptedException e) { }
        
            //Car entering
            System.out.println(Thread.currentThread().getName()+" <<<     pass to West");
           
           toWest = false;

            // Car passing
            try {
                Thread.sleep((int)(Math.random()*inscale));
            } catch (InterruptedException e) { }
            
            System.out.println(Thread.currentThread().getName()+" <<<         exit to West");
            
            toEast = true;
            //Tell everybody
            eastcond.signalAll();
            
        } finally {
               lock.unlock() ;
        }
    }
}
    
   
