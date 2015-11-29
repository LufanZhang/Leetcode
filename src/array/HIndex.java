package array;

import java.util.Arrays;
import java.util.Comparator;

public class HIndex {
	 public static int hIndex(int[] citations) {
	        if(citations == null || citations.length == 0){
	            return 0;
	        }
	        int length = citations.length;
	        Arrays.sort(citations);
	        int start = 0;
	        int end = length - 1;
	        while(start < end){
	            int temp = citations[start];
	            citations[start] = citations[end];
	            citations[end] = temp;
	            start++;
	            end--;
	        }
	        for(int i=0;i<length;i++){
	        	System.out.print(citations[i]+" ");
	        }
	        System.out.println("");
	        if(citations[0] < 1 || citations[length-1] > length){
	            return 0;
	        }
	        for(int i=0;i<length;i++){
	            if(citations[i] == i+1){
	                return i+1;
	            }
	        }
	        return 0;
	    }
	 public static void main(String args[]){
		 int[] citations = {100};
		 int res = hIndex(citations);
		 System.out.println("res="+res);
	 }
}
