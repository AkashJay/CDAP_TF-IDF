package LanguageAnlyzers;

import CommonUtills.*;
import org.apache.lucene.analysis.util.CharArraySet;

import java.io.File;

public class AnalyzeSinhala {
    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;


    public static void main(String[] args) {

        //Directory path to files to be analyzed
        File dir = new File("/home/akash/Documents/SLIIT/CDAP/EvaluationJune26/Documents/AnlyzeEnglish/TestPreprocess/");

        //GetSinhala Stopword list
        SinhalaStopWords stopListObj = new SinhalaStopWords();
        CharArraySet stopList = stopListObj.getStopWordCharSet();

        //Initiate StandardAnalyzer object with default or sinhala stopword list
        AnalyzeDocuments analyzer = new AnalyzeDocuments();
        analyzer.analyzeDocument(dir);

        System.out.println("Document analysis successful");

    }



}
