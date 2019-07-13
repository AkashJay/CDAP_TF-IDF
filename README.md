# CDAP_TF-IDF
<h2> Machine Laearning Preprocessing Analyzer for sinhala language </h2>


<p>Apache Lucene is a free open-source information software library which is originally completely written
in Java. This library includes many analyzers to index different contents in different languages and
domains.
<br>
(List of Analyzers which are currently available -&gt;
https://lucene.apache.org/core/7_5_0/analyzerscommon/index.html).
<br>
Most frequently used analyzer is English Analyzer. Some languages like Sinhala still don&#39;t have their own
analyzers, so they use English analyzer to analyze the document contents. Since these are two different
languages it is not much accurately analyzed. Sinhala language which is our mother tongue is also facing
the same issues. Most of available analyzing techniques are language dependent.
Here are the main techniques used in analyzers ; <br>

<ul>
  <li>Up to 40+ languages have identified their language specific stopwords (extremely Common
words which would appear to be little value in helping select  documents matching user needs).
(https://www.ranks.nl/stopwords) But still there is no stopword list for Sinhala language.</li>
  <li>Stemming algorithms (stemming is the process of reducing inflected or sometimes derived words
to their word stem, root  form/ generally a written word form) are language dependent, So we
can’t use any other languages’ stemming algorithms to Sinhala language.</li>
  <li>Lemmatization algorithms( Lemmatization (or lemmatization) in linguistics  is the process of
grouping together the inflected forms of a word so they can be analysed as a single item,
identified by the word&#39;s lemma, or dictionary form) also language dependent. To apply
Lemmatization algorithms there should be proper understand about language.</li>
  <li>Tokenizing contents is different from one language to other. We can’t use one languages’
tokenization method to tokenize other language content.Also we should have proper language
model and assign a probability to suitable span of text(word/sentence/corpus/..).</li>
</ul>  

</p>
