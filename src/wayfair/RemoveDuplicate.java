package wayfair;

import java.util.HashSet;

//给一个数组，返回一个没有duplicate item的数组
public class RemoveDuplicate {
	public static int[] remove(int[] array){
		if(array == null || array.length == 0){
			return array;
		}
		int index = 0;
		int runner = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		int length = array.length;
		for(int i=0;i<length;i++){
			int cur = array[i];
			if(set.contains(cur)){
				runner++;
			}
			else{
				array[index++] = array[runner++];
				set.add(cur);
			}
		}
		int[] res = new int[index];
		for(int i=0;i<index;i++){
			res[i] = array[i];
		}
		return res;
	}
	public static void main(String args[]){
		int[] array = {3,5,3,4,25,6,34,4,6,2,3};
		int[] res = remove(array);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
