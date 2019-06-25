package CommonUtills;

import java.io.*;

public class TextToString {
    public static String readTextFile(File file) {
        //Read each text file as a separate string and return the String
        StringBuilder sb = new StringBuilder();

        try {
            InputStream is = new FileInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = null;
            line = buf.readLine();
            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
