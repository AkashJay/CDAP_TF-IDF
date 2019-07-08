package CompoundAnalysis.compoundWords;

import CompoundAnalysis.words.*;

import java.io.IOException;

public class CompoundWordGenerate {
    private CompoundWords compoundRuleOne = new CompoundWordRuleOne();
    private CompoundWords compoundRuleTwo = new CompoundWordRuleTwo();
    private CompoundWords compoundRuleThree = new CompoundWordRuleThree();
    private CompoundWords compoundRuleSix = new CompoundWordRuleSix();
    private SplitCompoundWord splitCompoundWordRuleOne = new SplitCompoundWordRuleOne();
    private SplitCompoundWord splitCompoundWordRuleTwo = new SplitCompoundWordRuleTwo();
    private SplitCompoundWord splitCompoundWordRuleThree = new SplitCompoundWordRuleThree();
    private String firstRuleOutputCompound;
    private String secondRuleOutputCompound;
    private String thirdRuleOutputCompound;
    private String sixthRuleOutputCompound;

    public CompoundWordGenerate() throws IOException {

    }

    public String classifyRule(String firstWord, String secondWord){
        String sameOutput = firstWord + " " + secondWord;
        String output = "";

        firstRuleOutputCompound = compoundRuleOne.compoundWordGenerate(firstWord, secondWord);
        secondRuleOutputCompound = compoundRuleTwo.compoundWordGenerate(firstWord, secondWord);
        thirdRuleOutputCompound = compoundRuleThree.compoundWordGenerate(firstWord, secondWord);
        sixthRuleOutputCompound = compoundRuleSix.compoundWordGenerate(firstWord, secondWord);

        TwoWords splitTwoWordsRuleOne = splitCompoundWordRuleOne.splitCompoundWord(firstRuleOutputCompound);
        TwoWords splitTwoWordsRuleTwo = splitCompoundWordRuleTwo.splitCompoundWord(secondRuleOutputCompound);
        TwoWords splitTwoWordsRuleThree = splitCompoundWordRuleThree.splitCompoundWord(thirdRuleOutputCompound);

        if (!sameOutput.equals(secondRuleOutputCompound) && splitTwoWordsRuleTwo.getFirstWord().equals(firstWord) && splitTwoWordsRuleTwo.getSecondWord().equals(secondWord)){
            output = secondRuleOutputCompound;
        }else if (!sameOutput.equals(thirdRuleOutputCompound) && splitTwoWordsRuleThree.getFirstWord().equals(firstWord) && splitTwoWordsRuleThree.getSecondWord().contains(secondWord)){
            output = thirdRuleOutputCompound;
        }else if (!sameOutput.equals(firstRuleOutputCompound) && splitTwoWordsRuleOne.getFirstWord().contains(firstWord) && splitTwoWordsRuleOne.getSecondWord().contains(secondWord)){
            output = firstRuleOutputCompound;
        }else {
            output = firstWord + " " + secondWord;
        }

        return output;
    }
}
