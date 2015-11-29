package dynamicProgram;

public class CoinsInALine {
	 public boolean firstWillWin(int n) {
	        // write your code here
	        if(n <= 0){
	            return false;
	        }
	        if(n == 1 || n == 2){
	            return true;
	        }
	        boolean[] res = new boolean[n+1];
	        res[0] = false;
	        res[1] = true;
	        for(int i=2;i<=n;i++){
	            res[i] = !(res[i-1] && res[i-2]);
	        }
	        return res[n];
	    }
}
