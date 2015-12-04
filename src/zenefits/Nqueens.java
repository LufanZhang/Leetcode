package zenefits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Nqueens {
	/***********************************************************************************/
//	public static int maxThreats(int[] queens){
//		if(queens == null || queens.length == 0){
//			return 0;
//		}
//		int length = queens.length;
//		int res = 0;
//		int[] count = new int[length];
//		for(int i=0;i<length;i++){
//			int j = queens[i] - 1;
//			boolean left = false;
//			boolean right = false;
//			for(int m=i-1;m>=0;m--){
//				int n = queens[m] - 1;
//				if(!left && (j-i) == (n-m)){
//					count[i] += 1;
//					count[m] += 1;
//					left = true;
//				}
//				if(!right && (j+i) == (n+m)){
//					count[i] += 1;
//					count[m] += 1;
//				}
//				res = Math.max(res,Math.max(count[i],count[m]));
//			}
//			if(res == 4){
//				break;
//			}
//		}
//		return res;
//	}
	/***********************************************************************************/
	public static int maxThreats(List<Integer> queens){
		if(queens == null || queens.size() == 0){
			return 0;
		}
		int length = queens.size();
		int[] count = new int[length];
		HashMap<Integer,Integer> left = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> right = new HashMap<Integer,Integer>();
		int res = 0;
		for(int i=0;i<length;i++){
			int j = queens.get(i) - 1;
			int upLeft = j - i;
			int upRight = j + i;
			if(left.containsKey(upLeft)){
				count[i] += 1;
				int pre = left.get(upLeft);
				count[pre] += 1;
				left.put(upLeft,i);
				res = Math.max(res,Math.max(count[pre], count[i]));
			}
			if(right.containsKey(upRight)){
				count[i] += 1;
				int pre = right.get(upRight);
				count[pre] += 1;
				right.put(upRight,i);
				res = Math.max(res,Math.max(count[pre], count[i]));
			}
			left.put(j-i,i);
			right.put(j+i, i);
			if(res == 4){
				break;
			}
		}
		return res;
	}
	/***********************************************************************************/
//	public static int get_threat(int row, int col, List<Integer> a)
//	{
//	    int n = a.size();
//	    int i = row - 1;
//	    int res = 0;
//	    while(i >= 0)
//	    {
//	        if(row - i == col - (a.get(i) - 1))
//	            break;
//	        	i--;
//	    }
//	    if(i >= 0){
//	    	res++;
//	    }
//	    i = row + 1;
//	    while(i < n)
//	    {
//	        if(i - row == a.get(i) - 1 - col){
//	        	break;
//	        }
//	        	i++;
//	    }
//	    if(i < n){
//	    	res++;
//	    }
//	    i = row - 1;
//	    while(i >= 0){
//	        if(row - i == a.get(i) - 1 - col){
//	        	break;
//	        }
//	        i--;
//	    }
//	    if(i >= 0){
//	        res++;
//	    }  
//	    i = row + 1;
//	    while(i < n)
//	    {
//	        if(i - row == col - (a.get(i) - 1)){
//	        	break;
//	        }
//	        i++;
//	    }
//	    if(i < n){
//	    	res++;
//	    }
//	    return res;
//	}
//	public static int maxThreats(List<Integer> a) {
//	    int n = a.size();
//	    if(n <= 1)
//	        return 0;
//	    int res = 0;
//	    for(int i = 0; i < n; i++){
//	        int temp_res = 0;
//	        temp_res = get_threat(i, a.get(i) - 1, a);
//	        res = Math.max(res, temp_res);
//	    }
//	    return res;
//	}
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int[] queens = new int[n];
        List<Integer> queens = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int cur = scanner.nextInt();
            queens.add(cur);
        }
        int result = maxThreats(queens);
        System.out.println(result);
        scanner.close();
	}
}
