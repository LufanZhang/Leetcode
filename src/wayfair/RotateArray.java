package wayfair;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        int length = nums.length;
        if(k > length){
            k = k % length;
        }
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
