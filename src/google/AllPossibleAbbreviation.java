package google;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleAbbreviation {
	public static List<String> abbreviation(String s){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0){
			return res;
		}
		StringBuilder sb = new StringBuilder();
		dfsHelper(res,sb,s,0);
		List<String> r = new ArrayList<String>();
		for(int i=0;i<res.size();i++){
			String curString = change(res.get(i));
			r.add(curString);
		}
		return r;
	}
	public static String change(String s){
		if(s == null || s.length() == 0){
			return s;
		}
		int length = s.length();
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while(index < length){
			char cur = s.charAt(index);
			if(cur == '*'){
				int count = 0;
				while(index < length && s.charAt(index) == '*'){
					count++;
					index++;
				}
				sb.append(count);
			}
			else{
				sb.append(cur);
				index++;
			}
		}
		return sb.toString();
	}
	public static void dfsHelper(List<String> res,StringBuilder sb,String s,int start){
		if(start == s.length()){
			res.add(sb.toString());
			return;
		}
		sb.append(s.charAt(start));
		dfsHelper(res,sb,s,start+1);
		sb.deleteCharAt(sb.length()-1);
		
		sb.append('*');
		dfsHelper(res,sb,s,start+1);
		sb.deleteCharAt(sb.length()-1);
	}
	public static void main(String args[]){
		String s = "school";
		List<String> res = abbreviation(s);
		System.out.println(res);
	}
}
