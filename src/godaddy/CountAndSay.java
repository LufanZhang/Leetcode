package godaddy;

public class CountAndSay {
	public static String count(String s){
		StringBuilder sb = new StringBuilder();
		if(s == null || s.length() == 0){
			return sb.toString();
		}
		int length = s.length();
		char pre = s.charAt(0);
		int count = 1;
		for(int i=1;i<length;i++){
			char cur = s.charAt(i);
			if(cur == pre){
				count++;
			}
			else{
				sb.append(pre);
				if(count > 1){
					sb.append(count);
				}
				pre = cur;
				count = 1;
			}
		}
		sb.append(pre);
		if(count > 1){
			sb.append(count);
		}
		return sb.toString();
	}
	public static void main(String args[]){
		String s = "aaaaaabbsscww";
		String res = count(s);
		System.out.println(res);
	}
}
