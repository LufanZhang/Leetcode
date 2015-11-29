package math;
/*
 * Divide two integers without using multiplication, division and mod operator. 
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) { 
    	 boolean sig = ((dividend<0&&divisor<0)||(dividend>0&&divisor>0));
     	long a = Math.abs((long)dividend);
     	long b = Math.abs((long)divisor);
     	if(a==0||b>a||b==0)
     		return 0;
     	long result = 0;
     	while(a>=b){
     		long pow = 1;
     		long sum = b;
     		while(sum+sum<=a){
     			sum+=sum;
     			pow+=pow;
     			System.out.println("pow = "+pow);
     		}
     		a-=sum;
     		result+=pow;
     		System.out.println("result = "+result);
     	}
     	//System.out.println("result = "+result);
     	if(result > Integer.MAX_VALUE){
     	    return Integer.MAX_VALUE;
     	}
     	return sig? (int)result:(int)-result;
    }
    public static void main(String args[]){
    	int dividend = -2147483648;
    	int divisor = -1;
    	System.out.println("res = "+divide(dividend,divisor));
    }
}
