package StopWordRemoval;

import CommonUtills.TextToString;
import CommonUtills.WriteAnalyzedFile;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.io.File;

public class StopwordRemover {
    Version matchVersion = Version.LUCENE_42;
    Analyzer analyzer;

    //When Analyze documents using English StopWord list
    public StopwordRemover(){
         analyzer = new StandardAnalyzer(matchVersion);
    }

    //When you want to use a manual StopWord List
    public StopwordRemover(CharArraySet stopList){
        analyzer = new StandardAnalyzer(matchVersion, stopList);
    }

    //Analyze and write analyzed files to a new file
    public String analyzeDocument(String text) {

        //Analyze the string using StandardAnalyzer
        String analyzedString= TokenizeWithAnalyzer.tokenizeString(analyzer, text);
        return analyzedString;
    }
}
