/*Erg 5 Voulgaris Konstantinos it9876
MyUpdateThread.java, o kodikas tou nimatos pou enimeroni ti lista me kleidoma Reentrant lock kai delay 1 sec*/

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class MyUpdateThread extends Thread{
    //dilosi listas
    private List<Integer> list;
    //dimiourgia kleidarias
    Lock lock = new ReentrantLock();
 
    public MyUpdateThread(List<Integer> list) {
        this.list = list;
    }
 
    public void run() {
        
        while (true) {
            lock.lock();
            //kathisterisi 1 sec
            delay(1000);
            list.set(1, list.get(1)+1);
            System.out.println("Update done");
            lock.unlock();
        }
    }
    //methodos gia delay
    public static void delay (int d) {
        try {
          Thread.sleep(d);
      } catch (InterruptedException e) { }
}  
}
