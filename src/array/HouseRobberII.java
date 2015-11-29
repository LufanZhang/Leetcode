package array;

public class HouseRobberII {
	public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        int[] result = new int[length];
        result[0] = 0;
        int index = 1;
        if(nums[0] >= nums[length-1]){
            index = 0;
        }
        for(int i=1;i<length;i++){
            result[i] = nums[index];
            index++;
        }
        for(int i=0;i<length;i++){
        	System.out.print(result[i] + " ");
        }
        for(int i=2;i<length;i++){
        	System.out.println("nums[i]+nums[i-2] = "+(nums[i]+nums[i-2]));
        	System.out.println("nums[i-1] = "+nums[i-1]);
            result[i] = Math.max(nums[i]+nums[i-2],nums[i-1]);
            System.out.println("result"+"["+i+"]"+" = "+result[i]);
        }
        for(int i=0;i<length;i++){
        	System.out.print(result[i] + " ");
        }
        return result[length-1];
    }
	public static void main(String[] args){
		int[] nums = {1,1,1};
		int result = rob(nums);
		System.out.println("");
		System.out.println(result);
	}
}
