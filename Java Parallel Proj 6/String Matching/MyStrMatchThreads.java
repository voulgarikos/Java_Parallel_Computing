/*Erg 6 Voulgaris Konstantinos it9876
MyStrMatchThreads.java i klasi nimaton tou programmatos  */ 
 
 
 
 class MyStrMatchThreads extends Thread{

  //dilosi topikon metavliton  
    private int myId;
    private int myStart;
    private int myStop;
   
    private int patternsize;
   
    private int matchCount = 0;
    private int block;
    private char[] text;
    private char[] pattern;
    private char[] match;
//constructor
    public MyStrMatchThreads(int i, int nThreads, char[] text, char[] pattern, char[] match, int textsize,int patternsize){
       
        this.myId = i;
        
        this.text = text;
        this.pattern = pattern;
        this.match = match;
        this.patternsize = patternsize;
       
        
        
        //SPMD
        block = ((textsize)/nThreads);
        myStart = myId * block;
        myStop = block + myStart;
            if (myId == nThreads - 1) {
                myStop = textsize;}
    }
    //kodikas nimaton
    public void run() {
     //ypologismos matchCount kai thesis sto keimeno
     
        for (int j = myStart; j < myStop; ++j) {
                int i;
      		for (i = 0; i < patternsize && pattern[i] == text[i + j]; ++i);
      		if (i >= patternsize) {
         		match[j] = '1';
                        matchCount++;
                } 
            }    
        }   
    //methodos get pou epistrefei tin timi tou moirazomenou metriti
    public int get() {
        return matchCount;
    }

    
}
