package array;

import java.util.Arrays;
import java.util.List;

public class NumberofAirplanesintheSky {
	 public static int countOfAirplanes(List<Interval> airplanes) { 
	        // write your code here
	        if(airplanes == null || airplanes.size() == 0){
	            return 0;
	        }
	        int length = airplanes.size();
	        int[] start = new int[length];
	        int[] end = new int[length];
	        for(int i=0;i<length;i++){
	            start[i] = airplanes.get(i).start;
	            end[i] = airplanes.get(i).end;
	        }
	        Arrays.sort(start);
	        Arrays.sort(end);
	        int i = 0;
	        int j = 0;
	        int res = 0;
	        int total = 0;
	        while(i < length){
	            if(start[i] < end[j]){
	                total++;
	                if(total > res){
	                    res = total;
	                }
	                i++;
	            }
	            else{
	                total--;
	                j++;
	            }
	        }
	        return res;
	    }
	
	
}
