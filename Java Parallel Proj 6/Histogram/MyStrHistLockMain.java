/*Erg 6 Voulgaris Konstantinos it9876
MyStrHistLockMain.java to main progamma pou dexetai ena keimeno kai epistrefei ti syxnotita emfanisis ton stoixeion tou alfavitou
pou periexei. Exei parallhlopoieithei me nimata kai xrisimopoiei Reentrant locks gia amoivaio apoklismo */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantLock;



public class MyStrHistLockMain {

    public static void main(String args[]) throws IOException {
        //arithmos nimaton
        int nThreads = 8;
       //diavasma text arxeiou
        String filepath = "C:/Users/voulg/Downloads/large/world192.txt";

        String fileString = new String(Files.readAllBytes(Paths.get(filepath)));
        
        //arxi xronometrisis
        long start = System.currentTimeMillis();
        //apothikeysi keimenou ston pinaka text
        char[] text = new char[fileString.length()]; 
        int n = fileString.length();
        for (int i = 0; i < n; i++) { 
            text[i] = fileString.charAt(i); 
        } 
        //dimiourgia kai arxikopoiisi pinaka istogrammatos
        int alphabetSize = 256;
        int[] histogram = new int[alphabetSize]; 
        for (int i = 0; i < alphabetSize; i++) { 
            histogram[i] = 0; 
        }
        ReentrantLock[] locks = new ReentrantLock[alphabetSize];
        //dimiourgia nimaton
        MyStrHistLockThread[] threads = new MyStrHistLockThread[nThreads];
        //enarksi nimaton
        for (int i = 0; i < nThreads; i++){
            threads[i] = new MyStrHistLockThread(i,nThreads,text,n,histogram,locks);
            threads[i].start();
        }
        //liksi nimaton
            for (int i = 0; i < nThreads; i++) {
                try {
                    threads[i].join();
                   
                       } catch (InterruptedException e) {}
                }
        //ektyposi istogrammatos
                for (int i = 0; i < alphabetSize; i++) { 
                    System.out.println((char)i+": "+histogram[i]);
                }
        //liksi xronometrisis kai tipoma tis diarkeias
    long elapsedTimeMillis = System.currentTimeMillis()-start;
    System.out.println("time in ms = "+ elapsedTimeMillis);
    
}
}
