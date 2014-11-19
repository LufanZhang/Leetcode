package array;
/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int length = A.length;
        if(A==null||length==0)
        return 0;
        int result = 0;
        for(int i=0;i<length;i++){
            if(A[i]==elem)
            continue;
            else{
                A[result] = A[i];
                result++;
            }
        }
        return result;
    }
}
