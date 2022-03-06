public class EastCarMon extends Thread {

    private PassMon east_pass;

	
	public EastCarMon (PassMon est)
	{
		east_pass = est;
	}

	public void run()
	{
                for (int i = 0; i < 10; i++) {

                     east_pass.arrivetoEast();
                    
                }
		
                
	}
    
}
