public class WestCarMon extends Thread {

    private PassMon west_pass;

	
	public WestCarMon (PassMon wst)
	{
		west_pass = wst;
	}

	public void run()
	{
                for (int i = 0; i < 10; i++) {

                     west_pass.arrivetoWest();
                    
                }
		
                
	}
    
}
