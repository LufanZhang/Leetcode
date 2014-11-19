package backTracking;

import java.util.ArrayList;

/*
 *  Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 */
public class Permutations {
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         if(num==null||num.length==0)
         return result;
         ArrayList<Integer> list = new ArrayList<Integer>();
         permuteHelper(num,result,list);
         return result;
	    }
	    public void permuteHelper(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
	        if(list.size()==num.length){
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int i=0;i<num.length;i++){
	            if(list.contains(num[i]))
	            continue;
	            list.add(num[i]);
	            permuteHelper(num,result,list);
	            list.remove(list.size()-1);
	        }
	    }
}
