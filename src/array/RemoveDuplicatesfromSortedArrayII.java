package array;
/*
 *  Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. 
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length<=1)
        return A.length;
        int runner = 1;
        int start = 1;
        boolean flag = false;
        int count = 0;
        while(runner<A.length){
            if(A[runner]==A[runner-1]){
                if(flag==true){
                    runner++;
                    count++;
                }
                else{
                    flag = true;
                    A[start] = A[runner];
                    start++;
                    runner++;
                }
            }
            else{
                flag = false;
                A[start] = A[runner];
                start++;
                runner++;
            }
        }
      return A.length-count;
    }
}
