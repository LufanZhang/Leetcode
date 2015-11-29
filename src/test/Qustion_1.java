package test;

import java.util.HashMap;

public class Qustion_1 {
	public static void findCharacter(String s){
		if(s == null || s.length() == 0){
			System.out.println("null");
			return;
		}
		int length = s.length();
		int half = length/2 + 1;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<length;i++){
			char cur = s.charAt(i);
			if(map.containsKey(cur)){
				int num = map.get(cur);
				if(num >= half){
					System.out.println(cur);
					return;
				}
				else{
					map.put(cur, num + 1);
				}
			}
			else{
				map.put(cur, 1);
			}
		}
			System.out.println("null");
	}
	public static void main(String args[]){
		String s = "abcdeabbad";
		 findCharacter(s);
		
	}
}
