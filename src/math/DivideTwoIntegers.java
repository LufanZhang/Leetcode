package math;
/*
 * Divide two integers without using multiplication, division and mod operator. 
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) { 
     	boolean sig = ((dividend<0&&divisor<0)||(dividend>0&&divisor>0));
    	long a = Math.abs((long)dividend);
    	long b = Math.abs((long)divisor);
    	if(a==0||b>a||b==0)
    		return 0;
    	int result = 0;
    	while(a>=b){
    		int pow = 1;
    		long sum = b;
    		while(sum+sum<=a){
    			sum+=sum;
    			pow+=pow;
    		}
    		a-=sum;
    		result+=pow;
    	}
    	return sig? result:-result;
    }
}
