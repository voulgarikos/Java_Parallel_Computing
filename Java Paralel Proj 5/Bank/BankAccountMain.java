/*Erg 5 Voulgaris Konstantinos it9876
BankAccountMain.java, to kyrios programma pou dimiourgei kai gemizei ena pinaka me logariasmous trapezas
kai dimiourgei kai ksekina nimata pou diavazoun kai ekteloun katatheseis kai analipsis apo tous logariasmous */


import java.io.*;
import java.util.concurrent.locks.*;


public class BankAccountMain {

    public static void main(String[] args) {
// Dilosi metavliton gia to plithos ton anagnoseon kai eggrafon stous logariasmous kai to plithos ton logariasmon
     int readThread = 1000;
     int writeThread = 100; 
     int nAccounts = 150;  

//dimiourgia pinaka logariasmon kai gemisma me posa  

    BankAccountMethodsLocks[] accnts = new BankAccountMethodsLocks[nAccounts];
    for (int i=0;i<nAccounts;i++){
        accnts[i] = new BankAccountMethodsLocks( (i+100)+(i*500));
    }

    //dimiourgia nimaton anagnosis
    ReadAccount[] reading = new ReadAccount[readThread];

    for (int i=0;i<readThread;i++){
        reading[i] = new ReadAccount(i,accnts);
        reading[i].start();
        
        try {
            reading[i].join();
        } catch (Exception e) {}
    }
    //dimiourgia nimaton eggrafis gia katathesi
    WriteAccountDeposit[] writingd = new WriteAccountDeposit[writeThread];

    for (int i=0;i<writeThread;i++){
        writingd[i] = new WriteAccountDeposit(i,accnts);
        writingd[i].start();
        

        try {
            writingd[i].join();
        } catch (Exception e) {}
    }

                             //dimiourgia nimaton eggrafis gia analipsi

    WriteAccountWithdraw[] writingw = new WriteAccountWithdraw[writeThread];

    for (int i=0;i<writeThread;i++){
        writingw[i] = new WriteAccountWithdraw(i,accnts);
        writingw[i].start();
    }
    for (int i=0;i<writeThread;i++){
        try {
            writingw[i].join();
        } catch (Exception e) {}
    }
    }
}

