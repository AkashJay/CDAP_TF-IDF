package CompoundAnalysis.compoundWords;

import CompoundAnalysis.dictionary.DictionaryWords;
import CompoundAnalysis.letters.Vowels;

public class CompoundWordRuleThree implements CompoundWords {
    @Override
    public String compoundWordGenerate(String firstWord, String secondWord){
        String compoundWord = "";
        if ("අ".equals(secondWord.substring(0,1))){
            compoundWord = firstWord.substring(0, firstWord.length() -1) + secondWord.substring(1);
        }else {
            compoundWord = firstWord.substring(0, firstWord.length() -1) + Vowels.getCharAddon(secondWord.substring(0,1));
            compoundWord = compoundWord + secondWord.substring(1);
        }
        return DictionaryWords.checkInDictionary(compoundWord, firstWord, secondWord);
    }
}
