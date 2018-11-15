package test4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

class test{
	public static void main(String[] args) throws IOException {
RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\xyu.csv", "r");
    MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
    byte[] data = new byte[100];  // Needs to be Byte Array only as MappedBuffer play only with Byte[]
    while (mappedByteBuffer.hasRemaining()) {
      int remaining = data.length;
      if(mappedByteBuffer.remaining() < remaining)
        remaining = mappedByteBuffer.remaining();
      ByteBuffer s=mappedByteBuffer.get(data, 0, remaining);
      // do somthing with data
      System.out.println(mappedByteBuffer);
      System.out.println("::"+mappedByteBuffer.get(data, 0, remaining));
    }
    randomAccessFile.close();
}
}