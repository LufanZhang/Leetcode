package string;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class LetterCombinationsofaPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        int length = digits.length();
        if(digits==null)
        return result;
        ArrayList<Character> list = new ArrayList<Character>();
        HashMap<Character,String> map = new HashMap<Character,String>();
        map.put('0'," ");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterHelper(digits,result,list,map,0);
        return result;
    }
    public void letterHelper(String digits,ArrayList<String> result,ArrayList<Character> list,HashMap<Character,String> map,int start){
        if(start==digits.length()){
            String res = "";
            for(int i=0;i<list.size();i++){
                res+=list.get(i);
            }
            result.add(res);
            return;
        }
        String pot = map.get(digits.charAt(start));
        for(int i=0;i<pot.length();i++){
            list.add(pot.charAt(i));
            letterHelper(digits,result,list,map,start+1);
            list.remove(list.size()-1);
        }
    }
}
