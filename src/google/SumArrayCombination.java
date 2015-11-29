package google;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class SumArrayCombination {
	public static List<String> findCombination(int[] nums,int target){
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0){
			return res;
		}
		List<Integer> list = new ArrayList<Integer>();
		dfsHelper(nums,0,target,res,list);
		return res;
	}
	public static void dfsHelper(int[] nums,int start,int target,List<String> res,List<Integer> list){
		if(start == nums.length && target == 0){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<list.size();i++){
				sb.append(list.get(i));
				sb.append('+');
			}
			sb.deleteCharAt(sb.length()-1);
			res.add(sb.toString());
			return;
		}
		if(start >= nums.length || target < 0){
			return;
		}
		if(nums[start] == 0){
			list.add(0);
			dfsHelper(nums,start+1,target,res,list);
			list.remove(list.size()-1);
		}
		else{
			long sum = 0;
			for(int i=start;i<nums.length;i++){
				sum = sum*10 + nums[i];
				if(sum > Integer.MAX_VALUE){
					break;
				}
				list.add((int)sum);
				dfsHelper(nums,i+1,target-(int)sum,res,list);
				list.remove(list.size()-1);
			}
		}
	}
	public boolean contain(int[] nums,int k,int target){
		if(nums == null || nums.length == 0){
			return false;
		}
		int length = nums.length;
		int count = 0;
		int start = 0;
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int i=0;i<length;i++){
			int cur = nums[i];
			if(map.containsKey(cur)){
				map.put(cur,map.get(cur)+1);
			}
			else{
				map.put(cur, 1);
			}
			count++;
			if(count > k){
				map.put(nums[start],map.get(nums[start])-1);
				if(map.get(nums[start]) == 0){
					map.remove(nums[start]);
				}
				start++;
			}
			if(Math.abs(cur-map.floorKey(cur)) <= target || Math.abs(cur-map.ceilingKey(cur)) <= target){
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]){
//		int[] nums = {6,3,1,0,5};
//		int target = 636;
//		List<String> res = findCombination(nums,target);
//		System.out.println(res);
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(-1);
		set.add(-1);
		set.add(-1);
		System.out.println(set.size());
	}
}
