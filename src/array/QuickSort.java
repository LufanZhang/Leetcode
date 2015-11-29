package array;
//把第一个设置为pivot，然后遍历这个数组，左边是小于它的，右边是大于等于它的
//wall的右边是大于等于它的，wall以及pivot的左边是小于pivot的，
//这时wall与pivot互换位置，这样wall右边是大于等于wall的，左边是小于wall的，此时说明wall的位置放的是正确的数
//然后recursive，wall的左边（不包括wall）以及wall的右边（也不包括wall）
public class QuickSort {
	public static void quickSort(int[] array){
		if(array == null || array.length <= 1){
			return;
		}
		int length = array.length;
		helper(array,0,length-1);
	}
	//the element after wall is bigger than sig
	public static void helper(int[] array,int start,int end){
		if(start >= end){
			return;
		}
		int sig = array[start];
		int wall = end;
		int runner = start+1; // 从pivot的下一个只开始看起
		while(runner <= wall){
			if(array[runner] < sig){
				runner++;
			}
			else{
				swap(array,runner,wall);
				wall--;
			}
		}
		swap(array,start,wall);
		helper(array,start,wall-1);
		helper(array,wall+1,end);
	}
	public static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String args[]){
		int[] array = {4,3,2,4};
		quickSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
