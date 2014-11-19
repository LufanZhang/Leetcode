package backTracking;

import java.util.ArrayList;

/*
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k){
  	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(n<1||n<k)
	    return result;
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    combineHelper(n,k,list,result,1);
	    return result;
	}
	public void combineHelper(int n,int k,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> result,int start){
	    if(list.size()==k){
	        result.add(new ArrayList<Integer>(list));
	        return;
	    }
	    for(int i=start;i<=n;i++){
	        list.add(i);
	        combineHelper(n,k,list,result,i+1);
	        list.remove(list.size()-1);
	    }
	}

}
