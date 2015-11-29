package backTracking;

import java.util.ArrayList;

public class divideArrayIntoSame {
	public static int sum = Integer.MAX_VALUE;
	public static int[] divide(int[] array){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || array.length == 0){
			return null;
		}
		int total = 0;
		int length = array.length;
		int[] res = new int[length/2];
		for(int i=0;i<length;i++){
			total += array[i];
		}
		int half = total / 2;
		helper(array,0,half,list,res);
		return res;
	}
	public static void helper(int[] array,int start,int half,ArrayList<Integer> list,int[] res){
		if(list.size() == array.length/2){
			int temp = 0;
			for(int i=0;i<list.size();i++){
				temp += list.get(i);
			}
			if(Math.abs(half - temp) < sum){
				for(int i=0;i<list.size();i++){
					res[i] = list.get(i);
				}
				sum = Math.abs(half - temp);
			}
			return;
		}
		for(int i=start;i<array.length;i++){
			list.add(array[i]);
			helper(array,i+1,half,list,res);
			list.remove(list.size()-1);
		}
	}
	public static void main(String args[]){
		int[] array = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		int[] res = divide(array);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+"   ");
		}
	}
}
