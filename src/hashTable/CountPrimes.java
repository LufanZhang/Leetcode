package hashTable;

import java.util.HashSet;

public class CountPrimes {
	public static int countPrimes(int n) {
		 if(n <= 1){
	           return 0;
	       }
	       if(n == 2){
	           return 0;
	       }
	       //int total = n - 2;
	       int max = (int)Math.sqrt(n);
	       boolean[] res = new boolean[n];
	      // HashSet<Integer> set = new HashSet<Integer>();
	       for(int i=2;i<=max;i++){
	           int cur = i * i;
	           while(true){
	               if(cur >= n){
	                   break;
	               }
	               res[cur] = false;
	               cur += i;
	           }
	       }
	       int count = 0;
	       for(int i=0;i<res.length;i++){
	    	   System.out.print(res[i] + "  ");
	       }
	       for(int i=2;i<res.length;i++){
	           if(res[i] == true){
	               count++;
	           }
	       }
	       return count;
	    }
//	 public static int countPrimes(int n) {
//	        int res = 0;
//	        boolean[] used = new boolean[n];
//	        int max = (int) Math.sqrt(n);
//	        System.out.println("i = "+max);
//	        for (int i = 2; i <= max; i++) {
//	         if (!used[i - 1]) {
//	            int temp = i * i;
//	            while (temp < n) {
//	                used[temp - 1] = true;
//	                temp += i;
//	            }
//	        }
//	        }
//	        for (int i = 2; i < n; i++) {
//	        if (!used[i - 1]) {
//	            res++;
//	        }
//	        }
//	        return res;
//	    }
	 public static void main(String args[]){
		 int n = 3;
		 int res = countPrimes(n);
		 System.out.println(res);
	 }
}
