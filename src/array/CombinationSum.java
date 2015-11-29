package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
 */
public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        if(candidates == null || candidates.length == 0){
	            return res;
	        }
	        Arrays.sort(candidates);
	        helper(res,list,target,0,candidates);
	        return res;
	    }
	    public void helper(List<List<Integer>> res,List<Integer> list,int target,int start,int[] nums){
	        if(target == 0){
	            res.add(new ArrayList<Integer>(list));
	        }
	        if(start >= nums.length || target < nums[start]){
	            return;
	        }
	        for(int i=start;i<nums.length;i++){
	            if(i>0 && nums[i] == nums[i-1]){
	                continue;
	            }
	            list.add(nums[i]);
	            helper(res,list,target-nums[i],i,nums);
	            list.remove(list.size()-1);
	        }
	    }
}
