package StopWordRemoval; /**
 * Created by akash on 2/5/19.
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TokenizeWithAnalyzer {

    public TokenizeWithAnalyzer() {}

    public static String tokenizeString(Analyzer analyzer, String str) {
        List result = new ArrayList();
        StringBuffer a = new StringBuffer();
        try {
            TokenStream stream  = analyzer.tokenStream(null, new StringReader(str));
            stream.reset();
            while (stream.incrementToken()) {
                a.append(stream.getAttribute(CharTermAttribute.class).toString()+ " ");
                result.add(stream.getAttribute(CharTermAttribute.class).toString());
            }
        } catch (IOException e) {
            // not thrown b/c we're using a string reader...
            throw new RuntimeException(e);
        }
        return a.toString();
    }

}
