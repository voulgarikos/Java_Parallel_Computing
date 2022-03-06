//Ergasia 1 Voulgaris Konstantinos it9876
//helloanonymous.java
//The programm creates threads with anonymous class method

public class helloanonymous {
    public static void main(String[] args){
    //Creating an object of Anonymous class which extends Thread class and passing this object to the reference of Thread class.
        Thread t= new Thread(){ 	
    //Anonymous class overriding run() method of Thread class    
            public void run()	
        {
        setName("Anonymous Thread");	
        System.out.println("Name of the other thread - " + getName());
        int numCores = Runtime.getRuntime().availableProcessors();
        for(int i=0;i<numCores;i++)
        {
            System.out.println(getName() + " " + i);
        }
    
        }
        };				
        
    //Starting anonymous thread
    t.start();
    
    //Gets the name of main thead
    System.out.println("Name of main thread - "+ Thread.currentThread().getName()); 
    }
}
