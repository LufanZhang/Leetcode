package math;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	 public boolean isPalindrome(int x) {
	        if(x<0)
	        return false;
	        int reverse = reverse(x);
	        return x==reverse;
	    }
	    public int reverse(int x){
	        if(x<10)
	        return x;
	        int res = 0;
	        while(x>0){
	            res = res*10+x%10;
	            x/=10;
	        }
	        return res;
	    }
}
