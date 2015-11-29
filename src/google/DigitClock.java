package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//给一个n长度，建造旋转180度还是原来的字符串
/*
 * 1-1   0-0   8-8
 * 2-5 5-2 6-9 9-6
 */
public class DigitClock {
	public static List<String> permutation(int n){
		List<String> res = new ArrayList<String>();
		if(n <= 0){
			return res;
		}
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		HashSet<Character> set = new HashSet<Character>();
		map.put('2','5');
		map.put('5','2');
		map.put('6','9');
		map.put('9','6');
		set.add('1');
		set.add('0');
		set.add('8');
		boolean isEven = false;
		if((n & 1) == 0){
			isEven = true;
		}
		int end = n / 2;
		StringBuilder sb = new StringBuilder();
		dfsHelper(res,sb,end,1,isEven,map,set);
		return res;
	}
	public static void dfsHelper(List<String> res,StringBuilder sb,int end,int cur, boolean isEven,HashMap<Character,Character> map,HashSet<Character> set){
		if(cur > end){
			StringBuilder post = new StringBuilder();
			int length = sb.length();
			for(int i=0;i<length;i++){
				char curChar = sb.charAt(i);
				if(map.containsKey(curChar)){
					curChar = map.get(curChar);
				}
				post.insert(0,curChar);
			}
			if(!isEven){
				for(Character c:set){
					String s = sb.toString() + String.valueOf(c) + post.toString();
					res.add(s);
				}
			}
			else{
				String s = sb.toString() + post.toString();
				res.add(s);
			}
			return;
		}
		for(Character charMap:map.keySet()){
			sb.append(charMap);
			dfsHelper(res,sb,end,cur+1,isEven,map,set);
			sb.deleteCharAt(sb.length()-1);
		}
		for(Character charSet:set){
			sb.append(charSet);
			dfsHelper(res,sb,end,cur+1,isEven,map,set);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void main(String args[]){
		int n = 3;
		List<String> res = permutation(n);
		System.out.println(res);
	}
}
