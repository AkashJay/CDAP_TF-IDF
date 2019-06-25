package TestClasses; /**
 * Created by akash on 2/5/19.
 */

import CommonUtills.TokenizeWithAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.util.Arrays;
import java.util.List;

public class TestAnalyzer {

    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;


    public static void main(String[] args) {

//        final CharArraySet STOP_WORDS_SET1 = StopAnalyzer.ENGLISH_STOP_WORDS_SET;
//        System.out.println(STOP_WORDS_SET1);
        TokenizeWithAnalyzer an = new TokenizeWithAnalyzer();



        String text = "Lucene is simple yet powerful දෙවැනි java based search library";


        List<String> stopWords = Arrays.asList(new String[]{"a", "දෙවැනි", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "into", "is", "it",
                "no", "not", "of", "on", "or", "such", "that", "the", "there", "these", "they", "this", "to", "was", "will", "with"});
        CharArraySet stopSet = new CharArraySet(Version.LUCENE_CURRENT, stopWords, false);
        ENGLISH_STOP_WORDS_SE11T = CharArraySet.unmodifiableSet(stopSet);


        //StandardAnalyzer: Most sophisticated analyzer that consider general token types, lowercases, removes stop words and likewises
//        TestClasses.TestAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_42, ENGLISH_STOP_WORDS_SE11T);
        org.apache.lucene.analysis.Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42, ENGLISH_STOP_WORDS_SE11T);
        String ss= an.tokenizeString(analyzer, text);
        System.out.print("==>"+ss+" \n");
    }


}
