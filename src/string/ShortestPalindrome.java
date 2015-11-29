package string;

import java.util.HashMap;

public class ShortestPalindrome {
//	 public String shortestPalindrome(String s) {
//	        if (s == null || s.length() < 2) return s;
//	        int len = s.length();
//	        boolean[] invalid = new boolean[len];
//	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//	        int oddCount = 0;
//	        boolean oddLength = true;
//	        for (int i=0;i<len;i++) {
//	            int c = (int)(s.charAt(i));
//	            Integer count = map.get(c);
//	            if (count == null) count = 1;
//	            else count++;
//	            map.put(c, count);
//	            if (count%2 == 0) oddCount--;
//	            else oddCount++;
//	            if (oddLength && oddCount>1) invalid[i] = true;
//	            if (!oddLength && oddCount>0) invalid[i] = true;
//	            oddLength = !oddLength ;
//	        }
//	        int i=len-1;
//	        for (;i>=0;i--) {
//	            if (invalid[i]) continue;
//	            int a=0, b=i;
//	            while (a<b) {
//	                if (s.charAt(a) != s.charAt(b)) break;
//	                a++;
//	                b--;
//	            }
//	            if (a>=b) break;
//	        }
//	        StringBuffer sb = new StringBuffer();
//	        for (int j=len-1;j>=i+1;j--) sb.append(s.charAt(j));
//	        return sb.toString()+s;
//	    }
//	 public static String shortestPalindrome(String s) {
//	        if(s == null || s.length() == 0){
//	            return s;
//	        }
//	        int length = s.length();
//	        String res = establish(s,1);
//	        System.out.println("res = "+res);
//	        boolean flag = false;
//	        int mid = length / 2;
//	        if(length % 2 == 1){
//	            flag = true;
//	        }
//	        for(int i=mid;i>0;i--){
//	            if(flag){
//	                if(isPalindrome(s.substring(0,2 * i + 1))){
//	                    return establish(s,2 * i + 1);
//	                }
//	                flag = false;
//	            }
//	            else{
//	                if(isPalindrome(s.substring(0,2 * i))){
//	                    return establish(s,2 * i);
//	                }
//	                flag = true;
//	            }
//	        }
//	        return res;
//	    }
//	    public static String establish(String s,int pos){
//	        if(s == null || s.length() == 0){
//	            return null;
//	        }
//	        int length = s.length();
//	        if(pos >= length){
//	            return s;
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        for(int i=length-1;i>=pos;i--){
//	            sb.append(s.charAt(i));
//	        }
//	        System.out.println(sb.toString());
//	        return sb.toString() + s;
//	    }
//	    public static  boolean isPalindrome(String s){
//	        if(s == null || s.length() == 0){
//	            return true;
//	        }
//	        int start = 0;
//	        int end = s.length() - 1;
//	        while(start < end){
//	            if(s.charAt(start) != s.charAt(end)){
//	                return false;
//	            }
//	            start++;
//	            end--;
//	        }
//	        return true;
//	    }
	 public static String shortestPalindrome(String s) {  
         if(s.length()<=1) return s;
         int length = s.length();
        String new_s = s+"#"+new StringBuilder(s).reverse().toString();
        int[] position = new int[new_s.length()];

        for(int i=length;i<position.length;i++)
        {
            int pre_pos = position[i-1];
            while(pre_pos>0 && new_s.charAt(pre_pos)!=new_s.charAt(i))
                pre_pos = position[pre_pos-1];
            position[i] = pre_pos+((new_s.charAt(pre_pos)==new_s.charAt(i))?1:0);
            System.out.print(position[i]+" ");
        }
        System.out.println("");
        return new StringBuilder(s.substring(position[position.length-1])).reverse().toString()+s;
    } 
	    public static void main(String args[]){
	    	String s = "aacecaaa";
	    	String res = shortestPalindrome(s);
	    	System.out.println("Res="+res);
	    	
	    }
}
