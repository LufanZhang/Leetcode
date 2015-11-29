package math;

public class PowerofTwo {
	 public static boolean isPowerOfTwo(int n) {
	        int count = 0;
	        while(n > 0){
	            if((n & 1) == 1){
	                count++;
	            }
	            n = n >> 1;
	        }
	        return count == 1;
	    }
	 public static void main(String args[]){
		 int a = Integer.MIN_VALUE;
		 System.out.println(isPowerOfTwo(a));
	 }
}
