package array;

import java.util.ArrayList;

public class MaximumSubarrayIII {
	public static int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
		if(nums == null || nums.size() == 0){
            return 0;
        }
        int length = nums.size();
        int[] res = new int[length];
        for(int i=0;i<length;i++){
            if(i == 0){
                res[i] = Math.max(0,nums.get(i));
            }
            else{
                res[i] = Math.max(0,nums.get(i)+res[i-1]);
            }
        }
        for(int i=0;i<length;i++){
        	System.out.print(res[i]+ " ");
        }
        System.out.println("");
        for(int i=0;i<=k;i++){
        	int pre = res[0];
            for(int j=1;j<length;j++){
            	System.out.println("j="+j+"  res[j-1]="+res[j-1]+"  nums.get(j)+pre="+(nums.get(j)+pre)+"  pre="+pre);
                int temp = res[j];
                res[j] = Math.max(res[j-1],nums.get(j)+pre);
                pre = temp;
            }
            for(int m=0;m<length;m++){
            	System.out.print(res[m]+ " ");
            }
            System.out.println("");
        }
        return res[length-1];
    }
	public static void main(String args[]){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
//		nums.add(-100);
//		nums.add(-1);
//		nums.add(-50);
		System.out.println("result = "+maxSubArray(nums,1));
	}
}
