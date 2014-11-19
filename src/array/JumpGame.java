package array;
/*
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
 */
public class JumpGame {
	   public boolean canJump(int[] A) {
	        int length = A.length;
	        if(A==null||length<=1)
	        return true;
	        if(A[0]<=0)
	        return false;
	        for(int i=1;i<length-1;i++){
	            A[i] = A[i]>A[i-1]-1? A[i]:A[i-1]-1;
	            if(A[i]<=0)
	            return false;
	        }
	        return true;
	}
}
