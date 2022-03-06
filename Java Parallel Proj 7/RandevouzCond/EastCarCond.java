/*Erg7 Voulgaris Konstantinos it9876
EastCarCond.java einai o kodikas ton nimaton gia ta aytokinita pou erxontai apo anatolika */

public class EastCarCond extends Thread {
    
    private PassCond east_pass;

	
	public EastCarCond (PassCond et)
	{
		east_pass = et;
	}

	public void run()
	{
                for (int i = 0; i < 10; i++) {
                     east_pass.arrivedtoEast();
                   
                }
		
                
	}
}
