package CommonUtills;

import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;

import java.util.Arrays;
import java.util.List;

public class SinhalaStopWords {
    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;
    ReadStopListFIleToStringArr read = new ReadStopListFIleToStringArr();
    String[] list = read.getStopList("/home/akash/Documents/SLIIT/CDAP/EvaluationJune26/stopList");

    public CharArraySet getStopWordCharSet() {
        List<String> stopWords = Arrays.asList(list);
        CharArraySet stopSet = new CharArraySet(Version.LUCENE_CURRENT, stopWords, false);
        ENGLISH_STOP_WORDS_SE11T = CharArraySet.unmodifiableSet(stopSet);
        return ENGLISH_STOP_WORDS_SE11T;
    }
}
