package array;

public class SubarraySumII {
	 static int total = 0;
     static int res = 0;
    public static int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        helper(A,start,end,0);
        return res;
    }
    public static void helper(int[] A,int start,int end,int begin){
        if(total >= start && total <= end){
        	System.out.println("total = "+total);
            res++;
        }
        if(begin >= A.length){
            return;
        }
        for(int i=begin;i<A.length;i++){
            total += A[i];
            helper(A,start,end,begin+1);
            total -= A[i];
        }
    }
    public static void main(String args[]){
    	int[] A = {1,3,4,5,6,7,1,2,3,4,5};
    	int start = 1;
    	int end = 19;
    	int result = subarraySumII(A,start,end);
    	System.out.println("result = "+result);
    }
}
