package array;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class SubsetsII {
	  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	        int length = num.length;
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(num==null||length==0)
	        return result;
	        Arrays.sort(num);
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        sebsetsHelper(num,result,list,0);
	        return result;
	    }
	    public void sebsetsHelper(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,int start){
	        result.add(new ArrayList<Integer>(list));
	        for(int i=start;i<num.length;i++){
	            if(i>start&&num[i]==num[i-1])
	            continue;
	            list.add(num[i]);
	            sebsetsHelper(num,result,list,i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
