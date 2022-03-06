class WriteAccountWithdraw extends Thread {
    private long amount;
BankAccountMethodsLocks[] accnt;
int i;

public WriteAccountWithdraw(int i, BankAccountMethodsLocks accnt){

    this.i = i;
    this.accnt = accnt;
    amount = (i*5) + 200;
}
    public void run(){
    
        if (accnt[i].getBalance()>600){
      accnt[i].withdraw(amount);
        }
        else{
            System.out.println("To ypoloipo sas den eparkei");
        }
   

}
}
