package array;

import java.util.Arrays;
//space : O(N)        time: (NlogN) 
public class MergeSort {
	public static void mergeSort(int[] array){
		if(array == null || array.length <= 1){
			return;
		}
		int length = array.length;
		int mid = (length - 1)/2;
		int[] left = Arrays.copyOfRange(array,0,mid+1);
		int[] right = Arrays.copyOfRange(array,mid+1,length);
		mergeSort(left);
		mergeSort(right);
		merge(left,right,array);
	}
	public static void merge(int[] front,int[] back,int[] total){
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < front.length && j < back.length){
			if(front[i] <= back[j]){
				total[k] = front[i];
				i++;
			}
			else{
				total[k] = back[j];
				j++;
			}
			k++;
		}
		while(i < front.length && k < total.length){
			total[k] = front[i];
			i++;
			k++;
		}
		while(j < back.length && k < total.length){
			total[k] = back[j];
			j++;
			k++;
		}
	}
	public static void main(String args[]){
		int[] array = {4,6,2,8,5,3,0,9,1};
		mergeSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
