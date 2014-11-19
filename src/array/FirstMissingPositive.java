package array;
/*
 *  Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
 */
public class FirstMissingPositive {
	   public int firstMissingPositive(int[] A) {
	        int length = A.length;
	        int result = length+1;
	        if(A==null||length==0)
	        return 1;
	        int i = 0;
	        while(i<length){
	            if(A[i]<=0||A[i]>length||A[i]==i+1||A[A[i]-1]==A[i])
	            i++;
	            else
	            swap(A,i,A[i]-1);
	        }
	        for(int j=0;j<length;j++){
	            if(A[j]!=j+1){
	                result = j+1;
	                break;
	            }
	            
	        }
	        return result;
	    }
	    public void swap(int[] num,int i,int j){
	        int temp = num[i];
	        num[i] = num[j];
	        num[j] = temp;
	    }
}
