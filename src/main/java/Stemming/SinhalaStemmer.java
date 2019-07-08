package Stemming;

import org.apache.lucene.util.ArrayUtil;

import java.io.*;
import java.util.*;
import java.util.Arrays;
//import org.apache.lucene.util.ArrayUtil;


public class SinhalaStemmer {
	
	private char[] b;
	private char[] b0;
	  private int i,    /* offset into b */
	    j, k, k0;
	  private boolean dirty = false;
	  private static final int INITIAL_SIZE = 50;
	  private static final String suffix_list[] ={"වල්","මත්","වත්","යි","මින්","න","ති","ද්දි","තත්","තොත්","මු","න්ට","ති","ට","ගේ","ගෙන්","මි","තොත්","ත්ම","න්න","න්නේ","න්ට","කර", "කලු", "කාරී", "දායක", "දායි", "බඳ", "බර", "මත්", "මය", "වත්"};
	 private static final String front[] = {"ෙ","ේ"};
	  private static final String back[] = {"්","ා","ි"};
	  private static final String prefix_list[] ={"අති","ස්ව","සු","සහ","සත්","සං","ස","වි","ප්රති","පුනර්"};
	  public SinhalaStemmer() {
		    b = new char[INITIAL_SIZE];
		    i = 0;
		  }
	  
	public ArrayList<String> stemming(ArrayList<String> l) {
		HashMap<String,Integer> stemmedWords = new HashMap<String, Integer>();
		ArrayList<String> stemwordlist = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			b=l.get(i).toCharArray();
			k=b.length-1;
			/*for (int j = 0; j < b.length; j++) {
				System.out.println(i+" "+b[j]);
			}*/
			//step0();

            if(k>3) step2();
            if(k>3) step1();
//			step2(); //may repeat
//			step1();
			if(k>5) step3();

			String ss = new String(b);
			if(stemmedWords.containsKey(ss)){

			}
			else {
				stemmedWords.put(ss,1);
				stemwordlist.add(ss);
			}
			/*for (int j = 0; j < b.length; j++) {
				System.out.print(b[j]);
			}*/

		}
		//System.out.println(stemwordlist);
		return stemwordlist;
	}
	
	
	//add new  a 1 character to b at the end
	public void add(char ch) {
		k+=1;
		b=ArrayUtil.grow(b,k+1);
		b[k]=ch;
    }
	


	//reove characters from word
	public void remove(int removeFrom){
		String s = new String(b);
		s=s.substring(0,removeFrom);
		b=s.toCharArray();
		k=(removeFrom-1);
		//System.out.println(s+" "+k);
	}

	//remove string from end
	public void remove(String pre){
		int l=pre.length();
		String s = new String(b);
		s=s.substring(0,k+1-l);
		b=s.toCharArray();
		k=k-l;
	}

	public void removeF(String pre){
		int l=pre.length();
		String s = new String(b);
		s=s.substring(l);
		b=s.toCharArray();
		k=k-l;
	}


	private final boolean ends(String s) {
		int l = s.length();
		int o = k - l + 1;
		if (o < 0) return false;
		for (int i = 0; i < l; i++) if (b[o + i] != s.charAt(i)) return false;
		//j = k - l;
		return true;
	}

	private final boolean starts(String s) {
		int l = s.length();
		int o = 0;
		if (o < 0) return false;
		for (int i = 0; i < l; i++) if (b[o + i] != s.charAt(i)) return false;

		//j = k - l;
		return true;
	}

	private final void step0() {
		for(String prefix:prefix_list){
			if(starts(prefix)){
				String s = new String(b);
				//System.out.println(prefix +" "+s);
				removeF(prefix);
			}

		}
	}
	private final void step1() {
		for(String sufffix:suffix_list){

			if(ends(sufffix)){
				String s = new String(b);
				//System.out.println("* "+s+" "+sufffix);
				remove(sufffix);
			}

		}
	}
	private final void step2() {
		if ((b[k] == 'ට') && !((Arrays.asList(back).contains(Character.toString(b[k-1]))) ||(Arrays.asList(front).contains(Character.toString(b[k-1])))) ){
			remove("ට");
			add('්');
		}
		else if(b[k]=='ි'){
			remove("ි");
			add('්');
		}
		else if(b[k]=='ෝ'){
			remove(k-1);
		}
		else if(b[k]=='්' && b[k-1]=='න'){
			if (b[k-2]=='ි'){
				remove(k-2);
				//System.out.println(b[k]);
				add('්');
			}
			else if (b[k-2]=='ී'){
				remove(k-2);
				add('ි');
			}
		}
		else if (b[k-2]=='ෙ' && b[k-1]=='ක' && b[k]== '්')   //'එක්'
		{
			if(b[k-3]=='ය' || b[k-3]=='ව') { //සිංහයෙක් යහළුවෙක්
				remove( k - 3);
				k = -2;
			}
			//ඇතෙක්
			else {
				//System.out.println(k);
				remove(k-2);
				//System.out.println(k);
				add('්');
			}
		}

		else if (b[k-2]=='ෙ' && b[k-1]=='ක' && b[k]== 'ු')
		{
			remove(k-2);
			add('්');
		}
		else if(b[k]=='ු'){
			if (b[k-1]=='ව'){
				remove(k-1);
			}
			else if(b[k-2]=='්'){
				remove(k-1);
			}
			else {
				remove(k);
			}
		}


	}
	private final void step3() {
		  //System.out.println(b[k]);
		  //System.out.println(b[k-1]);
	        if (b[k] == 'ා') {
	        	if (b[k-1]=='ය' || b[k-1] == 'ව'){
					remove(k-1);
					k=-2;
				}
	        	/*else if(b[k-1]=='ත'){
	        		//Do Nothhing
				}*/
				else
					b[k]='්';
	        }
	        else if (b[k] == '්' && b[k-1]=='ක' && !(Arrays.asList(back).contains(Character.toString(b[k-1]))))
	        {
			  	if(b[k-2]=='ව'){
			  		remove(k-2);
				}
			  	else if(b[k-2]=='ය'){
			  		remove(k-2);
				}
			  	else{
			  		remove(k-1);
			  		add('්');
				}
		  	}
			else if (b[k]=='ක' && !(Arrays.asList(back).contains(Character.toString(b[k-1])))){
				remove(k-1);
			}
			else if (!(Arrays.asList(back).contains(Character.toString(b[k])))){
				if(b[k]=='ව' || b[k]=='ය' ){
					remove(k);
				}
				else{
					add('්');
				}
			}
			else if (b[k]=='්' && b[k-1]=='න' && !(Arrays.asList(back).contains(Character.toString(b[k-2])))){
				remove(k-2);
			}

			else if((b[k]=='්' && b[k-1]=='න' && b[k-2]=='ු') || (b[k]=='්' && b[k-1]=='න' && b[k-2]=='ූ') ){
				if (b[k-3]=='ව' && b[k-2]=='ු'){
					remove(k-3);
					add('v');
				}
				else if(b[k-2]=='ූ'){
					remove(k-2);
					add('ු');
				}
				else {
					remove(k-2);
				}
			}




	}

	public static String readFile (Scanner input)
	{
		return input.useDelimiter("\\Z").next();
	}
	public String stemmDOcuments(String args) throws IOException {




        SinhalaStemmer s = new SinhalaStemmer();
		ArrayList<String> list=new ArrayList<String>();

		String[] words=args.split("\\s");

		for(String w:words){  
			list.add(w); 
			}  
		list=s.stemming(list);
		StringBuilder b = new StringBuilder();
		for (int j = 0; j < list.size(); j++) {
			b.append(" ");
			b.append(list.get(j));
		}
		String result = b.toString();
		return result;

	}
}
