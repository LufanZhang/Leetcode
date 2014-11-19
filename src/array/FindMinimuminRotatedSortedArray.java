package array;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] num) {
        int length = num.length;
        if(num == null || length == 0){
            return 0;
        }
        int start = 0;
        int end = length - 1;
        if (num[start] < num[end]){
            return num[start];
        }
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[mid] > num[start]){
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(num[start], num[end]);
     }
}
