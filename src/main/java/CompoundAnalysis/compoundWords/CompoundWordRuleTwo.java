package CompoundAnalysis.compoundWords;

import CompoundAnalysis.dictionary.DictionaryWords;

public class CompoundWordRuleTwo implements CompoundWords {

    @Override
    public String compoundWordGenerate(String firstWord, String secondWord){
        String compoundWord;
        compoundWord = firstWord + secondWord.substring(1);
        return DictionaryWords.checkInDictionary(compoundWord, firstWord, secondWord);
    }
}
