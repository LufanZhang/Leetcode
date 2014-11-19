package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
 */
public class PermutationsII {
	  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
          if(num==null||num.length==0)
          return result;
          Arrays.sort(num);
          ArrayList<Integer> list = new ArrayList<Integer>();
          HashSet<Integer> set = new HashSet<Integer>();
          permuteHelper(num,result,list,set);
          return result;
	   }
	   public void permuteHelper(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,HashSet<Integer> set){
	       if(list.size()==num.length){
	           result.add(new ArrayList<Integer>(list));
	           return;
	       }
	       for(int i=0;i<num.length;i++){
	           if((i>0&&num[i]==num[i-1]&&!set.contains(i-1))||set.contains(i))
	           continue;
	           list.add(num[i]);
	           set.add(i);
	           permuteHelper(num,result,list,set);
	           list.remove(list.size()-1);
	           set.remove(i);
	       }
	       
	   }
}
