package test7;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class apacheio {
    public static void main(String[] args) {
        // Create a file object of sample.txt
        File file = new File("D:\\xyu.csv");

        try {
            List<String> contents = FileUtils.readLines(file);

            // Iterate the result to print each line of the file.
            for (String line : contents) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}