/*Erg 6 Voulgaris Konstantinos it9876
MyStrMatchMain.java to main programma pou dexetai os eisodo ena text arxeio kai mia seira apo stoixia px leksi i protasi kai
epistrefei tis thesis tous sto keimeno kai ti syxnotita emfanisis tous  */


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*; 


public class MyStrMatchMain {
   
    public static void main(String[] args) throws IOException {
    //dilosi plithous nimaton kai arexikopoiisi metavlitis counter
    int nThreads = 8;
    int matchCount = 0;
    


    //eisodos keimenou
    String filepath = "C:/Users/voulg/Downloads/large/world192.txt";

    String fileString = new String(Files.readAllBytes(Paths.get(filepath)));
        //enarksi xronometrisis
    long start = System.currentTimeMillis();

    char[] text = new char[fileString.length()]; 
    int n = fileString.length();
    for (int i = 0; i < n; i++) { 
        text[i] = fileString.charAt(i); 
    } 
    //dilosi lekseon gia na psaksei to programa
    String patternString = "Exclusive economic zone";                                                
    char[] pattern = new char[patternString.length()]; 
    int m = patternString.length(); 

    for (int i = 0; i < m; i++) { 
        pattern[i] = patternString.charAt(i); 
    }

    int matchLength = n - m;
    char[] match = new char[matchLength+1]; 
    for (int i = 0; i <= matchLength; i++) { 
        match[i] = '0'; 
    
    }
    //dimiourgia kai enarksi nimaton
    MyStrMatchThreads threads[] = new MyStrMatchThreads[nThreads];
    for (int i = 0; i < nThreads; i++){
        threads[i] = new MyStrMatchThreads(i,nThreads,text,pattern,match,n,m);
        threads[i].start();
    }
    
        for (int i = 0; i < nThreads; i++) {
            try {
                threads[i].join();
                matchCount = matchCount + threads[i].get(); //methodos get gia tin syllogi ton apotelesmaton apo ta nimata kai 
                   } catch (InterruptedException e) {}      //efarmogi amoivaiou apoklismou sta nimata
            }
            //ektyposi ton theseon ton lekseon sto arxeio
            for (int i = 0; i < matchLength; i++) { 
                if (match[i] == '1') System.out.print(i+" ");
            }
            //ektyposi tou plithous ton emfaniseon
            System.out.println();
            System.out.println("Total matches " + matchCount); 

             // liksi xronometrisis kai typoma diarkeias
    long elapsedTimeMillis = System.currentTimeMillis()-start;
    System.out.println("time in ms = "+ elapsedTimeMillis);   
    }


}
    