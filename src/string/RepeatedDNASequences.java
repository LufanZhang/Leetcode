package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
	 public static List<String> findRepeatedDnaSequences(String s) {
         //each of letter can be represented as 2 bits (A-00,C-01,G-10,T-11),so the 10 letters can be represented as 20 bit
        //e.g. "AAAAACCCCC"-00 00 00 00 00 01 01 01 01 01
        //10个letter（是一个20位的二进制）可以表示成一个Integer
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10){
            return res;
        }
        int length = s.length();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Character,Integer> dict = new  HashMap<Character,Integer>();
        dict.put('A',0);
        dict.put('C',1);
        dict.put('G',2);
        dict.put('T',3);
        int window = 0;
        for(int i=0;i<20;i++){
            window = (window << 1) + 1;
        }
        System.out.println("window="+window);
        int num = 0;
        for(int i=0;i<10;i++){
        	int cur = dict.get(s.charAt(i));
            num = (num << 2) + cur;
        }
        map.put(num,9);
        for(int i=10;i<length;i++){
            int cur = dict.get(s.charAt(i));
            num = (num << 2) + cur;
            num = num & window;
            System.out.println("i="+i+"  num="+num);
            if(map.containsKey(num)){
                if(!set.contains(num)){
                    int pos = map.get(num);
                    res.add(s.substring(pos-9,pos+1));
                    set.add(num);
                }
            }
            else{
                map.put(num,i);
            }
        }
        return res;
    }
	 public static void main(String args[]){
		 String s = "AAAAAAAAAAA";
		 List<String> res = findRepeatedDnaSequences(s);
		 System.out.println("res = "+res);
	 }
}
