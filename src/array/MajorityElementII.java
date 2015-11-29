package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public static int majorityNumber(ArrayList<Integer> nums) {
        // write your code
       if(nums == null || nums.size() == 0){
           return 0;
       }
       int first = 0;
       int firstCount = 0;
       int second = 0;
       int secondCount = 0;
       int length = nums.size();
       for(int i=0;i<length;i++){
    	   int cur = nums.get(i);
    	   if(firstCount == 0){
    		   first = cur;
    		   firstCount++;
    	   }
    	   else if(cur == first){
    		   firstCount++;
    	   }
    	   else if(secondCount == 0){
    		   second = cur;
    		   secondCount++;
    	   }
    	   else if(cur == second){
    		   secondCount++;
    	   }
    	   else{
    		   firstCount--;
    		   secondCount--;
    	   }
           //System.out.println("first="+first+"  firstCount="+firstCount+"  second="+second+"   secondCount="+secondCount);
       }
       //System.out.println("first="+first+"  firstCount="+firstCount+"  second="+second+"   secondCount="+secondCount);
       firstCount = 0;
       secondCount = 0;
       for(int i=0;i<length;i++){
           int cur = nums.get(i);
           if(cur == first){
               firstCount++;
           }
           else if(cur == second){
               secondCount++;
           }
       }
       //System.out.println("firstCount="+firstCount+"   secondCount="+secondCount);
       return firstCount > secondCount? first:second;
    }
	public static void main(String[] args){
		int[] array = {1,1,1,1,2,2,3,3,4,4,4};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			nums.add(array[i]);
		}
		int res = majorityNumber(nums);
		System.out.println("res = "+res);
	}
}
