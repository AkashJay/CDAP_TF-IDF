package CompoundAnalysis.words;

import CompoundAnalysis.dictionary.RootWordRepository;
import CompoundAnalysis.letters.Vowels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitCompoundWordRuleThree implements SplitCompoundWord {
    private List<String> rootWords = new ArrayList<String>();

    public SplitCompoundWordRuleThree() throws IOException {
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
                rootWord = rootWords.get(i) + "්";
                secondPart = compoundWord.substring(rootWords.get(i).length(), compoundWord.length());
                String secondPartStartingVovel = String.valueOf(Vowels.getVowel(secondPart.substring(0, 1)));
                if ("අ".equals(String.valueOf(Vowels.getVowel(secondPart.substring(0, 1))))){
                    secondWord = secondPartStartingVovel + secondPart;
                }else {
                    secondWord = secondPartStartingVovel + secondPart.substring(1, secondPart.length());
                }

            }
        }
        output = new TwoWords(rootWord, secondWord);

        return output;
    }
}
