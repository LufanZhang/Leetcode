package array;

import java.util.Random;

public class RandomShuffleArray {
	public static void shuffle(int[] array){
		int length = array.length;
		Random random = new Random();
		for(int i=length-1;i>=0;i--){
			int cur = random.nextInt(i+1);
			int temp = array[i];
			array[i] = array[cur];
			array[cur] = temp;
		}
	}
	public static void main(String args[]){
		int[] array = new int[52];
		for(int i=0;i<52;i++){
			array[i] = i+1;
		}
		shuffle(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
