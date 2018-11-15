package test7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class bufferreder {
	
	
	private static final long MEGABYTE = 1024L * 1024L;
    public static long btomb(long bytes) {
        return bytes / MEGABYTE;
    }	
	
  public static void main(String [] args) throws IOException {
	  long startTime = System.nanoTime();
    String fileName = "D:\\xyu.csv";
    FileReader fileReader = new FileReader(fileName);
    
    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      String line;
      while((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }
    }
    
    
 // Get the Java runtime
    Runtime runtime = Runtime.getRuntime();
    // Run the garbage collector
    runtime.gc();
    //Calculate time
    long endTime = System.nanoTime();
    long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
    System.out.println("Total elapsed time: " + elapsedTimeInMillis/1000 + " sec");
    // Calculate the used memory
    long memory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println("Used memory is bytes: " + memory);
    System.out.println("Used memory is megabytes: "+ btomb(memory));
    
    
    
    
  }
}