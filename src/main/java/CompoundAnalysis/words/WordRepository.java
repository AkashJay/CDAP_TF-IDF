package CompoundAnalysis.words;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordRepository {
    private static List<String> wordList;


    public static List<String> getWordRepository() throws IOException {
        File inputFile = new File("/home/akash/Documents/SLIIT/CDAP/TF-IDF/src/main/java/CompoundAnalysis/InputFiles/sinhala_words.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF8"));

        String lineText;
        wordList = new ArrayList<String>();

        while ((lineText = bufferedReader.readLine()) != null ){
            String[] tmpArr = lineText.split("\\s+");

            wordList.add(tmpArr[0]);


        }

        return wordList;
    }

}
