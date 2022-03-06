/*Erg7 Voulgaris Konstantinos it9876
WestCarCond.java einai o kodikas ton nimaton gia ta aytokinita pou erxontai apo ditika */

public class WestCarCond extends Thread {

    private PassCond west_pass;

	
	public WestCarCond (PassCond wt)
	{
		west_pass = wt;
	}

	public void run()
	{
                for (int i = 0; i < 10; i++) {
                     west_pass.arrivedtoWest();
                     
                }
		
                
	}
}
