package math;

import java.util.HashMap;

/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

/*
 * from the first character to the last,just add the numbers which represented by the character to the result
note: like 4=IV 6=VI how to differentiate them or something like that
      we can find the rule that all the numbers represent by character is descender (add)
      when we find that some ascender happens, we should sustract the front number
      for example: IV = V-I
                   VI = V+I
 */
public class RomantoInteger {
	 public int romanToInt(String s) {
	        int length = s.length();
	        int sum = 0;
	        if(s==null||length==0)
	        return 0;
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        if(length==1)
	        	return map.get(s.charAt(0));
	        int i = 0;
	        int j = 1;
	        while(j<length){
	        	if(map.get(s.charAt(i))>=map.get(s.charAt(j))){
	        		sum+=map.get(s.charAt(i));
	        	}
	        	else
	        		sum-=map.get(s.charAt(i));
	        	i++;
	        	j++;
	        }
	        sum+=map.get(s.charAt(length-1));
	        return sum;
 }
}
