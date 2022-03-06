import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;




public class MyStrHist {

    public static void main(String args[]) throws IOException {

       
        String filepath = "C:/Users/voulg/Downloads/large/world192.txt";

        String fileString = new String(Files.readAllBytes(Paths.get(filepath)));
        
        
        long start = System.currentTimeMillis();
        
        char[] text = new char[fileString.length()]; 
        int n = fileString.length();
        for (int i = 0; i < n; i++) { 
            text[i] = fileString.charAt(i); 
        } 
 
        int alphabetSize = 256;
        int[] histogram = new int[alphabetSize]; 
        for (int i = 0; i < alphabetSize; i++) { 
            histogram[i] = 0; 
        }
        
        for (int i = 0; i < n; i++) {
                histogram[(int)text[i]] ++;
        }

        for (int i = 0; i < alphabetSize; i++) { 
            System.out.println((char)i+": "+histogram[i]);
        }
        // get current time and calculate elapsed time
    long elapsedTimeMillis = System.currentTimeMillis()-start;
    System.out.println("time in ms = "+ elapsedTimeMillis);
   }
    
}
