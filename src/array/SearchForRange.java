package array;
/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
 */
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int length = A.length;
        int[] result = {-1,-1};
        if(A==null||length==0)
        return result;
        int low = 0;
        
        int high = length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid]==target){
            high = mid;
            if(high==low){
                result[0] = low;
                break;
            }
            }
            else if(A[mid]<target)
            low = mid+1;
            else
            high = mid-1;
        }
        
        low = 0;
        high = length-1;
        
        while(low<=high){
            int mid = (low+high+1)/2;
            if(A[mid]==target){
            low = mid;
            if(high==low){
                result[1] = high;
                break;
            }
            }
            else if(A[mid]<target)
            low = mid+1;
            else
            high = mid-1;
        }
        
        return result;
    }
}
