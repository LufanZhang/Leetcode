package dynamicProgram;

public class NumSquare {
	 public static int numSquares(int n) {
	        if(n <= 1){
	            return 1;
	        }
	        int[] res = new int [n+1];
	        res[0] = 0;
	        res[1] = 1;
	        for(int i=2;i<=n;i++){
	            int min = Integer.MAX_VALUE;
	            for(int j=1;i/j>=j;j++){
	            	System.out.println("j="+j);
	                if(1+res[i-j*j] < min){
	                    min = 1 + res[i-j*j];
	                }
	            }
	            res[i] = min;
	        }
	        for(int i=0;i<=n;i++){
	        	System.out.print(res[i]+" ");
	        }
	        return res[n];
	    }
	 public int countOperations(int n) {
			if(n == 0){
				return 0;
			}
			else if((n & 1) == 1){
				return 1 + countOperations(n-1);
			}
			else{
				return 1 + countOperations(n>>1);
			}
		    }
	 public static void main(String args[]){
		 int n = 2;
		 int res = numSquares(n);
		 System.out.println("res="+res);
	 }
}
