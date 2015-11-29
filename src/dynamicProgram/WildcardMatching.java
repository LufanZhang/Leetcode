package dynamicProgram;

import java.util.Arrays;

public class WildcardMatching {
	 public static boolean isMatch(String s, String p) {
	        if((p == null || p.length() == 0) && (s == null || s.length() == 0)){
	            return true;
	        }
	        if(p == null || p.length() == 0){
	            return false;
	        }
	        int lengthP = p.length();
	        int lengthS = s.length();
	        int count = lengthP;
	        for(int i=0;i<lengthP;i++){
	            if(p.charAt(i) == '*'){
	                count--;
	            }
	        }
	        if(count > lengthS){
	            return false;
	        }
	        boolean[] res = new boolean[lengthS+1];
	        Arrays.fill(res,true);
	        for(int i=0;i<lengthP;i++){
	            boolean pre = true;
	            char cur = p.charAt(i);
	            for(int j=0;j<=lengthS;j++){
	                boolean temp = res[j];
	                if(j == 0){
	                    if(cur != '*'){
	                        res[j] = false;
	                    }
	                }
	                else{
	                    if(cur == s.charAt(j-1) || cur == '?'){
	                        res[j] = pre;
	                    }
	                    else if(cur == '*'){
	                        res[j] = res[j] || res[j-1];
	                    }
	                    else{
	                        res[j] = false;
	                    }
	                }
	                pre = temp;
	            }
	            for(int b=0;b<=lengthS;b++){
	            	System.out.print(res[b]+" ");
	            }
	            System.out.println("");
	        }
	        return res[lengthS];
	    }
	 public static void main(String args[]){
		 String s = "aa";
		 String p = "a";
		 boolean res = isMatch(s,p);
		 System.out.println("res="+res);
	 }
}
