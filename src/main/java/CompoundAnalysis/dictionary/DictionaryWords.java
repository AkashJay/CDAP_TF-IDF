package CompoundAnalysis.dictionary;

import CompoundAnalysis.words.WordRepository;

import java.io.IOException;
import java.util.List;

public class DictionaryWords {
    private static List<String> sinhalaWords;

    static {
        try {
            sinhalaWords = WordRepository.getWordRepository();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String checkInDictionary(String compoundWord, String firstWord, String secondWord){
        String output = "";
        for (int i = 0; i < sinhalaWords.size(); i++){
            if (compoundWord.equals(sinhalaWords.get(i))){
                output = compoundWord;
            }
        }
        if ("".equals(output)){
            output = firstWord + " " + secondWord;
        }
        return output;
    }
}
