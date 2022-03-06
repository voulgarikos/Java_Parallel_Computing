import java.util.concurrent.Semaphore;

public class MyBufferB1Sem {

   // int contents = 0;
	//int size;
	//int front, back;
        private volatile int counter = 0;
    private Semaphore buffeMutex = new Semaphore(1);
   

	// Constructor
        public MyBufferB1Sem() {
		//this.size = s;
         //   this.contents = cont;
		//for (int i=0; i<10; i++)
		//	contents[i] = 0;
           //     this.front = 0;
           //     this.back = size - 1;
     	}

// Put an item into buffer
public void put(int data) {

    
           
                    while (counter == 0) {
            //System.out.println("The buffer is full");
                    try {
                               
                                buffeMutex.acquire();
                                counter++;
            } catch (InterruptedException e) { }
                
        
                  
        //cont = data;
               
        System.out.println("Prod " + Thread.currentThread().getName() + " No "+ data +  " Count = " + counter);
        
         
        
                    }    
                  //  buffeMutex.release();
        }
                  


// Get an item from bufffer
public int get() {
            int data = 0;
    
           
        while (counter == 1) {
                    //System.out.println("The buffer is empty");
                            try {
                                  
                                   buffeMutex.acquire();
            } catch (InterruptedException e) { }
                
        //data = contents;
        System.out.println("  Cons " + Thread.currentThread().getName() + " No "+ data +  " Count = " + (counter-1));
                  // front = (front + 1) % size;
        counter--;
        
        
        
        
               //return data;
        }
        buffeMutex.release();
        return data;
}
    
}
