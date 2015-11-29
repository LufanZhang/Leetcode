package dynamicProgram;

public class KnapSack {
	 public static int backPack(int m, int[] A) {
	        // write your code here
	        if(m < 0 || A == null || A.length == 0){
	            return 0;
	        }
	        int[] res = new int[m+1];
	        int length = A.length;
	        for(int i=0;i<length;i++){
	            int cur = A[i];
	            for(int j=m;j>=cur;j--){
	                res[j] = Math.max(res[j],cur + res[j-cur]);
	            }
	        }
	        for(int i=0;i<=m;i++){
	        	System.out.print(res[i]+" ");
	        }
	        return res[m];
	    }
	 public static void main(String args[]){
		 int[] A = {3,4,8,5};
		 int m = 10;
		 int res = backPack(m,A);
		 System.out.println("res="+res);
	 }
}
