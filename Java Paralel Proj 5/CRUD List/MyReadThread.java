/*Erg 5 Voulgaris Konstantinos it9876
MyReadThread.java, o kodikas tou nimatos pou diavazei ti lista me kleidoma Reentrant lock kai delay 2 sec
Edo yparxei to provlima sti grammi 30 symfona me ton compiler*/



import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class MyReadThread extends Thread{
    private List<Integer> list;
     Lock lockRead = new ReentrantLock();
    public MyReadThread(List<Integer> list) {
        this.list = list;
    }
 
    public void run() {
 
        while (true) {
            delay(1000);
            String output = "\n Current List :";
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                lockRead.lock();
            try{
                Integer next = iterator.next();
                output += " " + next;
 		
         System.out.println(output);
        }finally{
           lockRead.unlock();
        }
        }
    }
    }
    public static void delay (int d) {
        try {
          Thread.sleep(d);
      } catch (InterruptedException e) { }
}  
}

