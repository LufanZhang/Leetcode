package bitManipulation;
/*
 *  Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 */
public class SingleNumberII {
//	 public int singleNumber(int[] A) {
//	        int length = A.length;
//	        if(A==null||length==0)
//	        return 0;
//	        int result = 0;
//	        for(int i=0;i<32;i++){
//	            int bitNum = 0;
//	            for(int j=0;j<length;j++){
//	                bitNum+=A[j]>>i&1;
//	            }
//	            result|=(bitNum%3)<<i;
//	        }
//	        return result;
//	    }
	 public static int singleNumberII(int[] A) {
	        // write your code here
	        if(A == null || A.length == 0){
	            return 0;
	        }
	        int length = A.length;
	        int[] number = new int[32];
	        for(int i=0;i<length;i++){
	            int cur = A[i];
	            for(int j=31;j>=0;j--){
	                    number[j] += cur & 1;
	                    cur = cur >> 1;
	            }
	        }
	        for(int i=0;i<32;i++){
	        	System.out.print(number[i]+" ");
	        }
	        int res = 0;
	        for(int i=0;i<32;i++){
	            int cur = number[i] % 3;
	            res = (res << 1) + cur;
	        }
	        return res;
	    }
	 public static void main(String args[]){
		 int[] A = {1,1,2,3,3,3,2,2,4,1};
		 int res = singleNumberII(A);
		 System.out.println("res = "+res);
		 }
	 
}
