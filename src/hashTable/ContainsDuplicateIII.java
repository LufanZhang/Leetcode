package hashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ContainsDuplicateIII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k <= 0){
            return false;
        }
        int length = nums.length;
        Comparator<Integer> smallBig = new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return a-b;
            }
        };
         Comparator<Integer> bigSmall = new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        };
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(smallBig);
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(bigSmall);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(nums[0],1);
        pq1.offer(nums[0]);
        pq2.offer(nums[0]);
        for(int i=1;i<length;i++){
            int cur = nums[i];
            if(i > k){
                int removeNum = nums[i-k-1];
                map.put(removeNum,map.get(removeNum)-1);
                if(map.get(removeNum) == 0){
                    map.remove(removeNum);
                }
            }
            while(!pq1.isEmpty() && !map.containsKey(pq1.peek())){
                pq1.poll();
            }
            while(!pq2.isEmpty() && !map.containsKey(pq2.peek())){
                pq2.poll();
            }
            long min = pq1.peek();
            long max = pq2.peek();
            long curLong = (long)cur;
            long differ1 = (long)(curLong - max);
            long differ2 = (long)(min - curLong);
            System.out.println("cur="+cur+"  min="+min+"  max="+max+"  differ1="+differ1+"  differ2="+differ2);
            if(differ1 <= t && differ2 <= t){
                return true;
            }
            pq1.offer(cur);
            pq2.offer(cur);
             if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }
            else{
                map.put(cur,1);
            }
        }
        return false;
    }
	public static void main(String args[]){
		int[] nums = {0,10,22,15,0,5,22,12,1,5};
		int k = 3;
		int t = 3;
		boolean res = containsNearbyAlmostDuplicate(nums,k,t);
		System.out.println("res = "+res);
		
	}
}
