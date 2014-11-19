package array;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
	   public int search(int[] A, int target) {
	       int length = A.length;
	       if(A==null||length==0)
	       return -1;
	       int low = 0;
	       int high = length-1;
	       while(low<=high){
	           if(A[low]<A[high]&&(target>A[high]||target<A[low]))
	           return -1;
	           int mid = (low+high)/2;
	           if(A[mid]==target)
	           return mid;
	           if((A[mid]>A[high]&&A[low]<=target&&target<A[mid])||(A[mid]<A[high]&&(target>A[high]||target<A[mid])))
	           high = mid-1;
	           else
	           low = mid+1;
	       }
	       return -1;
	    }
}
