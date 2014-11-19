package array;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class Subsets {
	 public ArrayList<ArrayList<Integer>> subsets(int[] num) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        int length = num.length;
	        if(num==null||length==0)
	        return result;
	        Arrays.sort(num);
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        subsetsHelper(num,result,list,0);
	        return result;
	    }
	    public void subsetsHelper(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,int start){
	        result.add(new ArrayList<Integer>(list));
	        for(int i=start;i<num.length;i++){
	            list.add(num[i]);
	            subsetsHelper(num,result,list,i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
