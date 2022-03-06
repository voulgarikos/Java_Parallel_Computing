public class PassMon {
    public boolean toEast = true;
    public boolean toWest = false;
    int waitscale = 10;
    int inscale = 1000;
   
    synchronized void arrivetoEast () {
       //Car arrival
        try {
           Thread.sleep((int)(Math.random()*waitscale));
        } catch (InterruptedException e) { }
        System.out.println(Thread.currentThread().getName()+" --- wait to East");
        //Car waiting
        try {
          while (toEast == false) wait();
        } catch (InterruptedException e) { }
        //Car entering
        System.out.println(Thread.currentThread().getName()+" <<<     enter to East");
        toEast = false;

        try {
            Thread.sleep((int)(Math.random()*inscale));
            System.out.println(Thread.currentThread().getName()+" <<<         pass to East");
        } catch (InterruptedException e) { }

        System.out.println(Thread.currentThread().getName()+" <<<         exit to East");
        toWest = true;
        //Tell everybody
        notifyAll();
    }
    
    synchronized void arrivetoWest () {
        //Car arrival
         try {
            Thread.sleep((int)(Math.random()*waitscale));
         } catch (InterruptedException e) { }
         System.out.println(Thread.currentThread().getName()+" --- wait to West");
         //Car waiting
         try {
           while (toWest == false) wait();
         } catch (InterruptedException e) { }
         //Car entering
         System.out.println(Thread.currentThread().getName()+" >>>     enter to West");
         toWest = false;
 
         try {
             Thread.sleep((int)(Math.random()*inscale));
             System.out.println(Thread.currentThread().getName()+" >>>         pass to West");
         } catch (InterruptedException e) { }
 
         System.out.println(Thread.currentThread().getName()+" >>>         exit to West");
         toEast = true;
         //Tell everybody
         notifyAll();
     } 


}
