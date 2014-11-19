package math;

public class Powx_n {
	 public double pow(double x, int n) {
	      if(n<0)
	      return 1/power(x,-n);
	      else 
	      return power(x,n);
	    }
	    public double power(double x,int n){
	        if(n==0)
	        return 1.0;
	        if(n==1)
	        return x;
	        int k = n/2;
	        double v = power(x,k);
	        if(n%2==0)
	        return v*v;
	        else
	        return x*v*v;
	        
	    }
}
