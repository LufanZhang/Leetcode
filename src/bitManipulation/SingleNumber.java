package bitManipulation;
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 */
public class SingleNumber {
	  public int singleNumber(int[] A) {
	        if(A==null||A.length==0)
	        return 0;
	        int sum = 0;
	        for(int i=0;i<A.length;i++){
	            sum = sum^A[i];
	        }
	        return sum;
	    }
}
