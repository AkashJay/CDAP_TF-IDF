package CompoundAnalysis;

import CompoundAnalysis.compoundWords.CompoundWordGenerate;
import CompoundAnalysis.words.SplitCompoundWord;
import CompoundAnalysis.words.SplitCompoundWordRuleOne;

import java.io.*;

public class CompoundAnalysisMain {

    public String compoundAnalysis (String input) throws Exception {
        
        String output = "";
        CompoundWordGenerate compoundWordGenerate = new CompoundWordGenerate();

            String[] tmpArr = input.split("\\s+");

            for (int i = 1; i < tmpArr.length - 2; i++){
                if ((tmpArr[i] + " " + tmpArr[i+1]).equals(compoundWordGenerate.classifyRule(tmpArr[i], tmpArr[i+1]))){
                    i++;
                }
                output += compoundWordGenerate.classifyRule(tmpArr[i], tmpArr[i+1]) + " ";
            }

        return output;


    }
}
