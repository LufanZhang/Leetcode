package google;
/*
 * can be solve by sort and hashmap and 26letter array
 */
public class FindExtraLetter {
	public char findLetter(String s,String p){
		if((s == null || s.length() == 0) || (p == null || p.length() == 0)){
			return '-';
		}
		int lengthS = s.length();
		int lengthP = p.length();
		if(lengthS != lengthP - 1){
			return '-';
		}
		int[] num = new int[26];
		for(int i=0;i<lengthS;i++){
			char cur = s.charAt(i);
			int pos = cur - 'a';
			num[pos] = num[pos]+1;
		}
		for(int i=0;i<lengthP;i++){
			char cur = s.charAt(i);
			int pos = cur - 'a';
			num[pos] = num[pos]-1;
			if(num[pos] < 0){
				return cur;
			}
		}
		return '-';
	}
}
