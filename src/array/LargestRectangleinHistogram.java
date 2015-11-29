package array;

import java.util.Stack;

/*
 *  Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10. 
 */
public class LargestRectangleinHistogram {
//	   public int largestRectangleArea(int[] height){
//		  int length = height.length;
//		  if(height==null||length==0)
//		  return 0;
//		  int[] heightNum = new int[length+1];
//		  for(int i=0;i<length;i++){
//		      heightNum[i] = height[i];
//		  }
//		  heightNum[length] = 0;
//		  Stack<Integer> pos = new Stack<Integer>();
//		  Stack<Integer> high = new Stack<Integer>();
//		  pos.push(-1);
//		  high.push(0);
//		  int max = 0;
//		  int i = 0;
//		  while(i<=length){
//		      if(heightNum[i]>=high.peek()){
//		          if(heightNum[i]==high.peek()){
//		              high.pop();
//		              pos.pop();
//		          }
//		          pos.push(i);
//		          high.push(heightNum[i]);
//		          i++;
//		      }
//		      else{
//		          while(true){
//		              if(heightNum[i]>=high.peek())
//		              break;
//		              else{
//		                  int curHigh = high.pop();
//		                  pos.pop();
//		                  int width = i-pos.peek()-1;
//		                  if(width*curHigh>max)
//		                  max = width*curHigh;
//		              }
//		          }
//		      }
//		  }
//		  return max;
//	   }
	 public static int largestRectangleArea(int[] nums) {
	        if(nums == null || nums.length == 0){
	            return 0;
	        }
	        Stack<Integer> height = new Stack<Integer>();
	        Stack<Integer> pos = new Stack<Integer>();
	        height.push(0);
	        pos.push(-1);
	        int length = nums.length;
	        int index = 0;
	        int res = 0;
	        while(index <= length){
	            int high = 0;
	           // System.out.println("high = "+high);
	            //System.out.println("index = "+index);
	            if(index < length){
	                high = nums[index];
	            }
	            System.out.println("high = "+high);
	            System.out.println("index = "+index);
	            if(height.isEmpty() || high >= height.peek()){
	                height.push(high);
	                pos.push(index);
	                index++;
	            }
	            else{
	                pos.pop();
	                int area = height.pop() * (index - pos.peek() - 1);
	                System.out.println("area = "+area);
	                if(area > res){
	                    res = area;
	                }
	            }
	            
	        }
	        return res;
	    }
	 public static void main(String[] args){
		 int[] nums = {1};
		 int res = largestRectangleArea(nums);
		 System.out.println(res);
	 }
}
