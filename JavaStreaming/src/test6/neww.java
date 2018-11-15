
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class neww {
	private static final long MEGABYTE = 1024L * 1024L;
    public static long btomb(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void main(String[] args) throws IOException { 
    	long startTime = System.nanoTime();
    	long line = 00;
    	// 46208813 no of lines
        String fileName = "D:\\xyu.csv"; //this path is on my local
        // lines(Path path, Charset cs)
        try (Stream inputStream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            inputStream.forEach(System.out::print);
//            inputStream.forEach(str -> System.out.println(str+"::"+line));
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


