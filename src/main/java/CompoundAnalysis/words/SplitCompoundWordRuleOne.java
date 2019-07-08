package CompoundAnalysis.words;

import CompoundAnalysis.dictionary.RootWordRepository;
import CompoundAnalysis.letters.Vowels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitCompoundWordRuleOne implements SplitCompoundWord {
    private List<String> rootWords = new ArrayList<String>();

    public SplitCompoundWordRuleOne() throws IOException {
        this.rootWords = RootWordRepository.getRootWordRepository();
    }

    @Override
    public TwoWords splitCompoundWord(String compoundWord) {
        TwoWords output;
        String rootWord = "";
        String secondPart;
        String secondWord = "";

        for (int i = 0; i < rootWords.size(); i++) {
            if (compoundWord.contains(rootWords.get(i))) {
                rootWord = rootWords.get(i);
                secondPart = compoundWord.substring(rootWords.get(i).length(), compoundWord.length());
                String secondPartStartingVowel = String.valueOf(Vowels.getVowel(String.valueOf(secondPart.charAt(0))));
                if ("අ".equals(String.valueOf(Vowels.getVowel(String.valueOf(secondPart.charAt(0)))))){
                    secondWord = secondPartStartingVowel + secondPart;
                    rootWord += "ු";
                }else {
                    secondWord = secondPartStartingVowel + secondPart.substring(1);
                }
            }
        }

        output = new TwoWords(rootWord, secondWord);
        return output;
    }
}
