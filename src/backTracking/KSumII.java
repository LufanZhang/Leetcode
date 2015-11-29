package backTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class KSumII {
	 public static ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
	        // write your code here
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if(A == null || A.length == 0){
	            return res;
	        }
	        Arrays.sort(A);
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        helper(A,k,target,res,list,0);
	        return res;
	    }
	    public static void helper(int[] A,int k,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int start){
	        System.out.println("target = "+target);
	        System.out.println("list = "+list);
	        System.out.println("start = "+start);
	        if(target < 0){
	        	return;
	        }
	    	if(list.size() == k && target == 0){
	            res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        if(start >= A.length){
	            return;
	        }
	        for(int i=start;i<A.length;i++){
	            list.add(A[i]);
	            helper(A,k,target-A[i],res,list,i+1);
	            list.remove(list.size()-1);
	        }
	    }
	    public static void main(String args[]){
	    	int[] A = {1,2,3,4};
	    	int k = 2;
	    	int target = 5;
	    	System.out.println(kSumII(A,k,target));
	    }
}
