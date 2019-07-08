package Tokenization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;


public class SinhalaTokenizer {

    private final String letters[] = {"ඒ","බී","සී","ඩී","ඊ","එෆ්","ජී","එච්","අයි","ජේ","කේ","එල්","එම්","එන්","ඕ","පී","ආර්","එස්","ටී","යූ","වී","ඩබ්ලිව්","වයි"};
    private final String numbers[] = {"0","1","2","3","4","5","6","7","8","9"};
    private final String eng_letters[] = {"ඒ.","බී.","සී.","ඩී.","ඊ.","එෆ්.","ජී.","එච්.","අයි.","ජේ.","කේ.","එල්.","එම්.","එන්.","ඕ.","පී.","ආර්.","එස්.","ටී.","යූ.","වී.","ඩබ්ලිව්.","වයි."};

    private final String ignoringCharList[] = {",","{","}","[","]","!",";","\\?","\\?","+","@","#","$","%"};
    private String spliit_words(String str){
        str = name_ananlyzer(str);
        str = HandleAbrevations(str);
        if (str.contains(":"))
            str = HandleColon(str);
        if (str.contains("-"))
            str = Handlehypen(str);
        if (str.contains("/"))
            str = Handleslash(str);
        if(str.contains("(") || str.contains(")"))
            str = HandleBrackets(str);

        for(String ignoringChar : ignoringCharList) {
            if(str.contains(ignoringChar)) {
                str = str.replaceAll(ignoringChar, " ");
            }
        }

        return str;
    }

    /* Check initials are available */
    private boolean is_available_in_english_letters(String letter){
        boolean availability = false;
        for (String eng_letter : eng_letters) {
            if (eng_letter.equals(letter)) {
                availability = true;
                break;
            }
        }
        return availability;
    }

    /* Tokenize names with initials accurately */
    private String name_ananlyzer(String str){
        String[] list = str.split(" ");
        StringBuilder temp_str= new StringBuilder();
        for(int i=0;i<list.length;i++){

            if (is_available_in_english_letters(list[i])){
                temp_str.append(list[i]);
                list[i]=",";
            } else {
                if (!temp_str.toString().equals("")){
                    list[i]= temp_str+list[i] ;
                    temp_str = new StringBuilder();
                }
            }
            //System.out.println(temp_str);
        }
        StringBuilder b = new StringBuilder();
        for (String s : list) {
            b.append(" ");
            b.append(s);
        }
        return b.toString();
    }

    private char[] removeElt( char [] arr, int remIndex )
    {
        String s0 = new String(arr);
        StringBuilder sb = new StringBuilder(s0);
        String s= new String(sb.deleteCharAt(remIndex));
        return s.toCharArray();
    }

    private String HandleAbrevations(String str) {
        String[] list = str.split(" ");
        outerloop:
        for (int i = 0; i < list.length; i++) {
            for(String letter : letters) {
                //check for initials
                if (list[i].contains(letter)) {
                    continue outerloop;
                }
            }
            char[] a = list[i].toCharArray();
            int count =0;
            for (char c : a) {
                //count number of dots
                if (c == '.') {
                    count++;
                }
            }

            if (count==1){
                for(int j=0; j<a.length; j++){
                    if(a[j]== '.'){
                      //  a=removeElt(a,j);
                    }
                }
            }
            else if(count<2){
                continue ;
            }
            else{
                for(int j=0; j<a.length; j++){
                    if(a[j]== '.'){
                        a=removeElt(a,j);
                    }
                }
            }
            String str1 = new String(a);
            list[i]= str1;
        }
        StringBuilder b = new StringBuilder();
        for (String s : list) {
            b.append(" ");
            b.append(s);
        }
        return b.toString();
    }


    private char[] remove(char[] ch){
        char[] ch0 = new char[ch.length-1];
        arraycopy(ch, 0, ch0, 0, ch0.length);
        //ch=null;
        ch=ch0;
        //String s = new String(ch);
        return ch;
    }


    private String HandleColon(String str){
        String[] list = str.split(" ");
        for (int i = 0; i < list.length; i++) {
            char[] w = list[i].toCharArray();
            int count=0;
            if(list[i].contains(":")){
                for (char c : w) {
                    if (c == ':') {
                        count++;
                    }
                }
                if (count == 1 && w[w.length - 1] == ':') {
                    w=remove(w);
                    String s = new String(w);
                    list[i]= s;

                }
            }
        }
        StringBuilder b = new StringBuilder();
        for (int i=0;i<list.length;i++){
            b.append(" ");
            b.append(list[i]);
        }
        return b.toString();
    }

    private String Handlehypen(String str){
        String[] list = str.split(" ");
        outerloop:
        for (int i = 0; i < list.length; i++) {
            if (list[i].contains("-")) {
                for (String num : numbers) {
                    if (list[i].contains(num) && list[i].contains("-")) {
                        continue outerloop;

                    } else {
                        String[] tokens = list[i].split("-");
                        StringBuilder b = new StringBuilder();
                        for (int j = 0; j < tokens.length; j++) {
                            //System.out.println("kkkkkkkkkk"+tokens[j]);
                            //spacelesslist.addLast(tokens[i]);
                            //  System.out.println("11 " + tokens[i]);
                            String str1=b.append(tokens[j]+" ").toString();
                            list[i]=str1;
                        }
                        break outerloop;
                    }
                }
            }

        }
        StringBuilder b = new StringBuilder();
        for (int j = 0; j < list.length; j++) {
            b.append(" ");
            b.append(list[j]);
        }
        return b.toString();
    }

    public String Handleslash(String str){
        String[] list = str.split(" ");
        outerloop:
        for (int i = 0; i < list.length; i++) {
            if (list[i].contains("/")) {
                for (String num : numbers) {
                    if (list[i].contains(num) && list[i].contains("/")) {
                        continue outerloop;

                    } else {
                        String[] tokens = list[i].split("/");
                        StringBuilder b = new StringBuilder();
                        for (int j = 0; j < tokens.length; j++) {
                            //System.out.println("kkkkkkkkkk"+tokens[j]);
                            //spacelesslist.addLast(tokens[i]);
                            //  System.out.println("11 " + tokens[i]);
                            String str1=b.append(tokens[j]+" ").toString();
                            list[i]=str1;


                        }
                        break outerloop;
                    }
                }
            }

        }
        StringBuilder b = new StringBuilder();
        for (int j = 0; j < list.length; j++) {
            b.append(" ");
            b.append(list[j]);
        }
        return b.toString();
    }

    public String HandleBrackets(String str){
        String[] list = str.split(" ");
        outerloop:
        for (int i = 0; i < list.length; i++) {
           // out.println(i+" "+list[i]);
            char a[] = list[i].toCharArray();
            if (list[i].contains("(") || list[i].contains(")")) {
                int a0 = list[i].indexOf('(');
                int a1 = list[i].indexOf(')');
               // System.out.println("*" + a[0] + " " + a[a.length - 1] + " "+ (a.length-1) );
                if (a[0] == '(' ) {
                    a = removeElt(a, 0);
                }
                if ((a.length!=0) && (a[a.length - 1] == ')')){
                    a = removeElt(a, a.length - 1);
                }
                else if ( 1 < (a1 - a0) && (a1 - a0)< 4) {
                    //out.println(a1+" "+a0+" "+list[i]);
                    continue;
                }
                String s = new String(a);
                list[i]=s;
            }
        }
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < list.length; j++) {
                b.append(" ");
                b.append(list[j]);
            }
        return b.toString();
    }
    public String tokenize (String args) {
        SinhalaTokenizer st = new SinhalaTokenizer();
        String text = "ක්‍රි:ව: 1988 දී කේ. ඒ. පෙරේරා මහතා විසින් ආරම්භ කරන ලද මෙම විදුහල අංක: 100/34A දරණ ලිපිනයේ පිහිටා ඇත. එම ස්ථානයේදී පසුගිය සිකුරාදා එනම් 28/07/2019 වන දින පෙ.ව.7.10ට CAE-123 අංක දරන මොටර් රථයෙන් පෑමිනි පුද්ගලයෙකු එම විදුහලේ සිසුවෙකුට ප්‍රහාරයක් සිදු කර ඇත. ඒ.ආර්.බ(ර්)ලින් ගුණසිංහ මහතා (ප්‍රහාරයට ලක්වූ සිසුවාගේ පියා), මෙම සිද්ධිය සම්බන්දයෙන් පෙමිනිල්ලක් ළමා/කාන්තා කාර්යාංශයට පැමිනිල්ලක් ගොනුකර ඇත. ";
       // String text="aa ( aa ) ss";
        String result =  st.spliit_words(args);
        return result;

    }
    }

