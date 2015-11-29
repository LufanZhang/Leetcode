package math;

public class Powx_n {
	public static double myPow(double x, int n) {
	       if(n < 0){
	    	   long temp = -1 * (long)n;
	           return 1 / powHelper(x,temp);
	       }
	       return powHelper(x,n);
	    }
	    public static double powHelper(double x,long n){
	    	System.out.println("n = "+n);
	        if(n == 0){
	           return 1;
	       }
	        if(n == 1){
	            return x;
	        }
	        long k = n / 2;
	        double temp = powHelper(x,k);
	        if(n % 2 == 1){
	            return x * temp* temp;
	        }
	        else{
	            return temp * temp;
	        }
	    }
	    public static void main(String args[]){
	    	double x = 1.0000000;
	    	int n = -2147483648;
	    	//long n = -1 * (long)g;
	    	//System.out.println("sss = "+n);
	    	double res = myPow(x,n);
	    	System.out.println(res);
	    }
}
