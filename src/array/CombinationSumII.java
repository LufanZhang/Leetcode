package array;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6] 
 */
public class CombinationSumII {
	  public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	      int length = num.length;
	      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	      if(num==null)
	      return result;
	      Arrays.sort(num);
	      ArrayList<Integer> list = new ArrayList<Integer>();
	      combinationHelper(num,result,list,target,0);
	      return result;
	    }
	    public void combinationHelper(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,int target,int start){
	        if(target<0)
	        return;
	        if(target==0){
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int i=start;i<num.length;i++){
	            if(i!=start&&num[i]==num[i-1])
	            continue;
	            list.add(num[i]);
	            combinationHelper(num,result,list,target-num[i],i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
