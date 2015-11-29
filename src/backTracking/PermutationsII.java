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
	  public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
          if(num==null||num.length==0)
          return result;
          Arrays.sort(num);
          ArrayList<Integer> list = new ArrayList<Integer>();
          HashSet<Integer> set = new HashSet<Integer>();
          permuteHelper(num,result,list,set);
          return result;
	   }
	   public static void permuteHelper(int[] num,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,HashSet<Integer> set){
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
//	public static List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(nums == null || nums.length == 0){
//            return res;
//        }
//        List<Integer> list = new ArrayList<Integer>();
//        Arrays.sort(nums);
//        permuteHelper(res,list,nums);
//        return res;
//    }
//    public static void permuteHelper(List<List<Integer>> res,List<Integer> list,int[] nums){
//        if(list.size() == nums.length){
//            List<Integer> temp = new ArrayList<Integer>();
//            for(int i=0;i<nums.length;i++){
//                temp.add(nums[list.get(i)]);
//            }
//            res.add(temp);
//        }
//        for(int i=0;i<nums.length;i++){
//            int cur = nums[i];
//            if((i != 0 && cur == nums[i-1] && !list.contains(i-1)) || list.contains(i)){
//                continue;
//            }
//            list.add(i);
//            permuteHelper(res,list,nums);
//            list.remove(list.size()-1);
//        }
//    }
	   public static void main(String[] args){
		   int[] nums = {3,3,0,0,2,3,2};
		   ArrayList<ArrayList<Integer>> list = permuteUnique(nums);
		   System.out.println(list.size());
	   }
}
