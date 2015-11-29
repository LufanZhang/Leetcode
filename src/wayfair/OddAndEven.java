package wayfair;

public class OddAndEven {
//ignore the original order,just swap//不用管order得
//	public static void oddAndEven(int[] array){
//		if(array == null || array.length == 0){
//			return;
//		}
//		int length = array.length;
//		int start = 0;
//		int end = length - 1;
//		//the element after end is even
//		while(start < end){
//			int cur = array[start];
//			if((cur & 1) == 1){ //odd
//				start++;
//			}
//			else{ //even
//				swap(array,start,end);
//				end--;
//			}
//		}
//	}
	
	
	//keep the original order//要管order space-O(n)
//	public static int[] oddAndEven(int[] array){
//		if(array == null || array.length == 0){
//			return array;
//		}
//		int length = array.length;
//		int[] res = new int[length];
//		int index = 0;
//		for(int i=0;i<length;i++){
//			if((array[i] & 1) == 1){
//				res[index++] = array[i];
//			}
//		}
//		for(int i=0;i<length;i++){
//			if((array[i] & 1) ==0){
//				res[index++] = array[i];
//			}
//		}
//		return res;
//	}
	
	
//keep the order with O(1) space,用bubble sort
	public static int[] oddAndEven(int[] array){
		if(array == null || array.length == 0){
			return array;
		}
		int length = array.length;
		for(int i=0;i<length;i++){
			if(i == 0 || (array[i] & 1) == 0){ //array[i] is odd
				continue;
			}
			else{
				int index = i;
				while(index > 0 && (array[index-1] & 1) == 0){
					swap(array,index,index-1);
					index--;
				}
			}
		}
		return array;
	}
	
	
	public static void swap(int[] array,int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String args[]){
		int[] array = {1,2,3,4,5,6,7};
		int[] res = oddAndEven(array);
		for(int i=0;i<array.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
