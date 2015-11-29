package array;

import java.util.ArrayList;

public class PreviousPermutation {
	public static ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(nums == null ||nums.size() == 0){
		    return result;
		}
		int length = nums.size();
		int[] res = new int[length];
		for(int i=0;i<length;i++){
		    res[i] = nums.get(i);
		}
		int index = -1;
		for(int i=length-1;i>0;i--){
		    if(res[i] < res[i-1]){
		        index = i-1;
		        break;
		    }
		}
		if(index >= 0){
		    int cur = res[index];
		    for(int i=length-1;i>index;i--){
		        if(res[i] < cur){
		            int temp = res[i];
		            res[i] = cur;
		            res[index] = temp;
		            break;
		        }
		    }
		}
		System.out.println("index = "+index);
		reverse(res,index+1,length-1);
		for(int i=0;i<length;i++){
		    result.add(res[i]);
		}
		return result;
    }
    public static void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
