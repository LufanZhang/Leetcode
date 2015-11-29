package array;

public class Median {
	 public static int median(int[] nums) {
	        // write your code here
	        if(nums == null || nums.length == 0){
	            return 0;
	        }
	        int length = nums.length;
	        int k = (length+1)/2;
	        return helper(nums,0,length-1,k);
	    }
	    public static int helper(int[] nums,int start,int end,int k){
	        //quick sort
	    	System.out.print("start="+start+"  end="+end+"  k="+k);
	    	System.out.print("   ");
	    	for(int i=start;i<=end;i++){
	    		System.out.print(nums[i]+" ");
	    	}
	    	System.out.println("");
	        int measure = nums[start];
	        int tempEnd = end;
	        int tempStart = start;
	        start++;
	        while(start <= end){
	            int cur = nums[start];
	            if(cur <= measure){
	                start++;
	            }
	            else{
	                swap(nums,start,end);
	                end--;
	            }
	        }
	        swap(nums,tempStart,end);
	        if(end-tempStart == k-1){
	            return nums[end];
	        }
	        else if(end-tempStart < k-1){
	            return helper(nums,end+1,tempEnd,k-(end-tempStart+1));
	        }
	        else{
	            
	        }return helper(nums,tempStart,end-1,k);
	        
	    }
	    public static void swap(int[] nums,int i,int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    public static void main(String args[]){
	    	int[] nums = {4,5,1,2,3};
	    	int res = median(nums);
	    	System.out.println("res = "+res);
	    	char c = 'a';

	    }
}
