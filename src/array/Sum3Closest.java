package array;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class Sum3Closest {
    public int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        int length = num.length;
        if(num==null||length<3)
        return 0;
        Arrays.sort(num);
        for(int i=0;i<=length-2;i++){
            if(i>0&&num[i]==num[i-1])
            continue;
            int second = i+1;
            int last = length-1;
            while(second<last){
                int dumTarget = num[i]+num[second]+num[last];
                if(dumTarget==target)
                return dumTarget;
                else if(dumTarget<target)
                second++;
                else
                last--;
                if(Math.abs(target-dumTarget)<min){
                    min = Math.abs(target-dumTarget);
                    result = dumTarget;
                }
            }
        }
        return result;
    }
}
