package filepath;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class filepath {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
      
        try
        {
            Path file = Paths.get("D:\\xyu.csv");
       
            List<String> readAllLines = Files.readAllLines(file, StandardCharsets.UTF_8);
            
            for (String string : readAllLines) {
            System.out.println(string);
        }
           
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
 
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}

