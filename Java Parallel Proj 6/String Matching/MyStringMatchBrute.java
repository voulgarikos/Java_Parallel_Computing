import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*; 



public class MyStringMatchBrute {
    
    public static void main(String[] args) throws IOException {

        String filepath = "C:/Users/voulg/Downloads/large/world192.txt";

        String fileString = new String(Files.readAllBytes(Paths.get(filepath)));//, StandardCharsets.UTF_8);
        
        long start = System.currentTimeMillis();

        char[] text = new char[fileString.length()]; 
        int n = fileString.length();
        for (int i = 0; i < n; i++) { 
            text[i] = fileString.charAt(i); 
        } 
        String patternString = new String("Exclusive economic zone");                                                
        char[] pattern = new char[patternString.length()]; 
        int m = patternString.length(); 
        for (int i = 0; i < m; i++) { 
            pattern[i] = patternString.charAt(i); 
        }

        int matchLength = n - m;
        char[] match = new char[matchLength+1]; 
        for (int i = 0; i <= matchLength; i++) { 
            match[i] = '0'; 
        }
        // get current time
    
        /*ArrayList<Integer> match = new ArrayList<Integer>(); */
        int matchCount = 0;
        for (int j = 0; j < n-m; ++j) {
                int i;
      		for (i = 0; i < m && pattern[i] == text[i + j]; ++i);
      		if (i >= m) {
         		match[j] = '1';
                        matchCount++;
                }        
        }


        for (int i = 0; i < matchLength; i++) { 
            if (match[i] == '1') System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Total matches " + matchCount);
        // get current time and calculate elapsed time
    long elapsedTimeMillis = System.currentTimeMillis()-start;
    System.out.println("time in ms = "+ elapsedTimeMillis);
   }
    }


