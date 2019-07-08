package CompoundAnalysis.compoundWords;

import CompoundAnalysis.dictionary.DictionaryWords;
import CompoundAnalysis.letters.Vowels;

public class CompoundWordRuleOne implements CompoundWords{
    @Override
    public String compoundWordGenerate(String firstWord, String secondWord){
        String compoundWord = "";
        if ('අ' == Vowels.getVowel(firstWord.substring(firstWord.length() -1))){
            compoundWord = firstWord + Vowels.getCharAddon(secondWord.substring(0,1)) + secondWord.substring(1);
        }else {
            compoundWord = firstWord.substring(0,firstWord.length()-1) + secondWord.substring(1, secondWord.length());
        }
        return DictionaryWords.checkInDictionary(compoundWord, firstWord, secondWord);
    }
}
