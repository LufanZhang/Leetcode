package wayfair;
//判断短的那个是不是长的那个的substring
public class StrStr {
	public boolean strStr(String s,String p){
		if(s == null || s.length() == 0){
			if(p == null || p.length() == 0){
				return true;
			}
			return false;
		}
		int lengthS = s.length();
		int lengthP = p.length();
		if(lengthS < lengthP){
			return false;
		}
		int start = 0;
		int end = lengthP;
		while(end <= lengthS){
			if(s.substring(start,end).equals(p)){
				return true;
			}
			start++;
			end++;
		}
		return false;
	}
}
