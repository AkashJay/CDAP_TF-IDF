package LanguageAnlyzers;

import CommonUtills.TextToString;
import CompoundAnalysis.CompoundAnalysisMain;
import Stemming.SinhalaStemmer;
import StopWordRemoval.*;
import Tokenization.SinhalaTokenizer;
import org.apache.lucene.analysis.util.CharArraySet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyzeSinhala {
    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;


    public static void main(String[] args) {

        //Directory path to files to be analyzed
        File dir = new File("/home/akash/Documents/SLIIT/CDAP/EvaluationJune26/Documents/AnlyzeSinhala/TestPreprocess/");

        //GetSinhala Stopword list
        SinhalaStopWords stopListObj = new SinhalaStopWords();
        CharArraySet stopList = stopListObj.getStopWordCharSet();

        //Initiate StandardAnalyzer object with default or sinhala stopword list
        StopwordRemover stopwordRemover1 = new StopwordRemover(stopList);
        CompoundAnalysisMain compoundAnalysisMain = new CompoundAnalysisMain();
        SinhalaTokenizer sinhalaTokenizer = new SinhalaTokenizer();
        SinhalaStemmer sinhalaStemmer = new SinhalaStemmer();




        //Document name incrementer
        int x = 0;
        try {
            //Loop through alll the files in directory
            for (File file : dir.listFiles()) {
                x++;
                //Read text file to a string
                String fileAsString = TextToString.readTextFile(file);

                //Tokenization Processs
//                String tokenizeText = sinhalaTokenizer.tokenize(fileAsString);

                System.out.println(fileAsString);

                //compound analysis
                String compound = compoundAnalysisMain.compoundAnalysis(fileAsString);

                //StopWordRemover Processs
//                String stopwordRemover = stopwordRemover1.analyzeDocument(compound);

                //Stemming Processs
//                String stemm = sinhalaStemmer.stemmDOcuments(stopwordRemover);

                //Lemmatization Processs


                System.out.println(compound);
                //write preproceced data to newfile
                FileWriter fw=new FileWriter("/home/akash/Documents/SLIIT/CDAP/EvaluationJune26/Documents/AnlyzeSinhala/TestPreprocess/"+ x +".txt");
                fw.write(compound);
                fw.close();
                System.out.println("Document analysis successful");
            }
        }
        catch (FileNotFoundException e1) {
            System.out.println("FIle Not Found");
            System.out.println(e1);
        } catch (IOException e2) {
            System.out.println(e2);
        } catch (NullPointerException e3){
            System.out.println(e3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
