package dynamicProgram;

public class CoinsInALineII {
//	 public boolean firstWillWin(int[] values) {
//	        // write your code here
//	        if(values == null || values.length < 3){
//	            return true;
//	        }
//	        int total = 0;
//	        int length = values.length;
//	        int[][] res = new int[length][length];
//	        for(int i=length-1;i>=0;i--){
//	            total += values[i];
//	            for(int j=i;j<length;j++){
//	                if(i == j){
//	                    res[i][j] = values[i];
//	                }
//	                else if(j == i+1 || j == i+2){
//	                    res[i][j] = values[i] + values[i+1];
//	                }
//	                else{
//	                    int first = values[i] + Math.min(res[i+2][j],res[i+3][j]);
//	                    int second = values[i] + values[i+1] + Math.min(res[i+3][j],
//	                    (i+4 > j? 0 : res[i+4][j]));
//	                    res[i][j] = Math.max(first,second);
//	                }
//	            }
//	        }
//	        return res[0][length-1]>=(total-res[0][length-1])?true:false;
//	    }
	public static boolean firstWillWin(int[] values) {
        // write your code here
		if(values == null || values.length <= 2){
	           return true;
	       }
	       if(values.length == 3){
	           return values[0]+values[1] > values[2];
	       }
	       int length = values.length;
	       int[] res = new int[length+1];
	       res[length] = 0;
	       res[length-1] = values[length-1];
	       res[length-2] = values[length-1]+values[length-2];
	       res[length-3] = values[length-3]+values[length-2];
	       int total = values[length-1]+values[length-2]+values[length-3];
	       for(int i=length-4;i>=0;i--){
	           int oneStep = values[i] + Math.min(res[i+2],res[i+3]);
	           int twoStep = values[i]+values[i+1] + Math.min(res[i+3],res[i+4]);
	           res[i] = Math.max(oneStep,twoStep);
	           total += values[i];
	       }
	       return res[0] > total - res[0];
        }
	public static void main(String args[]){
		int[] A = {1,2,3,4,5,6,7};
		boolean res = firstWillWin(A);
	}
}
