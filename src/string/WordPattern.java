package string;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
        if((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)){
            return true;
        }
        String[] strArray = str.split(" ");
        if(pattern == null || str == null || pattern.length() != strArray.length){
            return false;
        }
        int length = pattern.length();
        HashMap<Character,String> map = new HashMap<Character,String>();
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<length;i++){
            char curChar = pattern.charAt(i);
            String curString = strArray[i];
            if(map.containsKey(curChar)){
                if(!curString.equals(map.get(curChar))){
                    return false;
                }
            }
            else if(set.contains(curString)){
                return false;
            }
            else{
                map.put(curChar,curString);
            }
            set.add(curString);
        }
        return true;
    }
	 public static void main(String args[]){
		 String pattern = "abba";
		 String str = "dog dog dog dog";
		 boolean res = wordPattern(pattern,str);
	 }
}
