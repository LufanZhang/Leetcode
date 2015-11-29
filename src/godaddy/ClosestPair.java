package godaddy;

import java.util.ArrayList;
import java.util.List;

public class ClosestPair {
	public static List<Integer> findPair(int[] array){
		List<Integer> res = new ArrayList<Integer>();
		if(array == null || array.length == 0){
			return res;
		}
		int length = array.length;
		int min = Integer.MAX_VALUE;
		for(int i=1;i<length;i++){
			int diff = array[i] - array[i-1];
			if(diff < min){
				min = diff;
			}
		}
		for(int i=1;i<length;i++){
			if(array[i]-array[i-1] == min){
				res.add(array[i-1]);
				res.add(array[i]);
			}
		}
		return res;
	}
	public static void main(String args[]){
		int[] array = {1,2,4,5,6};
		List<Integer> res = findPair(array);
		System.out.println(res);
	}
}
