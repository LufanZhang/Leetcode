package backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
	       List<List<Integer>> res = new ArrayList<List<Integer>>();
	       if(k < 1 || n <= 0 || 9*k < n){
	           return res;
	       }
	       List<Integer> list = new ArrayList<Integer>();
	       dfs(res,list,k,n,1);
	       return res;
	    }
	    public void dfs(List<List<Integer>> res,List<Integer> list,int k,int target,int start){
	        if(list.size() == k && target == 0){
	            res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        if(list.size() > k || target < 0){
	            return;
	        }
	        for(int i=start;i<=9;i++){
	            list.add(i);
	            dfs(res,list,k,target-i,i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
