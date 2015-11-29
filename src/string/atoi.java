package string;

public class atoi {
	    
//	    public static int atoi(String str) {
//	        // write your code here
//	        if(str == null || str.length() == 0){
//	            return 0;
//	        }
//	        long res = 0;
//	        boolean sig = true;
//	        str = str.trim();
//	        if(str.charAt(0) == '-'){
//	            sig = false;
//	            str = str.substring(1);
//	        }
//	        else if(str.charAt(0) == '+'){
//	            str = str.substring(1);
//	        }
//	        int length = str.length();
//	        
//	        int offset = 1 - '1';
//	        for(int i=0;i<11 && i<length;i++){
//	            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
//	                break;
//	            }
//	            res = res * 10 + str.charAt(i) + offset;
//	        }
//	        if(sig == false){
//	            res = res *(-1);
//	        }
//	        if(res > Integer.MAX_VALUE){
//	            return Integer.MAX_VALUE;
//	        }
//	        if(res < Integer.MIN_VALUE){
//	            return Integer.MIN_VALUE;
//	        }
//	        return (int)res;
//	    }
	 public static int myAtoi(String str) {
	        if(str == null || str.length() == 0){
	            return 0;
	        }
	        str = str.trim();
	        int runner = 0;
	        boolean sign = true;  // positive
	        if(str.charAt(0) == '-'){
	            sign = false;
	            runner++;
	        }
	        else if(str.charAt(0) == '+'){
	            runner++;
	        }
	        long res = 0;
	        System.out.println("runner = "+runner );
	        System.out.println("length = "+str.length() );
	        while(runner < str.length() && runner <= 11){
	        	System.out.println("cur"+ str.charAt(runner));
	            if(Character.isDigit(str.charAt(runner))){
	                res = res * 10 + (str.charAt(runner)-'0');
	                System.out.println("res = "+res );
	                runner++;
	            }
	            else{
	                break;
	            }
	        }
	        if(sign == false){
	            res = -1 * res;
	        }
	        if(res > Integer.MAX_VALUE){
	            return Integer.MAX_VALUE;
	        }
	        if(res < Integer.MIN_VALUE){
	            return Integer.MIN_VALUE;
	        }
	        return (int)res;
	    }
	public static void main(String args[]){
		//String s = "1234567890123456789012345678901234567890";
		String s = "  1 10";
		int res = myAtoi(s);
		System.out.println(res);
		StringBuilder sb = new StringBuilder();
		sb.c
	}
}
