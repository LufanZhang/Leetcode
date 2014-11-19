package string;
/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class LongestCommonPrefix {
	  public String longestCommonPrefix(String[] strs) {
	        int length = strs.length;
	        if(strs==null||length==0)
	        return "";
	        if(length==1)
	        return strs[0];
	        String model = strs[0];
	        int max = model.length();
	        for(int i=1;i<length;i++){
	            if(strs[i].length()<max)
	            max = strs[i].length();
	            for(int j=0;j<max;j++){
	                if(model.charAt(j)!=strs[i].charAt(j)){
	                    max = j;
	                    break;
	                }
	            }
	        }
	        
	        return model.substring(0,max);
	    }
}
