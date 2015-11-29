package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TriangleCount {
	 public static int triangleCount(int S[]) {
	        // write your code here
	        if(S == null || S.length <= 2){
	            return 0;
	        }
	        Arrays.sort(S);
	        int res = 0;
	        int length = S.length;
	        for(int i=0;i<length-2;i++){
	            for(int j=i+1;j<length-1;j++){
	                int start = j+1;
	                int end = length-1;
	                int target = S[i] + S[j];
	                while(start < end -1){
	                    int mid = start + (end - start) / 2;
	                    if(mid < target){
	                        start = mid;
	                    }
	                    else{
	                        end = mid;
	                    }
	                }
	                int index = end+1;
	                if(S[start] >= target){
	                    index = start;
	                }
	                else if(S[end] >= target){
	                    index = end;
	                }
	                res += index - j - 1;
	            }
	        }
	        return res;
	    }
	 //System.out.println()
	 public static void main(String[] args){
		 int S[] = {1,2,3,4,5};
		 triangleCount(S);
		 char c = 'a';
		 HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		 Iterator iter = map.entrySet().iterator();
		 while(iter.hasNext()){
			 Map.Entry entry = (Map.Entry)iter.next();
			 
		 }
	 }
}
