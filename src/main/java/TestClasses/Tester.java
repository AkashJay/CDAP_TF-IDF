package TestClasses;

/**
 * Created by akash on 2/5/19.
 */
public class Tester {

//    public static CharArraySet ENGLISH_STOP_WORDS_SE11T;
//
//
//    public static void main(String[] args) {
//        int x = 0;
//
//        File dir = new File("/home/akash/Documents/TestPDocuments/");
//        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
//
//        for (File file : dir.listFiles()) {
//            x++;
//
//            try {
//                InputStream is = new FileInputStream(file);
//                BufferedReader buf = new BufferedReader(new InputStreamReader(is));
//
//                String line = buf.readLine();
//                StringBuilder sb = new StringBuilder();
//                while(line != null){
//                    sb.append(line).append("\n");
//                    line = buf.readLine();
//                }
//                String fileAsString = sb.toString();
//                String ss= TokenizeWithAnalyzer.tokenizeString(analyzer, fileAsString);
//                System.out.println(ss);
//
//
//                FileWriter fw=new FileWriter(".//"+ x +".txt");
//                fw.write(ss);
//                fw.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }


}




//The default stop words set in StandardAnalyzer and EnglishAnalyzer is from StopAnalyzer.ENGLISH_STOP_WORDS_SET, and they are:
//
//        "a", "an", "and", "are", "as", "at", "be", "but", "by",
//        "for", "if", "in", "into", "is", "it",
//        "no", "not", "of", "on", "or", "such",
//        "that", "the", "their", "then", "there", "these",
//        "they", "this", "to", "was", "will", "with"
//        StopFilter itself defines no default set of stop words.


