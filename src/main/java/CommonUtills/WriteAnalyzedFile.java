package CommonUtills;

import org.apache.lucene.analysis.Analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAnalyzedFile {

    public void writeAnalyzedDataToPlainTextFile(File dir, Analyzer analyzer) {
        //Document name incrementer
        int x = 0;
        try {
            //Loop through alll the files in directory
            for (File file : dir.listFiles()) {
                x++;
                //Read text file to a string
                String fileAsString = TextToString.readTextFile(file);

                //Analyze the string using StandardAnalyzer
                String analyzedString= TokenizeWithAnalyzer.tokenizeString(analyzer, fileAsString);

                System.out.println(analyzedString);
                //write preproceced data to newfile
                FileWriter fw=new FileWriter("/home/akash/Documents/SLIIT/CDAP/EvaluationJune26/Documents/AnlyzeEnglish/TestPreprocess/"+ x +".txt");
                fw.write(analyzedString);
                fw.close();
            }
        }
        catch (FileNotFoundException e1) {
            System.out.println("FIle Not Found");
            System.out.println(e1);
        } catch (IOException e2) {
            System.out.println(e2);
        } catch (NullPointerException e3){
            System.out.println(e3);
        }
    }
}
