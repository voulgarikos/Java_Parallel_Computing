class WriteAccountDeposit extends Thread {
private long amount;
BankAccountMethodsLocks[] accnt;
int i;

public WriteAccountDeposit(int i, BankAccountMethodsLocks accnt){

    this.i = i;
    this.accnt = accnt;
    amount = (i*5) + 200;
}
    public void run(){
    
    
      accnt[i].deposit(amount);
   
    }
}


    

