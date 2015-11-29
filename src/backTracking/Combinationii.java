package backTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinationii {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(candidates,list,result,target,0);
        return result;
    }
	public void helper(int[] candidates,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> result,int target,int start){
        if(target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
           if(i > 0 && candidates[i] == candidates[i-1]){
               continue;
           } 
           if(candidates[i] > target){
               break;
           }
           list.add(candidates[i]);
           helper(candidates,list,result,target-candidates[i],i);
           list.remove(list.size()-1);
        }
    }
}
