package test;

public class Dog {
//	   public int divide(int dividend, int divisor) {
//		    long result = divideLong(dividend, divisor);
//		    return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
//		}
//
//		// It's easy to handle edge cases when
//		// operate with long numbers rather than int
//		public long divideLong(long dividend, long divisor) {
//
//		    // Remember the sign
//		    boolean negative = dividend < 0 != divisor < 0;
//
//		    // Make dividend and divisor unsign
//		    if (dividend < 0) dividend = -dividend;
//		    if (divisor < 0) divisor = -divisor;
//
//		    // Return if nothing to divide
//		    if (dividend < divisor) return 0;
//
//		    // Sum divisor 2, 4, 8, 16, 32 .... times
//		    long sum = divisor;
//		    long divide = 1;
//		    while ((sum+sum) <= dividend) {
//		        sum += sum;
//		        divide += divide;
//		    }
//
//		    // Make a recursive call for (devided-sum) and add it to the result
//		    return negative ? -(divide + divideLong((dividend-sum), divisor)) :
//		        (divide + divideLong((dividend-sum), divisor));
//		}
	public static int divide(int dividend, int divisor) {
	    if(divisor == 0){
	        return Integer.MAX_VALUE;
	    }
	    if(dividend == 0){
	        return 0;
	    }
	    boolean signal = ((dividend < 0 && divisor < 0) ||(dividend > 0 && divisor > 0))? true:false;
	    long dividendLong = dividend;
	    long divisorLong = divisor;
	    long res =divideHelper(Math.abs(dividendLong),Math.abs(divisorLong));
	    System.out.println(Math.abs(dividendLong));
	    System.out.println(Math.abs(divisorLong));
	    System.out.println(signal);
	    System.out.println("res = "+res);
	    res = signal == true?res:-res;
	    if(res > Integer.MAX_VALUE){
	    	return Integer.MAX_VALUE;
	    }
	    return (int)res;
	}
	    public static long divideHelper(long dividend, long divisor){
	        if(dividend < divisor){
	            return 0;
	        }
	        long sum = divisor;
	        long pow = 1;
	        while(sum + sum <= dividend){
	            pow += pow;
	            System.out.println("pow = "+pow);
	            sum += sum;
	        }
	        long remain = (long)(dividend - sum);
	        System.out.println("remain = "+remain);
	        System.out.println("return = "+remain);
	        return pow + divideHelper(remain,divisor);
	    }
	    public static void main(String args[]){
	    	int dividend = -2147483648;
	    	int divisor = -1;
	    	int result = divide(dividend,divisor);
	    	System.out.println(result);
	    }

}
