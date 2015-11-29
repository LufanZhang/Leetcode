package google;

import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
	      int res = 0;
	      if(s == null || s.length() == 0){
	          return res;
	      }
	      HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	      map.put('M',1000);
	      map.put('D',500);
	      map.put('C',100);
	      map.put('L',50);
	      map.put('X',10);
	      map.put('V',5);
	      map.put('I',1);
	      int length = s.length();
	      res += map.get(s.charAt(0));
	      int pre = res;
	      for(int i=1;i<length;i++){
	          int cur = map.get(s.charAt(i));
	          if(cur > pre){
	              res = res + cur - 2*pre;
	          }
	          else{
	              res += cur;
	          }
	          pre = cur;
	      }
	      return res;
	    }
}
