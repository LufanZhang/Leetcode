package array;

import java.util.Random;

public class ShuffleCard {
	public static void shuffle(int[] card){
		int length = card.length;
		Random r = new Random();
		for(int i=0;i<length;i++){
			int index = r.nextInt(length-i) + i;
			int temp = card[i];
			card[i] = card[index];
			card[index] = temp;
			
		}
	}
	public static void main(String[] args){
		int[] card = new int[52];
		for(int i=0;i<card.length;i++){
			card[i] = i+1;
		}
		shuffle(card);
		for(int i=0;i<card.length;i++){
			System.out.print(card[i]+" ");
		}
	}
}
