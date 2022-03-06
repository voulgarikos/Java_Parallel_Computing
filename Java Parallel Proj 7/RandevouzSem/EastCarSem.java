class EastCarSem extends Thread {

    private PassSem east_pass;

	
	public EastCarSem (PassSem e)
	{
		east_pass = e;
	}

	public void run()
	{
                for (int i = 0; i < 1; i++) {
                     east_pass.arriveEast();
                     east_pass.pass();
                     east_pass.departEast();
                }
		
                
	}
    
}
