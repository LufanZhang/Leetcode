package binarySearchTree;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
        if(num == null || num.length == 0){
            return -1;
        }
        int length = num.length;
       int low = 0;
       int high = length - 1;
       while(low < high - 1){
           int mid = low + (high - low) / 2;
           if(num[mid] < num[mid + 1]){
               low = mid;
           }
           else{
               high = mid;
           }
       }
       return num[low] > num[high]? low:high;
    }
}
