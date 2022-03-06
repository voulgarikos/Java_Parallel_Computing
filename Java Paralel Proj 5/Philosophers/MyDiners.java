public class MyDiners {
    static final int numphils = 5;
    static final int sleeptime = 1;
    
    
     public static void main(String[] args) {
       MyPhilosopher[] phil= new MyPhilosopher[numphils];
       Fork[] fork = new Fork[numphils];

       for (int i =0; i<numphils; ++i)
            fork[i] = new Fork(i);
       for (int i =0; i<numphils; ++i){
            phil[i] = new MyPhilosopher(i, (i+1)%numphils, sleeptime,
                        fork[i], fork[(i+1)%numphils]);
            phil[i].start();
       }
    }
}
