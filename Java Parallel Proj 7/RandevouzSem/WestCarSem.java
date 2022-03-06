class WestCarSem extends Thread{
    private PassSem west_pass;

	
	public WestCarSem (PassSem w)
	{
		west_pass = w;
    
	}

	public void run()
	{
                for (int i = 0; i < 1; i++) {
                     west_pass.arriveWest();
                     west_pass.pass();
                     west_pass.departWest();
                }
		
                
	}
    
}
