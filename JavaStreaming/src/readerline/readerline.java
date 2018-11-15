package readerline;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class readerline {

    public static void main(String[] args) throws FileNotFoundException {
    	 long startTime = System.nanoTime();

        File filePath = new File("D:\\xyu.csv");

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        reader.lines().forEach(line -> {
            // process liness
            System.out.println(line);
        });
        
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }

}
