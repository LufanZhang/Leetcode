package array;

public class FindDuplicate {
	public static int findDuplicate(int[] nums){
		if (nums.length > 1)
	    {
	        int slow = nums[0];
	        int fast = nums[nums[0]];
	        while (slow != fast)
	        {
	        	System.out.println(slow+"  "+fast);
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }

	        fast = 0;
	        System.out.println("slow="+slow+"  "+"fast="+fast);
	        while (fast != slow)
	        {
	            fast = nums[fast];
	            slow = nums[slow];
	            System.out.println(slow+"  "+fast);
	        }
	        return slow;
	    }
	    return -1;
	}
//	public static int findDuplicate(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int start = 1;
//        int end = nums.length - 1;
//        while(start < end){
//            int mid = start + (end - start) / 2;
//            int smallNum = 0;
//            int bigNum = 0;
//            for(int i=0;i<nums.length;i++){
//                int cur = nums[i];
//                if(cur <= mid && cur >= start){
//                    smallNum++;
//                }
//                else if(cur > mid && cur <= end){
//                    bigNum++;
//                }
//            }
//            if(smallNum > mid - start + 1){
//                end = mid;
//            }
//            else{
//                start = mid + 1;
//            }
//        }
//        return start;
//    }
	public static void main(String args[]){
		int[] nums = {3,4,1,4,2,5};
		int res = findDuplicate(nums);
		System.out.println("res="+res);
	}
}
