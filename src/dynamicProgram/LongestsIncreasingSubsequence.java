package dynamicProgram;

public class LongestsIncreasingSubsequence {
	public int lsi(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int[] dp = new int[length+1];
		int index = 2;
		dp[1] = nums[0];
		for(int i=1;i<length;i++){
			int cur = nums[i];
			if(cur > dp[index-1]){
				dp[index] = cur;
				index++;
			}
			else{
				int pos = findPos(dp,1,index-1,cur);
				dp[pos] = cur;
			}
		}
		return index - 1;
	}
	public int findPos(int[] dp,int start,int end,int target){
		while(start < end - 1){
			int mid = start + (end - start) / 2;
			int cur = dp[mid];
			if(cur <= target){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		if(dp[start] > target){
			return start;
		}
		return end;
	}
}
