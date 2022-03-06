/* Erg7 Voulgaris Konstantinos it9876 
MyBufferNMMon.java einai o kodikas tou buffer me tis methodous put kai get kai ti xrisi synchronized gia kleidoma*/

public class MyBufferNMMon {
    int[] contents;
	int size;
	int front, back;
    private boolean bufferEmpty = true;
    private boolean bufferFull = false;
        private volatile int counter = 0;


        public MyBufferNMMon(int s) {
            this.size = s;
                    contents = new int[size];
            for (int i=0; i<size; i++)
                contents[i] = 0;
                    this.front = 0;
                    this.back = size - 1;
             }
             public synchronized void put(int data) {

    
           
                while (bufferFull) {
        //System.out.println("The buffer is full");
                try {
                           wait();
        } catch (InterruptedException e) { }
            
    }
               back = (back + 1) % size;
    contents[back] = data;
            counter++;
    System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data + " Loc " + back + " Count = " + counter);
    bufferEmpty = false;
     
        
    }
              


// Get an item from bufffer
public synchronized int get() {
        int data = 0;

       
    while (bufferEmpty) {
                //System.out.println("The buffer is empty");
                        try {
                              wait();
        } catch (InterruptedException e) { }
            }
    data = contents[front];
    System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data + " Loc " + front + " Count = " + (counter-1));
               front = (front + 1) % size;
    counter--;
    bufferFull = false;

    
           return data;
}
}
