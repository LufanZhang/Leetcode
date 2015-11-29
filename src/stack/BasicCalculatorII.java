package stack;

public class BasicCalculatorII {
	public static int calculate(String s) {
	     if(s == null || s.length() == 0){
	         return 0;
	     }
	     Stack<Character> stack = new Stack<Character>();
	     
   }
   public int basic(String s){
       if(s == null || s.length == 0){
           return 0;
       }
       int length = s.length();
       int pre = 0;
       int index = 0;
       while(index < length){
           char cur = s.charAt(index);
           if(!Character.isDigit(s.charAt(index))){
               break;
           }
           pre = pre * 10 + (cur - '0');
           index++;
       }
       if(index == length){
           return pre;
       }
       if(s.charAt(index) == '-'){
           return pre - basic(s.substring(index+1));
       }
       else{
           return pre + basic(s.substring(index+1));
       }
   }
}
