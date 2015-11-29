package array;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray {
//    public int findMin(int[] num) {
//        int length = num.length;
//        if(num == null || length == 0){
//            return 0;
//        }
//        int start = 0;
//        int end = length - 1;
//        if (num[start] < num[end]){
//            return num[start];
//        }
//        while (start + 1 < end){
//            int mid = start + (end - start) / 2;
//            if (num[mid] > num[start]){
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
//        return Math.min(num[start], num[end]);
//     }
	public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        while(start < end-1){
            if(nums[start] < nums[end]){
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            int cur = nums[mid];
            System.out.println("mid = "+mid+"   cur = "+cur);
            if(cur > start){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return Math.min(nums[start],nums[end]);
    }
	public static void main(String args[]){
		int[] nums = {5,1,2,3,4};
		int res = findMin(nums);
		System.out.println(res);
	}
}
