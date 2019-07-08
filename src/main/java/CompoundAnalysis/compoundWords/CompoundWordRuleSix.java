package CompoundAnalysis.compoundWords;

import CompoundAnalysis.dictionary.DictionaryWords;

public class CompoundWordRuleSix implements CompoundWords {
    @Override
    public String compoundWordGenerate(String firstWord, String secondWord){
        String compoundWord = "";
        if ("වා".equals(secondWord)){
            compoundWord = firstWord + "්" + firstWord.substring(firstWord.length() - 2, firstWord.length() - 1) + "ා";
        }else if (firstWord.length() > 1 && secondWord.length() > 1){
            compoundWord = firstWord + firstWord.substring(firstWord.length()-2, firstWord.length()-1) + secondWord.substring(1, secondWord.length());
        }else {
            compoundWord = firstWord + " " +secondWord;
        }

        return DictionaryWords.checkInDictionary(compoundWord, firstWord, secondWord);
    }
}
