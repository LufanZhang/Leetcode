package string;
/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
 */
public class CountandSay {
//	 public String countAndSay(int n) {
//	        String oldString = "1";
//	        String newString = "";
//	        if(n==0)
//	        return newString;
//	        if(n==1)
//	        return oldString;
//	        for(int i=2;i<=n;i++){
//	            int count = 1;
//	            char say = oldString.charAt(0);
//	            for(int j=1;j<oldString.length();j++){
//	                if(oldString.charAt(j)==say)
//	                count++;
//	                else{
//	                    newString+=String.valueOf(count)+say;
//	                    count = 1;
//	                    say = oldString.charAt(j);
//	                }
//	            }
//	            newString+=String.valueOf(count)+say;
//	            oldString = newString;
//	            newString = "";
//	        }
//	        return oldString;
//	    }
public static String countAndSay(int n) {
        
        return helper(n,"1");
    }
    public static String helper(int n,String s){
        if(n == 1){
            return s;
        }
        int length = s.length();
        char pre = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<length;i++){
            if(s.charAt(i) != pre){
                sb.append(count);
                sb.append(pre);
                pre = s.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
        }
        sb.append(count);
        sb.append(pre);
        System.out.println("SB == "+sb.toString());
        return helper(n-1,sb.toString());
    }
    public static void main(String[] args){
    	int n = 2;
    	System.out.println(countAndSay(n));
    }
}
