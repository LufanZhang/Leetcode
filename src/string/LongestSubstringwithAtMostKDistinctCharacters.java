package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        int first = 0;
        int second = 0;
        int length = s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int count = 0;
        int res = 0;
        System.out.println("first = "+first);
        System.out.println("second = "+second);
        while(first < length){
            char cur = s.charAt(first);
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }
            else{
                map.put(cur,1);
                count++;
                if(count >  k){
                    if(first - second > res){
                        res = first - second;
                    }
                    while(second <= first){
                        char temp = s.charAt(second);
                        if(map.get(temp) == 1){
                            map.remove(temp);
                            count--;
                            second++;
                            break;
                        }
                        else{
                            map.put(temp,map.get(temp)-1);
                        }
                        second++;
                    }
                }
            }
            first++;
        }
//        System.out.println("first = "+first);
//        System.out.println("second = "+second);
        if(first - second > res){
            res = first - second;
        }
        return res;
    }
	public static void main(String[] args){
		String s = "w";
		int k = 1;
		int res = lengthOfLongestSubstringKDistinct(s,k);
		System.out.println(res);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			Integer key = (Integer)entry.getKey();
			Integer val = (Integer)entry.getValue();
			if(val == 1){
				iter.remove();
			}
		}
	}
}
