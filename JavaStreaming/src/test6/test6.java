package test6;

import java.io.File; 
import java.io.IOException; 
import java.nio.file.Files;
import java.util.concurrent.TimeUnit; 
public class test6 {
	private static final long MEGABYTE = 1024L * 1024L;
    public static long btomb(long bytes) {
        return bytes / MEGABYTE;
    }
  public static void main(String [] pArgs) throws IOException {
	  long startTime = System.nanoTime();
    String fileName = "D:\\xyu.csv";
    File file = new File(fileName);
    byte [] fileBytes = Files.readAllBytes(file.toPath());
    char singleChar;
    for(byte b : fileBytes) {
      singleChar = (char) b;
      System.out.print(singleChar);
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