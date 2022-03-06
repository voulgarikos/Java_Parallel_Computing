/*Erg 5 Voulgaris Konstantinos it9876
MyRemoveThread.java, o kodikas tou nimatos pou afairei stoixeia apo ti lista me kleidoma Reentrant lock kai delay 3 sec*/


import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyRemoveThread extends Thread{
    private List<Integer> list;
    Lock lock = new ReentrantLock();
 
    public MyRemoveThread(List<Integer> list) {
        this.list = list;
    }
 
    public void run() {
        
        while (true) {
            lock.lock();
            delay(3000);
            list.remove(1);
            System.out.println("Remove done");
            lock.unlock();
        }
    }
    public static void delay (int d) {
        try {
          Thread.sleep(d);
      } catch (InterruptedException e) { }
}   
}
