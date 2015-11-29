package array;

import java.util.Arrays;

/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
//	 private class pair{
//         int min,max;
//      }
//  public int maximumGap(int[] num) {
//      if(num == null || num.length <= 1){
//          return 0;
//      }
//      int length = num.length;
//      pair[] buckets = new pair[length];
//      int minNum = num[0];
//      int maxNum = num[0];
//      for(int i=0;i<length;i++){
//          if(num[i] > maxNum){
//              maxNum = num[i];
//          }
//          if(num[i] < minNum){
//              minNum = num[i];
//          }
//      }
//      int diff = (maxNum - minNum - 1) / (length-1) + 1;
//      for(int i=0;i<length;i++){
//          int pos = (num[i] - minNum) / diff;
//          if(buckets[pos] == null){
//              buckets[pos] = new pair();
//              buckets[pos].min = num[i];
//              buckets[pos].max = num[i];
//          }
//          else{
//              if(num[i] > buckets[pos].max){
//                  buckets[pos].max = num[i];
//              }
//              if(num[i] < buckets[pos].min){
//                  buckets[pos].min = num[i];
//              }
//          }
//      }
//      int pre = buckets[0].max;
//      int res = 0;
//      for(int i=1;i<length;i++){
//          if(buckets[i] != null){
//              if(buckets[i].min - pre > res){
//                  res = buckets[i].min - pre;
//              }
//              pre = buckets[i].max;
//          }
//      }
//      return res;
//  }
	 public static int maximumGap(int[] nums) {
	        if(nums == null || nums.length <= 1){
	            return 0;
	        }
	        int length = nums.length;
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        for(int i=0;i<length;i++){
	            int cur = nums[i];
	            if(cur < min){
	                min = cur;
	            }
	            if(cur > max){
	                max = cur;
	            }
	        }
	        int diff = Math.max((max - min) / (length - 1),1);
	        double temp = (max - min + 1) * 1.0 / (diff * 1.0);
	        int bucketNum = (int)Math.ceil(temp);
	        System.out.println("min="+min+" max="+max+" diff="+diff+" bucketNum="+bucketNum);
	        int[] up = new int[bucketNum];
	        int[] down = new int[bucketNum];
	        Arrays.fill(up,Integer.MIN_VALUE);
	        Arrays.fill(down,Integer.MAX_VALUE);
	        for(int i=0;i<length;i++){
	            int cur = nums[i];
	            int pos = (cur - min) / diff;
	            if(up[pos] < cur){
	                up[pos] = cur;
	            }
	            if(down[pos] > cur){
	                down[pos] = cur;
	            }
	            System.out.println("cur="+cur+" pos="+pos+" up="+up[pos]+" down="+down[pos]);
	        }
	        System.out.println("down[0]="+down[0]);
	        int res = 0;
	        int pre = up[0];
	        Arrays.sort(nums);
//	        for(int i=0;i<length;i++){
//	        	System.out.print(nums[i]+" ");
//	        }
	        System.out.println("------------------------>");
	        for(int i=0;i<bucketNum;i++){
	        	System.out.println("pos="+i+"  "+up[i]+" "+down[i]);
	        }
	        System.out.println("-------------------------->");
//	        for(int i=0;i<bucketNum;i++){
//	        	System.out.print(down[i]+" ");
//	        }
	        System.out.println("");
	        for(int i=1;i<bucketNum;i++){
	        	if(up[i] != Integer.MIN_VALUE){
	        		if(down[i] - pre > res){
	        			res = down[i] - pre;
	        		}
	        		pre = up[i];
	        	}
	        }
	        return res;
	    }
	 public static void main(String args[]){
		 int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
		 int res = maximumGap(nums);
		 System.out.println("res = "+res);
	 }
}
