class ReadAccount extends Thread {

    BankAccountMethodsLocks[] accounts;
    int i;

    public ReadAccount(int i,BankAccountMethodsLocks[] accounts){
        this.i = i;
        this.accounts = accounts;

    }

    public void run(){

        System.out.println("To ypoloipo sas einai" + accounts[i].getBalance());
    }
    
}
