package godaddy;

import java.util.Arrays;

public class Zigzag {
	public static int[] zigzagIter(int[] array){
		if(array == null || array.length == 0){
			return array;
		}
		int length = array.length;
		int[] res = new int[length];
		Arrays.sort(array);
		int start = 0;
		int end = length-1;
		int index = 0;
		while(index < length){
			if(index < length){
				res[index++] = array[end--];
			}
			if(index < length){
				res[index++] = array[start++];
			}
		}
		return res;
	}
	public static void main(String args[]){
		int[] array = {4,6,3,8,1};
		int[] res = zigzagIter(array);
		for(int i=0;i<array.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
