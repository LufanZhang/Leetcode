package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {
	 public int[] medianII(int[] nums) {
	        // write your code here
	        if(nums == null || nums.length == 0){
	            return null;
	        }
	        int length = nums.length;
	        Comparator<Integer> comparatorMax = new Comparator<Integer>(){
	            public int compare(Integer a,Integer b){
	                return b-a;
	            }
	        };
	        Comparator<Integer> comparatorMin = new Comparator<Integer>(){
	            public int compare(Integer a,Integer b){
	                return a-b;
	            }
	        };
	        int[] res = new int[length];
	        PriorityQueue<Integer> max = new PriorityQueue<Integer>(comparatorMax);
	        PriorityQueue<Integer> min = new PriorityQueue<Integer>(comparatorMin);
	        for(int i=0;i<length;i++){
	            int cur = nums[i];
	            if(max.size() == 0){
	                max.offer(cur);
	            }
	            else if(max.size() > min.size()){
	                                if(cur < max.peek()){
	                    max.offer(cur);
	                    min.offer(max.poll());
	                }
	                else{
	                    min.offer(cur);
	                }
	            }
	            else{
	                if(cur > max.peek()){
	                    min.offer(cur);
	                    max.offer(min.poll());
	                }
	                else{
	                    max.offer(cur);
	                }
	            }
	            res[i] = max.peek();
	        }
	        return res;
	    }
}
