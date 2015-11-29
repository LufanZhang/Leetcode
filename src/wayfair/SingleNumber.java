package wayfair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

//其他出现2次，找出现一次的
public class SingleNumber {
//	public int singleNumber(int[] nums) {
//        int length = nums.length;
//        int res = nums[0];
//        for(int i=1;i<length;i++){
//            res = res ^ nums[i];
//        }
//        return res;
//    }
	public int singleNumber(int[] nums){
		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<length;i++){
			if(!set.add(nums[i])){ //indicate this number is duplicated
				set.remove(nums[i]);
			}
		}
		Iterator iter = set.iterator();
		return (Integer) iter.next();
	}
	
	//如果其他的重复的数字不一定是重复两次，可能会重复多次
	public int singleNumberII(int[] nums){
		int length = nums.length;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++){
			int cur = nums[i];
			if(!map.containsKey(cur)){
				map.put(nums[i], 1);
			}
			else{
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			int count = (Integer)entry.getValue();
			if(count == 1){
				return (Integer)entry.getKey();
			}
		}
		return 0;
	}
}
