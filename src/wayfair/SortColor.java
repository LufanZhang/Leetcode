package wayfair;

public class SortColor {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int start = 0;
        int runner = 0;
        int end = nums.length - 1;
        while(runner <= end){
            int cur = nums[runner];
            if(cur == 1){
                runner++;
            }
            else if(cur == 0){
                swap(nums,runner,start);
                start++;
                runner++;
            }
            else{
                swap(nums,runner,end);
                end--;
            }
        }
    }
    public void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
}
