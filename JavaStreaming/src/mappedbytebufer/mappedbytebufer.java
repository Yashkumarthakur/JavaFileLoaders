package mappedbytebufer;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class mappedbytebufer {
     public static void main(String[] args) {
         
            long startTime = System.nanoTime();
     
            try {
                RandomAccessFile aFile = new RandomAccessFile("D:\\\\xyu.csv", "r");
                FileChannel inChannel = aFile.getChannel();
                MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
                
                for (int i = 0; i < buffer.limit(); i++) {
                    byte read = buffer.get();
                    System.out.print((char)read);
                    
                }
                aFile.close();
                
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
     
            long endTime = System.nanoTime();
            long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
            System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
        }
}
