/*Erg 5 Voulgaris Konstantinos it9876
Kodikas klasis nimaton MyPhilosopher.java apofygi kiklikis anamonis me anathesi sygkekrimenon moirazomenon metavliton se sygkekrimenous
filosofous, oi filosofoi me artio id pairnoun ta deksia pirounia kai aytoi me perito ta aristera. To programma 'trexei' atermona*/ 

class MyPhilosopher extends Thread {
    private int identity;
  private Fork left;
  private Fork right;
  private int scale;
  private int next;

  MyPhilosopher(int id, int n, int s, Fork l, Fork r) {
    	identity = id; next = n; scale = s; left = l; right = r; 
  }

  public void run() {
     while (true) {
        
        //thinking
	System.out.println(" Philosopher "+ identity + " is thinking");
        delay(scale);
        //hungry elegxos gia artio id
         if (identity%2==0){
       	System.out.println(" Philosopher "+ identity+ " is trying to get fork " + identity);
        right.get();
        System.out.println(" Philosopher "+ identity + " is releasing fork " + identity);
	//delay(scale);
        right.put();
        }
        else{ //gotright chopstick
	System.out.println(" Philosopher "+ identity+ " got fork " + identity + " and is trying to get fork " + next);
        left.get();
        System.out.println(" Philosopher "+ identity + " is eating");
        //eating
    
        System.out.println(" Philosopher "+ identity + " is releasing left fork " + next);
        //delay(scale);
        left.put();
        
	
        }    
    }    
  }

  public void delay(int scale) {
	try {
         	 sleep((int)(Math.random()*scale));
        	} catch (InterruptedException e) { }
  }
    
}
