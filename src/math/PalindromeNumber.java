package math;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        long res = 0;
        int temp = x;
        while(temp > 0){
            res = res * 10 + (temp % 10);
            temp = temp / 10;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return false;
        }
        return res == x;
    }
	 public static void main(String args[]){
		 int x = 1;
		 boolean res = isPalindrome(x);
		 System.out.println(res);
	 }
}
