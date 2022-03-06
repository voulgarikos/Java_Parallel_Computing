/*Erg 7 it9876
MyRandevouzMainCond.java einai to kyrios programma pou leinei to provlima tou moirazomenou porou me rantevou
sto programma exoume ti dieleusi me ti seira 2 aytokiniton apo 'steni' gefyra erxomena apo anatolika kai ditika antistoixa.
Xrisimopoio Lock Conditions  */

public class MyRandevouzMainCond {

    public static void main(String[] args) 
    {
        PassCond x = new PassCond();
		int cars = 5;
        EastCarCond est[] = new EastCarCond[cars];
        WestCarCond wst[] = new WestCarCond[cars];

           	for (int i=0; i<cars; i++) {
      			est[i] = new EastCarCond(x);
                wst[i] = new WestCarCond(x);  
        		est[i].start(); 
                wst[i].start();
      		}
      		for (int i=0; i<cars; i++) 
        		try { 
           			 est[i].join();
                     wst[i].join(); 
       			} catch (InterruptedException e) { }
    	}
		
}
    

