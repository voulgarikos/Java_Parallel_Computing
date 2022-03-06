/*Erg7 Voulgaris Konstantinos it9876
MyBufferNMSem.java einai o kodikas tou buffer pou xrisimopoiei semaphores gia idiaitero kleidoma ton get kai put
kai buffer size = 10 theseis */

import java.util.concurrent.Semaphore;

public class MyBufferNMSem {

    int[] contents;
	int size;
	int front, back;
        private volatile int counter = 0;
    private Semaphore buffeMutex = new Semaphore(1);
    private Semaphore ItemsToGet = new Semaphore(0);
    private Semaphore ItemsToPut = new Semaphore(size);

	// Constructor
        public MyBufferNMSem(int s) {
		this.size = s;
                contents = new int[size];
		for (int i=0; i<size; i++)
			contents[i] = 0;
                this.front = 0;
                this.back = size - 1;
     	}

// Put an item into buffer
public void put(int data) {

    
           
                    while (counter == size) {
            //System.out.println("The buffer is full");
                    try {
                                ItemsToPut.acquire();
                                buffeMutex.acquire();
            } catch (InterruptedException e) { }
                
        }
                   back = (back + 1) % size;
        contents[back] = data;
                counter++;
        System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data + " Loc " + back + " Count = " + counter);
        
         ItemsToGet.release();
         buffeMutex.release();
            
        }
                  


// Get an item from bufffer
public int get() {
            int data = 0;
    
           
        while (counter == 0) {
                    //System.out.println("The buffer is empty");
                            try {
                                   ItemsToGet.acquire();
                                   buffeMutex.acquire();
            } catch (InterruptedException e) { }
                }
        data = contents[front];
        System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data + " Loc " + front + " Count = " + (counter-1));
                   front = (front + 1) % size;
        counter--;
        ItemsToPut.release();
        buffeMutex.release();
    
        
               return data;
}
}