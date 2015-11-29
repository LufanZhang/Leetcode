package string;
/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String pre = strs[0];
        int length = strs.length;
        int tempLength = pre.length();
        for(int i=0;i<length;i++){
            if(strs[i].length() < tempLength){
                tempLength = strs[i].length();
                pre = strs[i];
            }
        }
        System.out.println("pre = "+pre);
        for(int i=0;i<length;i++){
            String cur = strs[i];
            System.out.println("cur = "+cur);
            //start comparing
            for(int j=0;j<pre.length();j++){
                if(pre.charAt(j) != cur.charAt(j)){
                    pre = pre.substring(0,j);
                    break;
                }
            }
        }
        return pre;
    }
	public static void main(String args[]){
		String[] strs = {"ca","a"};
		String res = longestCommonPrefix(strs);
		System.out.println("res = "+res);
	}
//	 public String longestCommonPrefix(String[] strs) {
//	        if(strs == null || strs.length == 0){
//	            return "";
//	        }
//	        if(strs.length == 1){
//	            return strs[0];
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        int length = strs[0].length();
//	        for(int i=0;i<length;i++){
//	            char cur = strs[0].charAt(i);
//	            for(int j=1;j<strs.length;j++){
//	                if(strs[j].length()-1 < i || cur != strs[j].charAt(i)){
//	                    return sb.toString();
//	                }
//	            }
//	            sb.append(cur);
//	        }
//	        return sb.toString();
//	    }
//	  public String longestCommonPrefix(String[] strs) {
//	        int length = strs.length;
//	        if(strs==null||length==0)
//	        return "";
//	        if(length==1)
//	        return strs[0];
//	        String model = strs[0];
//	        int max = model.length();
//	        for(int i=1;i<length;i++){
//	            if(strs[i].length()<max)
//	            max = strs[i].length();
//	            for(int j=0;j<max;j++){
//	                if(model.charAt(j)!=strs[i].charAt(j)){
//	                    max = j;
//	                    break;
//	                }
//	            }
//	        }
//	        
//	        return model.substring(0,max);
//	    }
}
