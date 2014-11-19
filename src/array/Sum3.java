package array;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 */

/*
this problem can be solved with O(N2) time complexity, first, we sort this array, and choose the first number, 
assume every number in this array can be the first number, and then we consider the subarray after which after 
the first index, using two pointers, one is first, one is last to point the two sides of the subarray, find the 
last two numbers(if first+firstIndex+lastIndex<target, then move the firstIndex to right, if 
first+firstIndex+lastIndex==target, this is one of the result, add this to result, else, move the lastIndex to left)
*/
public class Sum3 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //cornercase:num's length<3
        int length = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length<3)
        return result;
        Arrays.sort(num);
        for(int i=0;i<=length-2;i++){
            if(i>0&&num[i]==num[i-1])
            continue;
           int second = i+1;
            int last = length-1;
            while(second<last){
                if(num[second]==num[second-1]&&second>i+1){
                    second++;
                    continue;
                }
                if(last<length-1&&num[last]==num[last+1]){
                    last--;
                    continue;
                }
                if(num[i]+num[second]+num[last]==0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[second]);
                    list.add(num[last]);
                    result.add(list);
                    second++;
                    last--;
                }
                else if(num[i]+num[second]+num[last]<0)
                second++;
                else
                last--;
            }
        }
        return result;
    }
}
