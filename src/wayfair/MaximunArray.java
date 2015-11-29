package wayfair;

public class MaximunArray {
	//这个是输出最大值的
//	public static int maxSubArray(int[] nums) {
//	       if(nums == null || nums.length == 0){
//	           return 0;
//	       }
//	       int length = nums.length;
//	       int start = 0;
//	       int end = 0;
//	       int sum = 0;
//	       int max = Integer.MIN_VALUE;
//	       while(end < length){
//	           if(sum + nums[end] > max){
//	               max = sum + nums[end];
//	           }
//	           if(sum + nums[end] >= 0){
//	               sum += nums[end];
//	               end++;
//	           }
//	           else{
//	               sum = 0;
//	               end++;
//	               start = end;
//	           }
//	       }
//	       return max;
//	    }
	
	
	//这个是要输出最大的那串subarray的
	public static int[] maximumSubarray(int[] array){
		if(array == null || array.length == 0){
			return array;
		}
		int length = array.length;
		//start和end是用来traverse这个array的
		int start = 0;
		int end = 0;
		//begin和finish是最后的结果
		int begin = 0;
		int finish = 0;
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while(end < length){
			int temp = sum + array[end];
			if(temp > max){
				max = temp;
				begin = start;
				finish = end;
			}
			if(temp < 0){
				end++;
				start = end;
				sum = 0;
			}
			else{
				sum = temp;
				end++;
			}
		}
		int[] res = new int[finish-begin+1];
		int index = 0;
		for(int i=begin;i<=finish;i++){
			res[index++] = array[i];
		}
		return res;
	}
	public static void main(String args[]){
		int[] array = {-1,7,-3,4,6,-8,3,-3,5};
		int[] res = maximumSubarray(array);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
