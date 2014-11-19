package array;
/*
 * 

    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] num) {
        int length = num.length;
        if(num==null||length==0)
        return 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            if(num[i]<min)
            min = num[i];
        }
        return min;
    }
}
