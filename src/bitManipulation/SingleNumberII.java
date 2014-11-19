package bitManipulation;
/*
 *  Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 */
public class SingleNumberII {
	 public int singleNumber(int[] A) {
	        int length = A.length;
	        if(A==null||length==0)
	        return 0;
	        int result = 0;
	        for(int i=0;i<32;i++){
	            int bitNum = 0;
	            for(int j=0;j<length;j++){
	                bitNum+=A[j]>>i&1;
	            }
	            result|=(bitNum%3)<<i;
	        }
	        return result;
	    }
}
