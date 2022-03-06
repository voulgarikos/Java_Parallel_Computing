/* Erg 5 Voulgaris Konstantinos it9876
BankAccountMethodLocks.java einai i klasi pou dilonei tis methodous deposit withdraw kai getbalance kai 
ektelei ta read write kleidomata
 */




public class BankAccountMethodsLocks {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private long balance;
    
  
    public BankAccountMethodsLocks(long balance) {
      this.balance = balance;
      
    }
  
    public void deposit(long amount) {
      lock.writeLock().lock();
      try {
        balance += amount;
      } finally {
        lock.writeLock().unlock();
      }
    }
  
    public void withdraw(long amount) {
      lock.writeLock().lock();
      try {
        balance -= amount;
      } finally {
        lock.writeLock().unlock();
      }
    }
  
    public long getBalance() {
      lock.readLock().lock();
      try {
        return balance;
      } finally {
        lock.readLock().unlock();
      }
    }  
}
