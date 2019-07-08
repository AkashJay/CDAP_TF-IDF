package CompoundAnalysis;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteToFile {
    public static void writeToFile(String string) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("output_file.txt", "UTF-8");
        writer.print(string);
        writer.close();
    }
}
