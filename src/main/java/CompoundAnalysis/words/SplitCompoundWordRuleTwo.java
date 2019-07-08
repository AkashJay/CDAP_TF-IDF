package CompoundAnalysis.words;

import CompoundAnalysis.dictionary.RootWordRepository;
import CompoundAnalysis.letters.Vowels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitCompoundWordRuleTwo implements SplitCompoundWord {
    private List<String> rootWords = new ArrayList<String>();

    public SplitCompoundWordRuleTwo() throws IOException {
        this.rootWords = RootWordRepository.getRootWordRepository();
    }

    @Override
    public TwoWords splitCompoundWord(String compoundWord) {
        TwoWords output;
        String rootWord = "";
        String secondWord = "";

        for (int i = 0; i < rootWords.size(); i++){
            if (compoundWord.contains(rootWords.get(i))){
                rootWord = rootWords.get(i);
                secondWord = compoundWord.substring((rootWord.length()),compoundWord.length());
                char secondWordBeginningChar;

                if (secondWord.length() == 1 || "අ".equals(Vowels.getVowel(String.valueOf(secondWord.charAt(1))))){
                    secondWordBeginningChar = Vowels.getVowel("");
                }else {
                    char secondWordFirstCharacterVowel = secondWord.charAt(1);
                    secondWordBeginningChar = Vowels.getVowel(Character.toString(secondWordFirstCharacterVowel));
                }

                secondWord = Character.toString(secondWordBeginningChar).concat(secondWord);
                break;
            }
        }
        output = new TwoWords(rootWord, secondWord);
        return output;
    }
}
