package array;
/*
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 */
public class JumpGameII {
    public int jump(int[] A) {
        int length = A.length;
        if(A==null||length==0)
        return 0;
        int[] res = new int[length];
        res[0] = 0;
        int start = 0;
        int end = 0;
        while(end<length-1){
            int maxStep = 0;
            int step = res[start];
            for(int i=start;i<=end;i++){
                if(i-start+A[i]>maxStep)
                maxStep = i-start+A[i];
            }
            int temp = start;
            start = end+1;
            end = temp+maxStep;
            for(int i=start;i<=end&&i<length;i++){
                res[i] = step+1;
            }
        }
        return res[length-1];
    }
}
