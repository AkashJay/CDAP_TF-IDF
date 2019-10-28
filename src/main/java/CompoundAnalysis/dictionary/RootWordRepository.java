package CompoundAnalysis.dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RootWordRepository {
    private static List<String> rootWords = new ArrayList<String>();

    public static List<String> getRootWordRepository() throws IOException {
        File inputFile = new File("/home/ZONE24X7-CMB/akashj/Documents/SLIIT/CDAP/TF-IDF/src/main/java/CompoundAnalysis/InputFiles/sinhala_root_words.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF8"));

        String lineText;
        rootWords = new ArrayList<String>();

        while ((lineText = bufferedReader.readLine()) != null ){
            String[] tmpArr = lineText.split("\\s+");

            rootWords.add(tmpArr[0]);


        }

        return rootWords;
    }

}
