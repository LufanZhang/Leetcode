package array;

public class MaximizeNumberwithSwap {
	public static int maximizeResult(int n) {
		char[] array = String.valueOf(n).toCharArray();
		int length = array.length;
		int index = length;
		for(int i=1;i<length;i++){
			if(array[i] > array[i-1]){
				index = i;
				break;
			}
		}
		if(index == length){
			return n;
		}
		System.out.println("index = "+index);
		int max = index;
		char maxChar = array[index];
		for(int i=index;i<length;i++){
			if(maxChar <= array[i]){
				max = i;
				maxChar = array[i];
			}
		}
		System.out.println("max = "+max);
		for(int i=0;i<index;i++){
			if(array[i] < maxChar){
				array[max] = array[i];
				array[i] = maxChar;
				break;
			}
		}
		return Integer.parseInt(String.valueOf(array));
	}
	public static void main(String args[]){
		int n = 867473;
		int res = maximizeResult(n);
		System.out.println("res = "+res);
	}
}
