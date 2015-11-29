package godaddy;

public class Merge {
	 public void mergeArray(int[] nums1, int m, int[] nums2, int n) {
	        int pos = m + n - 1;
	        int runner1 = m-1;
	        int runner2 = n - 1;
	        while(runner1 >= 0 || runner2 >= 0){
	            if(runner1 < 0){
	                nums1[pos] = nums2[runner2];
	                runner2--;
	            }
	            else if(runner2 < 0){
	                nums1[pos] = nums1[runner1];
	                runner1--;
	            }
	            else{
	                nums1[pos] = Math.max(nums1[runner1],nums2[runner2]);
	                if(nums1[runner1] > nums2[runner2]){
	                    runner1--;
	                }
	                else{
	                    runner2--;
	                }
	            }
	            pos--;
	        }
	    }
}
