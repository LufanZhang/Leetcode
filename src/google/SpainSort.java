package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SpainSort {
	public static List<String> sortSpain(List<String> list){
		Comparator<String> comparator = new Comparator<String>(){
			public int compare(String s1,String s2){
				int length1 = s1.length();
				int length2 = s2.length();
				int index1 = 0;
				int index2 = 0;
				while(index1 < length1 && index2 < length2){
					if(index1 < length1-1 && s1.charAt(index1) == 'c' && s1.charAt(index1+1) == 'h' && index2 < length2-1 && s2.charAt(index2) == 'c' && s2.charAt(index2+1) == 'h'){
						index1 += 2;
						index2 += 2;
					}
					else if(index1 < length1-1 && s1.charAt(index1) == 'c' && s1.charAt(index1+1) == 'h'){
						if(s2.charAt(index2) > 'c'){
							return -1;
						}
						else{
							return 1;
						}
					}
					else if(index2 < length2-1 && s2.charAt(index2) == 'c' && s2.charAt(index2+1) == 'h'){
						if(s1.charAt(index1) > 'c'){
							return 1;
						}
						else{
							return -1;
						}
					}
					else{
						if(s1.charAt(index1) == s2.charAt(index2)){
							index1++;
							index2++;
						}
						else if(s1.charAt(index1) < s2.charAt(index2)){
							return -1;
						}
						else{
							return 1;
						}
					}
				}
				return length1 - length2;
			}
		};
		Collections.sort(list,comparator);
		return list;
	}
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("abch");
		list.add("chba");
		list.add("bch");
		list.add("ach");
		list.add("bd");
		sortSpain(list);
		System.out.println(list);
		StringBuilder sb = new StringBuilder();
		int[] array = {1,2,4,5,6,7};
		List<Integer> l = new ArrayList<Integer>();
	}
}
