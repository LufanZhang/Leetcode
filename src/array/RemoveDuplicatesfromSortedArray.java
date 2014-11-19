package array;
/*
 *  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. 
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        int length = A.length;
        if(A==null||length<=1)
        return length;
        int start = 0;
        for(int i=1;i<length;i++){
            if(A[i]==A[i-1])
            continue;
            else{
                start++;
                A[start] = A[i];
            }
        }
        return start+1;
    }
}
