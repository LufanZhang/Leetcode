package string;
/*
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
 */
public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
	        int length = s.length();
	        if(s==null||length<=1)
	        return true;
	        int i = 0;
	        int j = length-1;
	        while(i<j){
	            if(isValid(s.charAt(i))&&isValid(s.charAt(j))){
	                if(s.charAt(i)==s.charAt(j)||Math.abs(s.charAt(i)-s.charAt(j))==('a'-'A')){
	                    i++;
	                    j--;
	                }
	                else
	                return false;
	            }
	            else if(isNumber(s.charAt(i))&&isNumber(s.charAt(j))){
	                if(s.charAt(i)==s.charAt(j)){
	                    i++;
	                    j--;
	                }
	                
	                else
	                return false;
	            }
	            else if(!isValid(s.charAt(i))&&!isValid(s.charAt(j))&&!isNumber(s.charAt(i))&&!isNumber(s.charAt(j))){
	                i++;
	                j--;
	            }
	            else if((isValid(s.charAt(i))||isNumber(s.charAt(i)))&&(!isValid(s.charAt(j))&&!isNumber(s.charAt(j))))
	            j--;
	            else if((isValid(s.charAt(j))||isNumber(s.charAt(j)))&&(!isValid(s.charAt(i))&&!isNumber(s.charAt(i))))
	            i++;
	            else
	            return false;
	        
	        }
	        return true;
	    }
	    public static boolean isValid(char a){
	        if((a>='a'&&a<='z')||(a>='A'&&a<='Z'))
	        return true;
	        else
	        return false;
	    }
	    public static boolean isNumber(char a){
	        if(a>='0'&&a<='9')
	        return true;
	        else 
	        return false;
	    }
}
