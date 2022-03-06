/*Erg 5 Voulgaris Konstantinos it9876
MyAddThread.java, o kodikas tou nimatos pou prosthetei stoixeia sti lista me kleidoma Reentrant lock kai delay 0,1 sec */

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class MyAddThread extends Thread{
    private List<Integer> list;
    Lock lock = new ReentrantLock();
 
    public MyAddThread(List<Integer> list) {
        this.list = list;
    }
 
    public void run() {
       
        while (true) {
            lock.lock();
        try {
            delay(100);
            list.add(1);
            System.out.println("Add done");
        }finally{
            lock.unlock();
        }
        }
    }
    public static void delay (int d) {
        try {
          Thread.sleep(d);
      } catch (InterruptedException e) { }
}  
}
