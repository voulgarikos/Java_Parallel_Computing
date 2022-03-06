/*Erg 5 Voulgaris Konstantinos it9876
MyWriteArrayList.java, to kyrios programma pou kataskevazei mia lista kai tin 'gemizei' me arithmous 0-9 kai sti synexeia ksekinaei ta nimata 
ta opoia prosthetoun, afairoun, enimeronoun kai diavazoun ta stoixeia tis listas me diaforetika delay kai xrisimopoiontas kleidomata Reentrantlock. 
Kata tin ektelesi dystyxos pairno ayto to minima: 
Exception in thread "Thread-2" java.util.ConcurrentModificationException
        at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
        at MyReadThread.run(MyReadThread.java:30)
Meta apo polles prospatheies den vrika ti ftaiei, tha rotiso sto ergastirio
*/

import java.util.*;
import java.util.concurrent.*;

public class MyWriteArrayList {

    public static void main(String[] args) {
        
    //dilosi kai 'gemisma listas'
    List<Integer> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            list.add(i);
        }
        //constructor nimaton
        MyAddThread myadd = new MyAddThread(list);
        MyRemoveThread myremove = new MyRemoveThread(list);
        MyReadThread myread = new MyReadThread(list);
        MyUpdateThread myupdate = new MyUpdateThread(list);
        //ekkinisi nimaton
        myadd.start();
        myremove.start();
        myupdate.start();
        myread.start();
        //termatismos nimaton
        try {
            myadd.join();
        } catch (Exception e) {
            
        }
       
        try {
            myremove.join();
        } catch (Exception e) {
            
        }
        
        try {
            myread.join();
        } catch (Exception e) {
           
        }
        
        try {
            myupdate.join();
        } catch (Exception e) {
            
        }
        
 
    }
    
}
