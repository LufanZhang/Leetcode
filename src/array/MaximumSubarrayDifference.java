package array;

import java.util.ArrayList;

public class MaximumSubarrayDifference {
	 public static int maxDiffSubArrays(ArrayList<Integer> nums) {
	        // write your code
	        if(nums == null || nums.size() == 0){
	            return 0;
	        }
	        int length = nums.size();
	        int[] leftLargest = new int[length];
	        int[] rightLargest = new int[length];
	        int[] leftLeast = new int[length];
	        int[] rightLeast = new int[length];
	        int tempLarge = 0;
	        int tempLeast = 0;
	        for(int i=0;i<length;i++){
	            int cur = nums.get(i);
	            if(i == 0){
	                leftLargest[0] = cur;
	                leftLeast[0] = cur;
	                tempLarge = Math.max(0,cur);
	                tempLeast = Math.min(0,cur);
	            }
	            else{
	                leftLargest[i] = Math.max(leftLargest[i-1],tempLarge+cur);
	                leftLeast[i] = Math.min(leftLeast[i-1],tempLeast+cur);
	                tempLarge = Math.max(0,tempLarge+cur);
	                tempLeast = Math.min(0,tempLeast+cur);
	            }
	            System.out.println("i="+i+" leftLargest[i]="+leftLargest[i]+" temp="+tempLarge);
	        }
	        for(int i=length-1;i>=0;i--){
	            int cur = nums.get(i);
	            if(i == length-1){
	                rightLargest[length-1] = cur;
	                rightLeast[length-1] = cur;
	                tempLarge = Math.max(0,cur);
	                tempLeast = Math.min(0,cur);
	            }
	            else{
	                rightLargest[i] = Math.max(rightLargest[i+1],tempLarge+cur);
	                rightLeast[i] = Math.min(rightLeast[i+1],tempLeast+cur);
	                tempLarge = Math.max(0,tempLarge+cur);
	                tempLeast = Math.min(0,tempLeast+cur);
	            }
	        }
	        int res = 0;
	        //-------------------------------------------------------------------------------
	        for(int i=0;i<length;i++){
	        	System.out.print(leftLargest[i]+" ");
	        }
	        System.out.println("");
	        for(int i=0;i<length;i++){
	        	System.out.print(rightLeast[i]+" ");
	        }
	        System.out.println("");
	        for(int i=0;i<length;i++){
	        	System.out.print(rightLargest[i]+" ");
	        }
	        System.out.println("");
	        for(int i=0;i<length;i++){
	        	System.out.print(leftLeast[i]+" ");
	        }
	        System.out.println("");
	      //-------------------------------------------------------------------------------
	        for(int i=0;i<length-1;i++){
	            int firstDiff = leftLargest[i] - rightLeast[i+1];
	            int secondDiff = rightLargest[i+1] - leftLeast[i];
	            res = Math.max(res,Math.max(firstDiff,secondDiff));
	        }
	        return res;
	    }
	 public static void main(String args[]){
		 ArrayList<Integer> nums = new ArrayList<Integer>();
		 int[] num = {-5,-4};
		 for(int i=0;i<num.length;i++){
			 nums.add(num[i]);
		 }
		 int res = maxDiffSubArrays(nums);
		 System.out.println("res = "+res);
	 }
}
