package array;

import java.util.Arrays;

public class Ksum {
	 static int res = 0;
     static int total = 0;
    public static int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length < k){
            return 0;
        }
        Arrays.sort(A);
        helper(A,k,target,0);
        return res;
    }
    public static void helper(int[] A,int k,int target,int start){
        if(k == 0 && total == target){
            res++;
            return;
        }
        if(start >= A.length || k <= 0 || total > target){
            return;
        }
        for(int i=start;i<=A.length-k;i++){
        	System.out.println("k = "+k);
        	System.out.println("i = "+i);
            total += A[i];
            helper(A,k-1,target,i+1);
            total -= A[i];
        }
    }
    public static void main(String args[]){
    	int[] nums = {1,3,4,5,8,10,11,12,14,17,20,22,24,25,28,30,31,34,35,37,38,40,42,44,45,48,51,54,56,59,60,61,63,66};
    	int k = 24;
    	int target = 842;
    	int result = kSum(nums,k,target);
    	System.out.println("result = "+result);
    }
}
