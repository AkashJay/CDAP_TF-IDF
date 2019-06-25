package CommonUtills;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.io.File;

public class AnalyzeDocuments {
    Version matchVersion = Version.LUCENE_42;
    Analyzer analyzer;

    //When Analyze documents using English StopWord list
    public AnalyzeDocuments(){
         analyzer = new StandardAnalyzer(matchVersion);
    }

    //When you want to use a manual StopWord List
    public AnalyzeDocuments(CharArraySet stopList){
        analyzer = new StandardAnalyzer(matchVersion, stopList);
    }

    //Analyze and write analyzed files to a new file
    public void analyzeDocument(File dir) {
        WriteAnalyzedFile writeAnalyzedFile = new WriteAnalyzedFile();
        writeAnalyzedFile.writeAnalyzedDataToPlainTextFile(dir, analyzer);
    }
}
