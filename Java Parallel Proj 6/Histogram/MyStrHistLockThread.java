/*Erg 6 Voulgaris Konstantinos it9876
MyStrHistLockThread einai i klasi nimaton pou ypologizei to istogramma
 kai efarmozei to klidoma me Reentrant locks */

import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

class MyStrHistLockThread extends Thread{
    //dilosi metavliton 
    private int nThreads;
    private int index;
    private int textsize;
    private char[] text;
    private int[] globalhist;
    private ReentrantLock[] locks;
    private int block;
    private int alphabetSize = 256;
    private int myStart;
    private int myStop;
    int[] localhist = new int[alphabetSize]; //dimiourgia kai arxikopoiisi topikou pinaka istogrammatos
    //dimiourgia locks
    
    //dimiourgia constructor
    public MyStrHistLockThread(int i, int nThreads, char[] text, int n, int[] histogram, ReentrantLock[] locks){
        
        this.index = i;
        this.nThreads = nThreads;
        this.text = text;
        this.textsize = n;
        this.globalhist = histogram;
        this.locks = locks;
        
        
      
    //SPMD    
        block = ((textsize)/nThreads);
        myStart = index * block;
        myStop = block + myStart;
            if (index == nThreads - 1) {
                myStop = textsize;}
    }
    public void run(){
    //kodikas nimaton
       
      //  for (int i=0;i<alphabetSize;i++){

      //  localhist[i]=0;
      //  }
        for (int i = myStart; i < myStop; i++){ //ypologismos istogrammatos kai apothikeysi sto topiko pinaka apo kathe nima
            localhist[(int)text[i]] ++;
        
        }
        
        
            
           
            for (int i=0; i < alphabetSize; i++){
            locks[i].lock();
            try{
            globalhist[i] += localhist[i]; //metafora ton periexomenon ton topikon pinakon ston katholiko pinaka
          
          }finally{
            locks[i].unlock();
            }
        
        }
    }
}

